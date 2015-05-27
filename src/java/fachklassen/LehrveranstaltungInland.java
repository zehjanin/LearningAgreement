package fachklassen;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class LehrveranstaltungInland extends Lehrveranstaltung implements Serializable {

    @OneToMany(targetEntity = LearningAgreementPosition.class,mappedBy = "lehrveranstaltungInland1")
    private Collection<LearningAgreementPosition> learningAgreementPosition1;
    @Basic
    private String noteInland;

    public LehrveranstaltungInland() {

    }
   
    public Collection<LearningAgreementPosition> getLearningAgreementPosition1() {
        return this.learningAgreementPosition1;
    }

    public void setLearningAgreementPosition1(Collection<LearningAgreementPosition> learningAgreementPosition1) {
        this.learningAgreementPosition1 = learningAgreementPosition1;
    }
   
    public String getNoteInland() {
        return this.noteInland;
    }

    public void setNoteInland(String noteInland) {
        this.noteInland = noteInland;
    }
}
