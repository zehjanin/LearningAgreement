package fachklassen;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class LehrveranstaltungAusland extends Lehrveranstaltung implements Serializable {

    @OneToMany(targetEntity = LearningAgreementPosition.class,mappedBy = "lehrveranstaltungAusland1")
    private Collection<LearningAgreementPosition> learningAgreementPosition1;
  //  @ElementCollection
    private int ectsAusland;

    public LehrveranstaltungAusland() {

    }
   
    public Collection<LearningAgreementPosition> getLearningAgreementPosition1() {
        return this.learningAgreementPosition1;
    }

    public void setLearningAgreementPosition1(Collection<LearningAgreementPosition> learningAgreementPosition1) {
        this.learningAgreementPosition1 = learningAgreementPosition1;
    }
   
    public int getEctsAusland() {
        return this.ectsAusland;
    }

    public void setEctsAusland(int ectsAusland) {
        this.ectsAusland = ectsAusland;
    }
}
