package lk.ijse.Vishmi.ormCW.controller;

import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Vishmi.ormCW.util.Navigation;
import lk.ijse.Vishmi.ormCW.util.Routes;

import java.io.IOException;

public class HomePageController {
    public AnchorPane homePane;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.LOGIN, homePane);
    }
}
