package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import javax.swing.*;
import java.util.*;

public class PFController {


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
    String str, cha, con, intel, dex, wis, classChoice;

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
        if (alpha == null)
            return true;
        bravo = dexGroup.getSelectedToggle().getUserData().toString();
        if (bravo == null)
            return true;
        charlie = conGroup.getSelectedToggle().getUserData().toString();
        if (charlie == null)
            return true;
        delta = intGroup.getSelectedToggle().getUserData().toString();
        if (delta == null)
            return true;
        echo =  wisGroup.getSelectedToggle().getUserData().toString();
        if (echo == null)
            return true;
        foxtrot = chaGroup.getSelectedToggle().getUserData().toString();
        if (foxtrot == null)
            return true;

        return true;



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
        str = scores[(int) strGroup.getSelectedToggle().getUserData()].toString();
        dex = scores[(int) dexGroup.getSelectedToggle().getUserData()].toString();
        con = scores[(int) conGroup.getSelectedToggle().getUserData()].toString();
        intel = scores[(int) intGroup.getSelectedToggle().getUserData()].toString();
        wis = scores[(int) wisGroup.getSelectedToggle().getUserData()].toString();
        cha = scores[(int) chaGroup.getSelectedToggle().getUserData()].toString();

        classChoice = classCBox.getValue().toString();

        String charName;

        charName = JOptionPane.showInputDialog("Please enter a name for your Character");
        JOptionPane.showMessageDialog(null, charName + " created");



        System.out.println(str + " " + dex + " " + con + classChoice);

    }


    public void setScores(ActionEvent actionEvent) {
        boolean unique;

        unique = checkToggles();
        btnGenerate.setDisable(!unique);

    }
}

