
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public class Lehrveranstaltung implements Serializable {

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
