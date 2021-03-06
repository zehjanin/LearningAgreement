package fachklassen;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// Enitätsklasse - JPA zur Datenhaltung (Datenhaltungsschicht) 
@Entity
public class LearningAgreementPosition implements Serializable {

    //Beziehungen der Tabellen in Datenbank
    @ManyToOne(targetEntity = LearningAgreement.class)
    private LearningAgreement learningAgreement1;
    @ManyToOne(targetEntity = LehrveranstaltungAusland.class)
    private LehrveranstaltungAusland lehrveranstaltungAusland1;

    //Festlegung Primärschlüsselattribut (automatische Wertgenerierung)
    @Id
    @GeneratedValue
    private Long positionsnummer;
    @ManyToOne(targetEntity = LehrveranstaltungInland.class)
    private LehrveranstaltungInland lehrveranstaltungInland1;
    /*@Basic
     private String statusLearningAgreementPosition;*/

    public LearningAgreementPosition() {

    }

    //Getter-/Setter 
    public LearningAgreement getLearningAgreement1() {
        return this.learningAgreement1;
    }

    public void setLearningAgreement1(LearningAgreement learningAgreement1) {
        this.learningAgreement1 = learningAgreement1;
    }

    public LehrveranstaltungAusland getLehrveranstaltungAusland1() {
        return this.lehrveranstaltungAusland1;
    }

    public void setLehrveranstaltungAusland1(LehrveranstaltungAusland lehrveranstaltungAusland1) {
        this.lehrveranstaltungAusland1 = lehrveranstaltungAusland1;
    }

    public Long getPositionsnummer() {
        return this.positionsnummer;
    }

    public void setPositionsnummer(Long positionsnummer) {
        this.positionsnummer = positionsnummer;
    }

    public LehrveranstaltungInland getLehrveranstaltungInland1() {
        return this.lehrveranstaltungInland1;
    }

    public void setLehrveranstaltungInland1(LehrveranstaltungInland lehrveranstaltungInland1) {
        this.lehrveranstaltungInland1 = lehrveranstaltungInland1;
    }


}
