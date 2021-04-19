package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.stage.StageStyle;
import main.DandD.Fighter;
import main.DandD.Healer;
import main.DandD.Mage;
import main.DandD.Rogue;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DnDController {

    @FXML
    public AnchorPane ddPrimPane;

    public Button btnGenerate;
    public ChoiceBox classCBox;
    public Label lblStat1;
    public Label lblStat2;
    public Label lblStat3;
    public Label lblStat4;
    public Label lblStat5;
    public Label lblStat6;
    public RadioButton rbStr1, rbStr2, rbStr3, rbStr4, rbStr5, rbStr6;
    public RadioButton rbDex1, rbDex2, rbDex3, rbDex4, rbDex5, rbDex6;
    public RadioButton rbInt1, rbInt2, rbInt3, rbInt4, rbInt5, rbInt6;
    public RadioButton rbCha1, rbCha2, rbCha3, rbCha4, rbCha5, rbCha6;
    public RadioButton rbWis1, rbWis2, rbWis3, rbWis4, rbWis5, rbWis6;
    public RadioButton rbCon1, rbCon2, rbCon3, rbCon4, rbCon5, rbCon6;
    public Button btnSet;

    public MenuItem quitMenuItem;

    int str, cha, con, intel, dex, wis;
    String classChoice;

    ToggleGroup strGroup = new ToggleGroup();
    ToggleGroup dexGroup = new ToggleGroup();
    ToggleGroup conGroup = new ToggleGroup();
    ToggleGroup intGroup = new ToggleGroup();
    ToggleGroup wisGroup = new ToggleGroup();
    ToggleGroup chaGroup = new ToggleGroup();



    ArrayList<String> classes = new ArrayList<String>(Arrays.asList("Fighter", "Healer", "Rogue", "Mage"));
    @FXML
    TextArea tfScores = new TextArea();
    @FXML
    Button btnAccept = new Button();
    @FXML
    Button btnDecline = new Button();


    Integer[] scores = new Integer[6];

    @FXML
    private void generate(){
        Dice die = new Dice();
        String text = "";
        for (int i = 0; i < 6; i++){
            scores[i] = die.d6(3, 0);
        }

        for (int x = 0; x < 6; x++){
            text = text + scores[x] + "\n";
        }

        tfScores.setText(text);
        sortScores(scores);
        btnSet.setTooltip(new Tooltip("Each score must be assigned to one attribute"));
        btnGenerate.setDisable(true);

    }


    public void acceptClicked(ActionEvent actionEvent) {



        lblStat1.setText(scores[0].toString());
        lblStat2.setText(scores[1].toString());
        lblStat3.setText(scores[2].toString());
        lblStat4.setText(scores[3].toString());
        lblStat5.setText(scores[4].toString());
        lblStat6.setText(scores[5].toString());
        classCBox.getItems().addAll(classes);


        //set Toggle Groups for ability scores
        rbStr1.setToggleGroup(strGroup);rbStr2.setToggleGroup(strGroup);rbStr3.setToggleGroup(strGroup);
        rbStr4.setToggleGroup(strGroup);rbStr5.setToggleGroup(strGroup);rbStr6.setToggleGroup(strGroup);
        rbStr1.setUserData(0);rbStr2.setUserData(1);rbStr3.setUserData(2);
        rbStr4.setUserData(3);rbStr5.setUserData(4);rbStr6.setUserData(5);

        rbDex1.setToggleGroup(dexGroup);rbDex2.setToggleGroup(dexGroup);rbDex3.setToggleGroup(dexGroup);
        rbDex4.setToggleGroup(dexGroup);rbDex5.setToggleGroup(dexGroup);rbDex6.setToggleGroup(dexGroup);
        rbDex1.setUserData(0);rbDex2.setUserData(1);rbDex3.setUserData(2);
        rbDex4.setUserData(3);rbDex5.setUserData(4);rbDex6.setUserData(5);

        rbCon1.setToggleGroup(conGroup);rbCon2.setToggleGroup(conGroup);rbCon3.setToggleGroup(conGroup);
        rbCon4.setToggleGroup(conGroup);rbCon5.setToggleGroup(conGroup);rbCon6.setToggleGroup(conGroup);
        rbCon1.setUserData(0);rbCon2.setUserData(1);rbCon3.setUserData(2);
        rbCon4.setUserData(3);rbCon5.setUserData(4);rbCon6.setUserData(5);

        rbWis1.setToggleGroup(wisGroup);rbWis2.setToggleGroup(wisGroup);rbWis3.setToggleGroup(wisGroup);
        rbWis4.setToggleGroup(wisGroup);rbWis5.setToggleGroup(wisGroup);rbWis6.setToggleGroup(wisGroup);
        rbWis1.setUserData(0);rbWis2.setUserData(1);rbWis3.setUserData(2);
        rbWis4.setUserData(3);rbWis5.setUserData(4);rbWis6.setUserData(5);

        rbInt1.setToggleGroup(intGroup);rbInt2.setToggleGroup(intGroup);rbInt3.setToggleGroup(intGroup);
        rbInt4.setToggleGroup(intGroup);rbInt5.setToggleGroup(intGroup);rbInt6.setToggleGroup(intGroup);
        rbInt1.setUserData(0);rbInt2.setUserData(1);rbInt3.setUserData(2);
        rbInt4.setUserData(3);rbInt5.setUserData(4);rbInt6.setUserData(5);

        rbCha1.setToggleGroup(chaGroup);rbCha2.setToggleGroup(chaGroup);rbCha3.setToggleGroup(chaGroup);
        rbCha4.setToggleGroup(chaGroup);rbCha5.setToggleGroup(chaGroup);rbCha6.setToggleGroup(chaGroup);
        rbCha1.setUserData(0);rbCha2.setUserData(1);rbCha3.setUserData(2);
        rbCha4.setUserData(3);rbCha5.setUserData(4);rbCha6.setUserData(5);



    }

    private boolean checkToggles(){
        String alpha; String bravo; String charlie;
        String delta; String echo ; String foxtrot;

        alpha = strGroup.getSelectedToggle().getUserData().toString();
        bravo = dexGroup.getSelectedToggle().getUserData().toString();
        charlie = conGroup.getSelectedToggle().getUserData().toString();
        delta = intGroup.getSelectedToggle().getUserData().toString();
        echo =  wisGroup.getSelectedToggle().getUserData().toString();
        foxtrot = chaGroup.getSelectedToggle().getUserData().toString();

        return !alpha.equals(bravo) && !alpha.equals(charlie) && !alpha.equals(delta) && !alpha.equals(echo) && !alpha.equals(foxtrot) && !bravo.equals(charlie)
                && !bravo.equals(delta) && !bravo.equals(echo) && !bravo.equals(foxtrot) && !charlie.equals(delta) && !charlie.equals(echo) && !charlie.equals(foxtrot)
                && !delta.equals(echo) && !delta.equals(foxtrot) && !echo.equals(foxtrot);


    }

    public void declineClicked(ActionEvent actionEvent) {
        generate();
    }



    private void sortScores(Integer[] scores){
        int size = scores.length;
        int temp;
        for (int i = size-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (scores [j] < scores[j+1]){
                    temp = scores[j];
                    scores[j] = scores[j+1];
                    scores[j+1] = temp;
                }
            }
        }

    }

    public void generateClicked(ActionEvent actionEvent) {


        Statement state = null;
        ResultSet rs = null;


        str = scores[(int) strGroup.getSelectedToggle().getUserData()];
        dex = scores[(int) dexGroup.getSelectedToggle().getUserData()];
        con = scores[(int) conGroup.getSelectedToggle().getUserData()];
        intel = scores[(int) intGroup.getSelectedToggle().getUserData()];
        wis = scores[(int) wisGroup.getSelectedToggle().getUserData()];
        cha = scores[(int) chaGroup.getSelectedToggle().getUserData()];

        classChoice = classCBox.getValue().toString();

        String charName = "";




        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch (ClassNotFoundException e){
            System.out.println("Driver not found.");
            e.printStackTrace();
        }

        try{
            String access = "E://SeniorSeminar/D&D.accdb";
            String dbURL = "jdbc:ucanaccess://" + access;
            Connection conn = DriverManager.getConnection(dbURL);
            state = conn.createStatement();
            rs = state.executeQuery("SELECT * FROM Character");

            while (rs.next()){
                String name = rs.getString(1);
                charName = JOptionPane.showInputDialog("Please enter a name for your " + classChoice);

                while (charName.equals(name)){
                    JOptionPane.showMessageDialog(null, charName + " already exists.  "
                            + "Please try again");
                    charName = JOptionPane.showInputDialog("Please enter a name for your " + classChoice);
                }
                JOptionPane.showMessageDialog(null, charName + " created");

            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        switch (classChoice){
            case "Fighter":
                createFighter(charName, str, dex, con, intel, wis, cha);
                break;

            case "Healer":
                createHealer(charName, str, dex, con, intel, wis, cha);
                break;

            case "Rogue":
                createRogue(charName, str, dex, con, intel, wis, cha);
                break;

            case "Mage":
                createMage(charName, str, dex, con, intel, wis, cha);
                break;
        }





    }

    private void createMage(String charName, int str, int dex, int con, int intel, int wis, int cha) {
        String strString, dexString, conString, intString, wisString, chaString = "";

        Statement state = null;

        strString = Integer.toString(str);
        dexString = Integer.toString(dex);
        conString = Integer.toString(con);
        intString = Integer.toString(intel);
        wisString = Integer.toString(wis);
        chaString = Integer.toString(cha);

        Mage generated = new Mage();
        generated.setName(charName);
        generated.setStr(strString);
        generated.setDex(dexString);
        generated.setInt(intString);
        generated.setCon(conString);
        generated.setWis(wisString);
        generated.setCha(chaString);

        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch (ClassNotFoundException e){
            System.out.println("Driver not found.");
            e.printStackTrace();
        }


        try{
            String access = "E://SeniorSeminar/D&D.accdb";
            String dbURL = "jdbc:ucanaccess://" + access;

            Connection conn = DriverManager.getConnection(dbURL);
            state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT CharID FROM Character");
            int lastID = 0;

            while (rs.next()) {
                if (!rs.isLast()){
                    continue;
                }else{
                    lastID = rs.getInt("CharID");
                }
            }

            PreparedStatement updateStatement = conn.prepareStatement("INSERT INTO Mage VALUES (?,?,?,?,?,?,?,?,?,?,?)" );
            PreparedStatement updateGStatement = conn.prepareStatement( "INSERT INTO Character VALUES (?,?)");

            updateStatement.setString(1, charName);
            updateStatement.setInt(2, str);
            updateStatement.setInt(3, dex);
            updateStatement.setInt(4, con);
            updateStatement.setInt(5, wis);
            updateStatement.setInt(6, intel);
            updateStatement.setInt(7, cha);
            updateStatement.setInt(8, Integer.parseInt(generated.getAC()));
            updateStatement.setInt(9, Integer.parseInt(generated.getHP()));
            updateStatement.setString(10, "Mage");
            updateStatement.setInt(11, lastID+1);
            updateStatement.execute();

            updateGStatement.setInt(1, lastID+1);
            updateGStatement.setString(2, charName);

        }
        catch (SQLException e){
            e.printStackTrace();
        }


        try{
            FXMLLoader loader = new FXMLLoader((getClass().getResource("ddsht.fxml")));
            Parent ddsht = (Parent)loader.load();

            DDCSController controller = loader.getController();
            controller.transferMage(generated);

            Stage stage = new Stage();
            stage.getIcons().add(new Image("pics/icosahedron.png"));
            stage.setScene(new Scene(ddsht));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createRogue(String charName, int str, int dex, int con, int intel, int wis, int cha) {
        String strString, dexString, conString, intString, wisString, chaString = "";

        Statement state = null;

        strString = Integer.toString(str);
        dexString = Integer.toString(dex);
        conString = Integer.toString(con);
        intString = Integer.toString(intel);
        wisString = Integer.toString(wis);
        chaString = Integer.toString(cha);

        Rogue generated = new Rogue();
        generated.setName(charName);
        generated.setStr(strString);
        generated.setDex(dexString);
        generated.setInt(intString);
        generated.setCon(conString);
        generated.setWis(wisString);
        generated.setCha(chaString);

        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch (ClassNotFoundException e){
            System.out.println("Driver not found.");
            e.printStackTrace();
        }


        try{
            String access = "E://SeniorSeminar/D&D.accdb";
            String dbURL = "jdbc:ucanaccess://" + access;

            Connection conn = DriverManager.getConnection(dbURL);
            state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT CharID FROM Character");
            int lastID = 0;

            while (rs.next()) {
                if (!rs.isLast()){
                    continue;
                }else{
                    lastID = rs.getInt("CharID");
                }
            }

            PreparedStatement updateStatement = conn.prepareStatement("INSERT INTO Rogue VALUES (?,?,?,?,?,?,?,?,?,?,?)" );
            PreparedStatement updateGStatement = conn.prepareStatement( "INSERT INTO Character VALUES (?,?)");

            updateStatement.setString(1, charName);
            updateStatement.setInt(2, str);
            updateStatement.setInt(3, dex);
            updateStatement.setInt(4, con);
            updateStatement.setInt(5, wis);
            updateStatement.setInt(6, intel);
            updateStatement.setInt(7, cha);
            updateStatement.setInt(8, Integer.parseInt(generated.getAC()));
            updateStatement.setInt(9, Integer.parseInt(generated.getHP()));
            updateStatement.setString(10, "Rogue");
            updateStatement.setInt(11, lastID+1);
            updateStatement.execute();

            updateGStatement.setInt(1, lastID+1);
            updateGStatement.setString(2, charName);

        }
        catch (SQLException e){
            e.printStackTrace();
        }


        try{
            FXMLLoader loader = new FXMLLoader((getClass().getResource("ddsht.fxml")));
            Parent ddsht = (Parent)loader.load();

            DDCSController controller = loader.getController();
            controller.transferRogue(generated);

            Stage stage = new Stage();
            stage.getIcons().add(new Image("pics/icosahedron.png"));
            stage.setScene(new Scene(ddsht));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createHealer(String charName, int str, int dex, int con, int intel, int wis, int cha) {
        String strString, dexString, conString, intString, wisString, chaString = "";

        Statement state = null;

        strString = Integer.toString(str);
        dexString = Integer.toString(dex);
        conString = Integer.toString(con);
        intString = Integer.toString(intel);
        wisString = Integer.toString(wis);
        chaString = Integer.toString(cha);
        Healer generated = new Healer();

        generated.setName(charName);
        generated.setStr(strString);
        generated.setDex(dexString);
        generated.setInt(intString);
        generated.setCon(conString);
        generated.setWis(wisString);
        generated.setCha(chaString);

        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch (ClassNotFoundException e){
            System.out.println("Driver not found.");
            e.printStackTrace();
        }


        try{
            String access = "E://SeniorSeminar/D&D.accdb";
            String dbURL = "jdbc:ucanaccess://" + access;

            Connection conn = DriverManager.getConnection(dbURL);
            state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT CharID FROM Character");
            int lastID = 0;

            while (rs.next()) {
                if (!rs.isLast()){
                    continue;
                }else{
                    lastID = rs.getInt("CharID");
                }
            }

            PreparedStatement updateStatement = conn.prepareStatement("INSERT INTO Healer VALUES (?,?,?,?,?,?,?,?,?,?,?)" );
            PreparedStatement updateGStatement = conn.prepareStatement( "INSERT INTO Character VALUES (?,?)");

            updateStatement.setString(1, charName);
            updateStatement.setInt(2, str);
            updateStatement.setInt(3, dex);
            updateStatement.setInt(4, con);
            updateStatement.setInt(5, wis);
            updateStatement.setInt(6, intel);
            updateStatement.setInt(7, cha);
            updateStatement.setInt(8, Integer.parseInt(generated.getAC()));
            updateStatement.setInt(9, Integer.parseInt(generated.getHP()));
            updateStatement.setString(10, "Healer");
            updateStatement.setInt(11, lastID+1);
            updateStatement.execute();

            updateGStatement.setInt(1, lastID+1);
            updateGStatement.setString(2, charName);

        }
        catch (SQLException e){
            e.printStackTrace();
        }


        try{
            FXMLLoader loader = new FXMLLoader((getClass().getResource("ddsht.fxml")));
            Parent ddsht = (Parent)loader.load();

            DDCSController controller = loader.getController();
            controller.transferHealer(generated);

            Stage stage = new Stage();
            stage.getIcons().add(new Image("pics/icosahedron.png"));
            stage.setScene(new Scene(ddsht));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void createFighter(String charName, int str, int dex, int con, int intel, int wis, int cha) {
        String strString, dexString, conString, intString, wisString, chaString = "";

        Statement state = null;


        strString = Integer.toString(str);
        dexString = Integer.toString(dex);
        conString = Integer.toString(con);
        intString = Integer.toString(intel);
        wisString = Integer.toString(wis);
        chaString = Integer.toString(cha);

        Fighter generated = new Fighter();
        generated.setName(charName);
        generated.setStr(strString);
        generated.setDex(dexString);
        generated.setInt(intString);
        generated.setCon(conString);
        generated.setWis(wisString);
        generated.setCha(chaString);

        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        }
        catch (ClassNotFoundException e){
            System.out.println("Driver not found.");
            e.printStackTrace();
        }


        try{
            String access = "E://SeniorSeminar/D&D.accdb";
            String dbURL = "jdbc:ucanaccess://" + access;

            Connection conn = DriverManager.getConnection(dbURL);
            state = conn.createStatement();
            ResultSet rs = state.executeQuery("SELECT CharID FROM Character");
            int lastID = 0;

            while (rs.next()) {
                if (!rs.isLast()){
                    continue;
                }else{
                    lastID = rs.getInt("CharID");
                }
            }

            PreparedStatement updateStatement = conn.prepareStatement("INSERT INTO Fighter VALUES (?,?,?,?,?,?,?,?,?,?,?)" );
            PreparedStatement updateGStatement = conn.prepareStatement( "INSERT INTO Character VALUES (?,?)");

            updateStatement.setString(1, charName);
            updateStatement.setInt(2, str);
            updateStatement.setInt(3, dex);
            updateStatement.setInt(4, con);
            updateStatement.setInt(5, wis);
            updateStatement.setInt(6, intel);
            updateStatement.setInt(7, cha);
            updateStatement.setInt(8, Integer.parseInt(generated.getAC()));
            updateStatement.setInt(9, Integer.parseInt(generated.getHP()));
            updateStatement.setString(10, "Fighter");
            updateStatement.setInt(11, lastID+1);
            updateStatement.execute();

            updateGStatement.setInt(1, lastID+1);
            updateGStatement.setString(2, charName);

        }
        catch (SQLException e){
            e.printStackTrace();
        }



        try{
            FXMLLoader loader = new FXMLLoader((getClass().getResource("ddsht.fxml")));
            Parent ddsht = (Parent)loader.load();

            DDCSController controller = loader.getController();
            controller.transferFighter(generated);

            Stage stage = new Stage();
            stage.getIcons().add(new Image("pics/icosahedron.png"));
            stage.setScene(new Scene(ddsht));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void setScores(ActionEvent actionEvent) {
        boolean unique;

        unique = checkToggles();
        btnGenerate.setDisable(!unique);

    }

    public void onLoad(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader((getClass().getResource("ddsht.fxml")));
        LoadController controller = loader.getController();

        controller.openLoader();
        System.out.println("Load Selected");
    }

    public void onQuit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void aboutSelected(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader((getClass().getResource("about.fxml")));
            Parent abtsht = (Parent)loader.load();

            Stage stage = new Stage(StageStyle.UNDECORATED);
            stage.setScene(new Scene(abtsht));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

