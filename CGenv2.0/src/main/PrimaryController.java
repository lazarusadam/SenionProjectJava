package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class PrimaryController {


    @FXML
    Button btnPF;
    @FXML
    Button btnDnD;
    @FXML
    AnchorPane primaryPane;



    public void pfClicked(ActionEvent actionEvent) throws Exception {
        try{
            AnchorPane pfpane = FXMLLoader.load(getClass().getResource("pathfinder.fxml"));
            primaryPane.getChildren().setAll(pfpane);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void dndClicked(ActionEvent actionEvent) {
        try{
           AnchorPane ddPane = FXMLLoader.load((getClass().getResource("dnd.fxml")));
           primaryPane.getChildren().setAll(ddPane);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
