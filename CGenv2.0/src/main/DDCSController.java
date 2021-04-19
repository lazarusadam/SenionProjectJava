package main;

import javafx.scene.control.Label;

import main.DandD.Fighter;
import main.DandD.Healer;
import main.DandD.Mage;
import main.DandD.Rogue;

public class DDCSController {


    public Label strLbl;
    public Label dexLbl;
    public Label conLbl;
    public Label chaLbl;
    public Label wisLbl;
    public Label intLbl;
    public Label hpLbl;
    public Label classLbl;
    public Label acLbl;
    public Label lblName;


    public void transferMage(Mage generated) {

        strLbl.setText(generated.getStr());
        dexLbl.setText(generated.getDex());
        conLbl.setText(generated.getCon());
        chaLbl.setText(generated.getCha());
        wisLbl.setText(generated.getWis());
        intLbl.setText(generated.getInt());
        classLbl.setText("Generic Mage");
        hpLbl.setText(generated.getHP());
        acLbl.setText(generated.getAC());
        lblName.setText(generated.getName());
    }

    public void transferRogue(Rogue generated) {
        strLbl.setText(generated.getStr());
        dexLbl.setText(generated.getDex());
        conLbl.setText(generated.getCon());
        chaLbl.setText(generated.getCha());
        wisLbl.setText(generated.getWis());
        intLbl.setText(generated.getInt());
        classLbl.setText("Generic Rogue");
        hpLbl.setText(generated.getHP());
        acLbl.setText(generated.getAC());
        lblName.setText(generated.getName());
    }

    public void transferHealer(Healer generated) {
        strLbl.setText(generated.getStr());
        dexLbl.setText(generated.getDex());
        conLbl.setText(generated.getCon());
        chaLbl.setText(generated.getCha());
        wisLbl.setText(generated.getWis());
        intLbl.setText(generated.getInt());
        classLbl.setText("Generic Healer");
        hpLbl.setText(generated.getHP());
        acLbl.setText(generated.getAC());
        lblName.setText(generated.getName());
    }

    public void transferFighter(Fighter generated) {
        strLbl.setText(generated.getStr());
        dexLbl.setText(generated.getDex());
        conLbl.setText(generated.getCon());
        chaLbl.setText(generated.getCha());
        wisLbl.setText(generated.getWis());
        intLbl.setText(generated.getInt());
        classLbl.setText("Generic Fighter");
        hpLbl.setText(generated.getHP());
        acLbl.setText(generated.getAC());
        lblName.setText(generated.getName());
    }
}
