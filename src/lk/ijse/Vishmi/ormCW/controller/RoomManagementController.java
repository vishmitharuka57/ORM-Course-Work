package lk.ijse.Vishmi.ormCW.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import lk.ijse.Vishmi.ormCW.dto.RoomDTO;
import lk.ijse.Vishmi.ormCW.service.ServiceFactory;
import lk.ijse.Vishmi.ormCW.service.custom.RoomService;
import lk.ijse.Vishmi.ormCW.util.Regex;
import lk.ijse.Vishmi.ormCW.view.tm.RoomTM;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class RoomManagementController {
    public JFXTextField txtRoomTypeId;
    public JFXTextField txtRoomType;
    public JFXTextField txtNoOfRooms;
    public JFXTextField txtKeyMoney;
    public TableView tblRoom;
    public TableColumn colRoomTypeId;
    public TableColumn colRoomType;
    public TableColumn colNoOfRooms;
    public TableColumn colKeyMoney;
    public TextField RoomId;
    public Button btnSave;
    public Button btnUpdate;
    public Button btnDelete;
    public Button btnNew;
    public Button btnSearch;


    private final RoomService roomService = (RoomService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.ROOM);

    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    public void initialize(){
        textClearAndBtnDisable();
      /*  cmbType.getItems().addAll("Non-AC","Non-AC / Food","AC","AC / Food");*/
        loadAllRooms();

        colRoomTypeId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colNoOfRooms.setCellValueFactory(new PropertyValueFactory<>("qty"));

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);

            if (newValue != null) {
                txtRoomTypeId.setText(newValue.getRoomTypeId());
                txtRoomType.setText(newValue.getType());
                txtKeyMoney.setText(String.valueOf(newValue.getKeyMoney()));
                txtNoOfRooms.setText(String.valueOf(newValue.getNoOfRooms()));

                txtRoomTypeId.setDisable(false);
                txtRoomType.setDisable(false);
                txtKeyMoney.setDisable(false);
                txtNoOfRooms.setDisable(false);


            }
        });
        Pattern idPattern = Pattern.compile("^RM-[0-9]{4}$");
        Pattern keyMoneyPattern = Pattern.compile("^[1-9][0-9]*(.[0-9]{1,2})?$");
        Pattern qtyPattern = Pattern.compile("^[1-9][0-9]*$");

        map.put(txtRoomTypeId,idPattern);
        map.put(txtKeyMoney,keyMoneyPattern);
        map.put(txtNoOfRooms,qtyPattern);


    }

    private void loadAllRooms() {
        try {
            List<RoomDTO> allRooms = roomService.getAllRooms();
            for (RoomDTO roomDTO:allRooms) {
                tblRoom.getItems().add(
                        new RoomTM(roomDTO.getRoomTypeId(),roomDTO.getRoomType()roomDTO.getNoOfRooms(),roomDTO.getKeyMoney())
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void textClearAndBtnDisable() {
        txtRoomTypeId.clear();
        txtRoomType.clear();
        txtKeyMoney.clear();
        txtNoOfRooms.clear();

        txtRoomTypeId.setDisable(true);
        txtRoomType.setDisable(true);
        txtKeyMoney.setDisable(true);
        txtNoOfRooms.setDisable(true);

        btnSave.setDisable(true);
        btnDelete.setDisable(true);

    }


    public void saveOnAction(ActionEvent actionEvent) {
        String roomID = txtRoomTypeId.getText();
        String type = txtRoomType.getText();
        int noOfRooms = Integer.parseInt(txtNoOfRooms.getText());
        double keyMoney = Double.parseDouble(txtKeyMoney.getText());



        try {
            if (btnSave.getText().equalsIgnoreCase("save")) {
                boolean save= roomService.saveRoom(new RoomDTO(roomID,type,keyMoney,noOfRooms));

                tblRoom.getItems().add(new RoomTM(roomID,type,keyMoney,noOfRooms));
                if (!save){
                    new Alert(Alert.AlertType.ERROR,"Failed to Saved the User").show();
                }
                textClearAndBtnDisable();

            }else {
                boolean updated= roomService.updateRoom(new RoomDTO(roomID,type,keyMoney,noOfRooms));

                if (updated){
                    new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                }

                RoomTM selectedItem = (RoomTM) tblRoom.getSelectionModel().getSelectedItem();
                selectedItem.setRoomTypeId(roomID);
                selectedItem.setType(type);
                selectedItem.setKeyMoney(keyMoney);
                selectedItem.setNoOfRooms(noOfRooms);

                tblRoom.refresh();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you Want Delete", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> buttonType =alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            try {
                String roomId = tblRoom.getSelectionModel().getSelectedItem().getRoomTypeId();
                boolean b = roomService.deleteRoom(roomId);
                if (b){
                    new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
                }
                tblRoom.getItems().remove(tblRoom.getSelectionModel().getSelectedItem());
                tblRoom.getSelectionModel().clearSelection();
                textClearAndBtnDisable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void newOnAction(ActionEvent actionEvent) {
        txtRoomTypeId.setDisable(false);
        txtRoomType.setDisable(false);
        txtKeyMoney.setDisable(false);
        txtNoOfRooms.setDisable(false);

        txtRoomTypeId.clear();
        txtRoomType.clear();
        txtKeyMoney.clear();
        txtNoOfRooms.clear();

        txtRoomTypeId.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblRoom.getSelectionModel().clearSelection();

    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

    /*public void textFields_Key_Released(KeyEvent keyEvent) {
        Regex.validate(map, (JFXButton) btnSave);

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response = Regex.validate(map, (JFXButton) btnSave);

            if (response instanceof TextField) {
                TextField textField = (TextField) response;
                textField.requestFocus();// if there is a error just focus it
            }
        }
    }*/
}
