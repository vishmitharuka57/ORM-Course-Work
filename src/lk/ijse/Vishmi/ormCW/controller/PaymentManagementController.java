package lk.ijse.Vishmi.ormCW.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.Vishmi.ormCW.dto.PaymentDTO;
import lk.ijse.Vishmi.ormCW.service.ServiceFactory;
import lk.ijse.Vishmi.ormCW.service.custom.PendingKeyMoneyService;

import java.util.List;

public class PaymentManagementController {
    public JFXTextField txtRegId;
    public JFXTextField txtStdId;
    public JFXTextField txtName;
    public JFXTextField txtRoomType;
    public JFXTextField txtRegDate;
    public JFXTextField txtKeyMoney;
    public TableView tblPayment;
    public TableColumn colRegId;
    public TableColumn colStudentId;
    public TableColumn colName;
    public TableColumn colRoomType;
    public TableColumn colRegDate;
    public TableColumn colKeyMoney;
    public TableColumn colPaymentStatus;
    public TextField studentId;
    public JFXComboBox txtPaymentStatus;
    public JFXTextField txtRoomID;
    public TableColumn colRoomId;

    final private PendingKeyMoneyService pendingKeyMoneyService = (PendingKeyMoneyService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.PENDINGKEYMONEY);


    public void initialize(){
        colRegId.setCellValueFactory(new PropertyValueFactory<>("regId"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("roomType"));
        colRegDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colPaymentStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        loadAllData();

        txtRegId.setEditable(false);
        txtStdId.setEditable(false);
        txtName.setEditable(false);
        txtRoomType.setEditable(false);
        txtRegDate.setEditable(false);
        txtKeyMoney.setEditable(false);
        txtPaymentStatus.setEditable(false);
        txtRoomID.setEditable(false);

        txtRegId.setDisable(true);
        txtStdId.setDisable(true);
        txtName.setDisable(true);
        txtRoomType.setDisable(true);
        txtRegDate.setDisable(true);
        txtKeyMoney.setDisable(true);
        txtPaymentStatus.setDisable(true);
        txtRoomID.setDisable(true);

        tblPayment.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue!= null){
                txtRegId.setDisable(false);
                txtStdId.setDisable(false);
                txtName.setDisable(false);
                txtRoomType.setDisable(false);
                txtRegDate.setDisable(false);
                txtKeyMoney.setDisable(false);
                txtPaymentStatus.setDisable(false);
                txtRoomID.setDisable(false);

                /*txtRegId.setText(newValue.getRegId());
                txtStdId.setText(newValue.getStudentId());
                txtName.setText(newValue.getName());
                txtRoomType.setText(newValue.getRoomType());
                txtRegDate.setText(newValue.getRegDate());
                txtKeyMoney.setText(String.valueOf(newValue.getKeyMoney()));
                txtPaymentStatus.setValue(newValue.getStatus());
                txtRoomID.setText(newValue.getRoomId());*/
            }else {
                txtRegId.clear();
                txtStdId.clear();
                txtName.clear();
                txtRoomType.clear();
                txtRegDate.clear();
                txtKeyMoney.clear();
                txtPaymentStatus.getSelectionModel().clearSelection();
                txtRoomID.clear();
            }
        });

        txtPaymentStatus.getItems().addAll("Paid","Paid Later");
    }

    private void loadAllData() {
        try {
            List<PaymentDTO> list = pendingKeyMoneyService.getAllPendingKeyMoneyReservationsUsingReservationStatus();

            for (PaymentDTO dto:list
            ) {
                txtPaymentStatus.getItems().add(
                        new PaymentDTO(dto.getRegId(),dto.getStudentId(),dto.getName(),dto.getRoomType(),dto.getRegDate(),dto.getKeyMoney(),dto.getStatus(),dto.getRoomId())
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
        try {
            boolean b = pendingKeyMoneyService.updateReservationUsingId(txtRegId.getText(), String.valueOf(txtPaymentStatus.getValue()));
            if (b){

                new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
            }
            tblPayment.getItems().remove(tblPayment.getSelectionModel().getSelectedItem());
            tblPayment.getSelectionModel().clearSelection();
            txtRegId.clear();
            txtStdId.clear();
            txtName.clear();
            txtRoomType.clear();
            txtRegDate.clear();
            txtKeyMoney.clear();
            txtPaymentStatus.getSelectionModel().clearSelection();
            txtRoomID.clear();

            txtRegId.setDisable(false);
            txtStdId.setDisable(false);
            txtName.setDisable(false);
            txtRoomType.setDisable(false);
            txtRegDate.setDisable(false);
            txtKeyMoney.setDisable(false);
            txtPaymentStatus.setDisable(false);
            txtRoomID.setDisable(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void newOnAction(ActionEvent actionEvent) {
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }
}
