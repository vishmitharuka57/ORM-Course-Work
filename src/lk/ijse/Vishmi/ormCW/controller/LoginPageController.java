package lk.ijse.Vishmi.ormCW.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Vishmi.ormCW.util.Navigation;
import lk.ijse.Vishmi.ormCW.util.Routes;

import java.io.IOException;

public class LoginPageController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane loginPane;

    public void signInOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, loginPane);
    }

    public void createNewAccountOnAction(ActionEvent actionEvent) {
    }
}
