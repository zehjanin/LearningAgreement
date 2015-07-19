/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import fachklassen.LehrveranstaltungAusland;
import java.util.ArrayList;

public class LVAusland {

    private ArrayList<LehrveranstaltungAusland> lvAusland;

    public LVAusland() {
        lvAusland=new ArrayList<>();
    }


    public ArrayList<LehrveranstaltungAusland> getAlleLV() {
        return lvAusland;
    }

    public void setKontoUebersichtPositionen(ArrayList<LehrveranstaltungAusland> lvAusland) {
        this.lvAusland = lvAusland;
    }
}
