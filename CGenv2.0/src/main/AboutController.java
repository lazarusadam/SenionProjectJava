package main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class AboutController {

    public Button okButton;

    public void okPressed(ActionEvent actionEvent) {
       Stage stage = (Stage) okButton.getScene().getWindow();
       stage.close();
    }
}
