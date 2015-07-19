/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Janina
 */
public class LV {

    private int credits;
    private Long lehrveranstaltungsnummer;
    private String name;
    private String sprache;
    private String type;

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Long getLehrveranstaltungsnummer() {
        return lehrveranstaltungsnummer;
    }

    public void setLehrveranstaltungsnummer(Long lehrveranstaltungsnummer) {
        this.lehrveranstaltungsnummer = lehrveranstaltungsnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
