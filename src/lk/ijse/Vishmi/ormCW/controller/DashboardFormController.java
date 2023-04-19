package lk.ijse.Vishmi.ormCW.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Vishmi.ormCW.util.Navigation;
import lk.ijse.Vishmi.ormCW.util.Routes;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane dashPane;

    public void createRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.REGISTER, dashPane);
    }

    public void studentManagerOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENT, dashPane);
    }

    public void RoomManagementOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ROOM, dashPane);
    }

    public void PaymentManagementOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENT, dashPane);
    }

    public void UsermanagementOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.USER, dashPane);
    }
}
