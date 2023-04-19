package lk.ijse.Vishmi.ormCW.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserManagementController {
    public JFXTextField txtUserId;
    public JFXTextField txtName;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtDob;
    public JFXTextField txtUserName;
    public JFXTextField txtContact;
    public TableView tblUser;
    public TableColumn colUserId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colDob;
    public TableColumn colContact;
    public TableColumn colUserName;
    public TableColumn colPassword;
    public TextField userId;
    public JFXTextField txtPassword;


    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();
    private final UserBO userBO = (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize(){
        textClearAndBtnDisable();
        loadALLUsers();

        colUserId.setCellValueFactory(new PropertyValueFactory<>("userId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTelNo.setCellValueFactory(new PropertyValueFactory<>("telNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));

        tblUser.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnSave.setText(newValue != null ? "Update" : "Save");
            btnSave.setDisable(newValue == null);

            if (newValue != null) {
                txtUserId.setText(newValue.getUserId());
                txtName.setText(newValue.getName());
                txtTelNo.setText(newValue.getTelNo());
                txtEmail.setText(newValue.getEmail());
                txtUserName.setText(newValue.getUserName());
                txtPassword.setText(newValue.getPassword());

                txtUserId.setDisable(false);
                txtName.setDisable(false);
                txtTelNo.setDisable(false);
                txtEmail.setDisable(false);
                txtUserName.setDisable(false);
                txtPassword.setDisable(false);

            }
        });

        Pattern namePattern = Pattern.compile("^[A-z ]{3,30}$");
        Pattern telNoPattern = Pattern.compile("^(?:7|0|(?:\\+94))(70|77|78|74|76|72|71)[0-9]{7}$");
        Pattern eMailPattern = Pattern.compile("^[A-z0-9]{3,}@(gmail|ymail|yahoomail).com$");
        Pattern userNamePattern = Pattern.compile("^[A-z0-9@.]{3,10}$");
        Pattern passwordPattern = Pattern.compile("^[A-z0-9@.]{3,10}$");


        map.put(txtName,namePattern);
        map.put(txtTelNo,telNoPattern);
        map.put(txtEmail,eMailPattern);
        map.put(txtUserName,userNamePattern);
        map.put(txtPassword,passwordPattern);


    }

    private void loadALLUsers() {
        try {
            List<UserDTO> allUsers = userBO.getAllUsers();
            for (UserDTO userDTO:allUsers
            ) {
                tblUser.getItems().add(
                        new UserTM(userDTO.getUserId(),userDTO.getName(),userDTO.getTelNo(),userDTO.getEmail(),userDTO.getUserName(),userDTO.getPassword())
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void textClearAndBtnDisable() {
        txtUserId.clear();
        txtName.clear();
        txtTelNo.clear();
        txtEmail.clear();
        txtUserName.clear();
        txtPassword.clear();

        txtUserId.setDisable(true);
        txtName.setDisable(true);
        txtTelNo.setDisable(true);
        txtEmail.setDisable(true);
        txtUserName.setDisable(true);
        txtPassword.setDisable(true);

        txtUserId.setEditable(false);
        btnSave.setDisable(true);
        btnDelete.setDisable(true);
    }

    private void generateNewId() {

        try {
            String lastUserId = userBO.generateUserId();
            int newId = Integer.parseInt(lastUserId.substring(1, 4))+1;
            if (newId < 10) {
                txtUserId.setText("U00"+newId);
            }else if (newId < 100) {
                txtUserId.setText("U0"+newId);
            }else {
                txtUserId.setText("U"+newId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void saveOnAction(ActionEvent actionEvent) {
        String userID = txtUserId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String telNo = txtTelNo.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        try {
            if (btnSave.getText().equalsIgnoreCase("save")) {

                boolean save=userBO.saveUser(new UserDTO(userID,name,telNo,email,userName,password));
                tblUser.getItems().add(new UserTM(userID,name,telNo,email,userName,password));
                if (!save){
                    new Alert(Alert.AlertType.ERROR,"Failed to Saved the User").show();
                }
                textClearAndBtnDisable();

            }else {
                boolean updated=userBO.updateUser(new UserDTO(userID,name,telNo,email,userName,password));

                if (updated){
                    new Alert(Alert.AlertType.CONFIRMATION,"Updated").show();
                }

                UserTM selectedItem = tblUser.getSelectionModel().getSelectedItem();
                selectedItem.setName(name);
                selectedItem.setTelNo(telNo);
                selectedItem.setEmail(email);
                selectedItem.setUserName(userName);
                selectedItem.setPassword(password);
                tblUser.refresh();

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
                String userId = tblUser.getSelectionModel().getSelectedItem().getUserId();
                boolean b = userBO.deleteUser(userId);
                if (b){
                    new Alert(Alert.AlertType.CONFIRMATION,"Deleted").show();
                }
                tblUser.getItems().remove(tblUser.getSelectionModel().getSelectedItem());
                tblUser.getSelectionModel().clearSelection();
                textClearAndBtnDisable();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void newOnAction(ActionEvent actionEvent) {
        txtUserId.setDisable(false);
        txtName.setDisable(false);
        txtTelNo.setDisable(false);
        txtEmail.setDisable(false);
        txtUserName.setDisable(false);
        txtPassword.setDisable(false);
        txtUserId.clear();

        generateNewId();
        txtName.clear();
        txtTelNo.clear();
        txtEmail.clear();
        txtUserName.clear();
        txtPassword.clear();

        txtName.requestFocus();
        btnSave.setDisable(false);
        btnSave.setText("Save");
        tblUser.getSelectionModel().clearSelection();
    }

    public void searchOnAction(ActionEvent actionEvent) {
    }

   /* public void textFields_Key_Released(KeyEvent keyEvent) {
        ValidationUtil.validate(map,btnSave);

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object response =  ValidationUtil.validate(map,btnSave);;

            if (response instanceof TextField) {
                TextField textField = (TextField) response;
                textField.requestFocus();
            }
        }
    }*/
}
