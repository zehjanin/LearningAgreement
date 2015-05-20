
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Antrag implements Serializable {

    @OneToMany(targetEntity = Antragsposition.class,mappedBy = "antrag1")
    private Collection<Antragsposition> antragsposition1;
    @OneToOne(targetEntity = Student.class,mappedBy = "antrag1")
    private Student student1;
    @Basic
    private String auslandsaufenthaltSemester;
    @Id
    private Long antragsnummer;

    public Antrag() {

    }
   
    public Collection<Antragsposition> getAntragsposition1() {
        return this.antragsposition1;
    }

    public void setAntragsposition1(Collection<Antragsposition> antragsposition1) {
        this.antragsposition1 = antragsposition1;
    }
   
    public Student getStudent1() {
        return this.student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }
   
    public String getAuslandsaufenthaltSemester() {
        return this.auslandsaufenthaltSemester;
    }

    public void setAuslandsaufenthaltSemester(String auslandsaufenthaltSemester) {
        this.auslandsaufenthaltSemester = auslandsaufenthaltSemester;
    }
   
    public Long getAntragsnummer() {
        return this.antragsnummer;
    }

    public void setAntragsnummer(Long antragsnummer) {
        this.antragsnummer = antragsnummer;
    }
}
