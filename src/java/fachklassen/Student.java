package fachklassen;


import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
 @NamedQuery(name="findeStudentMitPasswort", query="SELECT s FROM Student s WHERE s.benutzername=:benutzername and s.passwort=:passwort ")
public class Student implements Serializable {

    @Basic
    private String studiengang;
    @Basic
    private Date geburtstdatum;
    @ManyToOne(targetEntity = Hochschule.class)
    private Hochschule hochschule;
    @Basic
    private String passwort;
    @Basic
    private String fakultaet;
    @Basic
    private Date studienbeginn;
    @Basic
    private String vorname;
    @Basic
    private String geburtsort;
    @Basic
    private String nachname;
    @OneToOne(targetEntity = Antrag.class)
    private Antrag antrag;
    @Id
    private int matrikelnummer;
    @Basic
    private String benutzername;

    public Student() {

    }
   
    public String getStudiengang() {
        return this.studiengang;
    }

    public void setStudiengang(String studiengang) {
        this.studiengang = studiengang;
    }
   
    public Date getGeburtstdatum() {
        return this.geburtstdatum;
    }

    public void setGeburtstdatum(Date geburtstdatum) {
        this.geburtstdatum = geburtstdatum;
    }
   
    public Hochschule getHochschule() {
        return this.hochschule;
    }

    public void setHochschule(Hochschule hochschule) {
        this.hochschule = hochschule;
    }
   
    public String getPasswort() {
        return this.passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
   
    public String getFakultaet() {
        return this.fakultaet;
    }

    public void setFakultaet(String fakultaet) {
        this.fakultaet = fakultaet;
    }
   
    public Date getStudienbeginn() {
        return this.studienbeginn;
    }

    public void setStudienbeginn(Date studienbeginn) {
        this.studienbeginn = studienbeginn;
    }
   
    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
   
    public String getGeburtsort() {
        return this.geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }
   
    public String getNachname() {
        return this.nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
   
    public Antrag getAntrag() {
        return this.antrag;
    }

    public void setAntrag(Antrag antrag) {
        this.antrag = antrag;
    }
   
    public int getMatrikelnummer() {
        return this.matrikelnummer;
    }

    public void setMatrikelnummer(int matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }
   
    public String getBenutzername() {
        return this.benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }
}
