package fachklassen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

// Enitätsklasse - JPA zur Datenhaltung (Datenhaltungsschicht) 
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn
public class Lehrveranstaltung implements Serializable {

    //Mapping der Attribute auf Datenbankspalten
    @Basic
    private int credits;
    @Id
    private Long lehrveranstaltungsnummer;
    @Basic
    private String name;
    @Basic
    private String sprache;

    public Lehrveranstaltung() {

    }

    //Getter-/Setter
    public int getCredits() {
        return this.credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Long getLehrveranstaltungsnummer() {
        return this.lehrveranstaltungsnummer;
    }

    public void setLehrveranstaltungsnummer(Long lehrveranstaltungsnummer) {
        this.lehrveranstaltungsnummer = lehrveranstaltungsnummer;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSprache() {
        return this.sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }
}
