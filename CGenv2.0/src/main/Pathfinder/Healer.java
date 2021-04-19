package main.Pathfinder;
/* Druid, Priest, Bard, Apothecary */

import main.Dice;


public class Healer implements Character {
    private String name;
    private String str;
    private String dex;
    private String wis;
    private String intel;
    private String con;
    private String cha;
    private String hp;
    private String ac;

    public Healer() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStr() {
        return str;
    }

    @Override
    public String getDex() {
        return dex;
    }

    @Override
    public String getWis() {
        return wis;
    }

    @Override
    public String getInt() {
        return intel;
    }

    @Override
    public String getCon() {
        return con;
    }

    @Override
    public String getCha() {
        return cha;
    }

    @Override
    public String getHP() {
        String hp = setHP();
        return hp;
    }

    @Override
    public String getAC() {
        String ac = setAC();
        return ac;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public void setDex(String dex) {
        this.dex = dex;
    }

    @Override
    public void setWis(String wis) {
        this.wis = wis;
    }

    @Override
    public void setInt(String intel) {
        this.intel = intel;
    }

    @Override
    public void setCon(String con) {
        this.con = con;
    }

    @Override
    public void setCha(String cha) {
        this.cha = cha;
    }

    @Override
    public String setHP() {
        int hp = 0;
        String hpString = "";
        String con = getCon();
        Dice roll = new Dice();
        switch (con){
            case "3":
            case "4":
            case "5": hp = roll.d10(1,-3); break;
            case "6":
            case "7": hp = roll.d10(1, -2); break;
            case "8":
            case "9": hp = roll.d10(1, -1); break;
            case "10":
            case "11": hp = roll.d10(1,0); break;
            case "12":
            case "13": hp = roll.d10(1, 1); break;
            case "14":
            case "15": hp = roll.d10(1, 2); break;
            case "16":
            case "17": hp = roll.d10(1, 3); break;
            case "18":
            case "19": hp = roll.d10(1, 4); break;

        }

        if (hp < 1)
            hp = 1;

        hpString = Integer.toString(hp);

        return hpString;
    }

    @Override
    public String setAC() {
        int ac = 0;
        String acString = "";
        String dex = getDex();

        switch (dex){
            case "3":
            case "4":
            case "5": ac = -3; break;
            case "6":
            case "7": ac = -2; break;
            case "8":
            case "9": ac = -1; break;
            case "10":
            case "11": ac = 0; break;
            case "12":
            case "13": ac = 1; break;
            case "14":
            case "15": ac = 2; break;
            case "16":
            case "17": ac = 3; break;
            case "18":
            case "19": ac = 4; break;
        }

        acString = Integer.toString(ac);

        return acString;
    }

    @Override
    public void charSheet() {

    }
}


