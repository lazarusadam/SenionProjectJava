package main.Pathfinder;

public interface Character {

    // Getter Functions
    String getName();
    String getStr();
    String getDex();
    String getWis();
    String getInt();
    String getCon();
    String getCha();
    String getHP();
    String getAC();

    // Setter Functions
    void setName(String name);
    void setStr(String str);
    void setDex(String dex);
    void setWis(String wis);
    void setInt(String intel);
    void setCon(String con);
    void setCha(String cha);
    String setHP();
    String setAC();

    // Generates a Text-based Character Sheet
    void charSheet();
}