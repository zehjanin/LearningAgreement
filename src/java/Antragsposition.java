
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Antragsposition implements Serializable {

    @Id
    private Long positionsnnummer;
    @OneToOne(targetEntity = LearningAgreement.class,mappedBy = "antragsposition1")
    private LearningAgreement learningAgreement1;
    @Basic
    private String statusAntragsposition;
    @ManyToOne(targetEntity = Antrag.class)
    private Antrag antrag1;

    public Antragsposition() {

    }
   
    public Long getPositionsnnummer() {
        return this.positionsnnummer;
    }

    public void setPositionsnnummer(Long positionsnnummer) {
        this.positionsnnummer = positionsnnummer;
    }
   
    public LearningAgreement getLearningAgreement1() {
        return this.learningAgreement1;
    }

    public void setLearningAgreement1(LearningAgreement learningAgreement1) {
        this.learningAgreement1 = learningAgreement1;
    }
   
    public String getStatusAntragsposition() {
        return this.statusAntragsposition;
    }

    public void setStatusAntragsposition(String statusAntragsposition) {
        this.statusAntragsposition = statusAntragsposition;
    }
   
    public Antrag getAntrag1() {
        return this.antrag1;
    }

    public void setAntrag1(Antrag antrag1) {
        this.antrag1 = antrag1;
    }
}
