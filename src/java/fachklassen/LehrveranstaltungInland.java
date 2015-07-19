package fachklassen;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

// Enitätsklasse - JPA zur Datenhaltung (Datenhaltungsschicht) 
@Entity
public class LehrveranstaltungInland extends Lehrveranstaltung implements Serializable {

    //Beziehungen der Tabellen in Datenbank
    @OneToMany(targetEntity = LearningAgreementPosition.class, mappedBy = "lehrveranstaltungInland1")
    private Collection<LearningAgreementPosition> learningAgreementPosition1;

    //Mapping der Attribute auf Datenbankspalten
    @Basic
    private int ectsInland;

    public LehrveranstaltungInland() {

    }

    //Getter-/Setter
    public Collection<LearningAgreementPosition> getLearningAgreementPosition1() {
        return this.learningAgreementPosition1;
    }

    public void setLearningAgreementPosition1(Collection<LearningAgreementPosition> learningAgreementPosition1) {
        this.learningAgreementPosition1 = learningAgreementPosition1;
    }

    public int getEctsInland() {
        return this.ectsInland;
    }

    public void setEctsInland(int ectsInland) {
        this.ectsInland = ectsInland;
    }
}
