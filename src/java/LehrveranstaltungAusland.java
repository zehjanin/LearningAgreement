
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class LehrveranstaltungAusland extends Lehrveranstaltung implements Serializable {

    @OneToMany(targetEntity = LearningAgreementPosition.class,mappedBy = "lehrveranstaltungAusland1")
    private Collection<LearningAgreementPosition> learningAgreementPosition1;
    @ElementCollection
    private Collection<String> noteAusland;

    public LehrveranstaltungAusland() {

    }
   
    public Collection<LearningAgreementPosition> getLearningAgreementPosition1() {
        return this.learningAgreementPosition1;
    }

    public void setLearningAgreementPosition1(Collection<LearningAgreementPosition> learningAgreementPosition1) {
        this.learningAgreementPosition1 = learningAgreementPosition1;
    }
   
    public Collection<String> getNoteAusland() {
        return this.noteAusland;
    }

    public void setNoteAusland(Collection<String> noteAusland) {
        this.noteAusland = noteAusland;
    }
}
