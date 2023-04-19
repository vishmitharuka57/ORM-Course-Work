package lk.ijse.Vishmi.ormCW.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case HOME:
                window.setTitle("Home Page");
                initUI("HomePage.fxml");
                break;

            case LOGIN:
                window.setTitle("Login Page");
                initUI("loginPage.fxml");
                break;

            case DASHBOARD:
                window.setTitle("DashBoard Page");
                initUI("DashBoardForm.fxml");
                break;

            case REGISTER:
                initUI("CreateRegistration.fxml");
                break;
            case STUDENT:
                initUI("StudentManagement.fxml");
                break;
            case ROOM:
                initUI("RoomManagement.fxml");
                break;
            case PAYMENT:
                initUI("PaymentManagement.fxml");
                break;

            case USER:
                initUI("UserManagement.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/Vishmi/ormCW/view/" + location)));
    }

}
