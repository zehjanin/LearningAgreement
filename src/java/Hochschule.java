
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class Hochschule implements Serializable {

    @Id
    private Long hochschulnummer;
    @ManyToMany(targetEntity = Student.class,mappedBy = "hochschule1")
    private Collection<Student> student1;
    @Basic
    private String name;
    @Basic
    private String land;

    public Hochschule() {

    }
   
    public Long getHochschulnummer() {
        return this.hochschulnummer;
    }

    public void setHochschulnummer(Long hochschulnummer) {
        this.hochschulnummer = hochschulnummer;
    }
   
    public Collection<Student> getStudent1() {
        return this.student1;
    }

    public void setStudent1(Collection<Student> student1) {
        this.student1 = student1;
    }
   
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    public String getLand() {
        return this.land;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
