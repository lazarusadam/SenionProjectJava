package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LoadController implements Initializable {
    public Button cancelButton;
    public Button loadButton;
    public TableView charTable;
    public TableColumn cNameCol;
    public TableColumn cClassCol;


    Statement state = null;
    ObservableList<String> charList = FXCollections.observableArrayList();


    public void openLoader() {
        int size = 0;
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }catch (ClassNotFoundException e){
            System.out.println("Drivern not found.");
            e.printStackTrace();

        }

        try{
            String access = "E://SeniorSeminar/D&D.accdb";
            String dbURL = "jdbc:ucanaccess://" + access;

            Connection conn = DriverManager.getConnection(dbURL);
            state = conn.createStatement();
            ResultSet rs = state.executeQuery("Select * FROM Character");


            size = rs.getFetchSize();
            for (int x = 0; x < size; x++){
                int ID = rs.getInt("CharID");
                charList.add(rs.getString("Character Name"));
                        
            }



        } catch(SQLException e){
            e.printStackTrace();
        }



        for (int x = 0; x < size; x++){
            


        }
    }



    public void cancelSelection(ActionEvent actionEvent) {
    }

    public void loadCharacter(ActionEvent actionEvent) {
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }
}
