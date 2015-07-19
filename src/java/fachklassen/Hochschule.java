package fachklassen;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;

// Enitätsklasse - JPA zur Datenhaltung (Datenhaltungsschicht) 
@Entity
public class Hochschule implements Serializable {

    //Festlegung Primärschlüsselattribut
    @Id
    private Long hochschulnummer;

    //Beziehungen der Tabellen in Datenbank 
    @OneToMany(targetEntity = Student.class, mappedBy = "hochschule")
    private Collection<Student> student;

    //Mapping der Attribute auf Datenbankspalten
    @Basic
    private String name;
    @Basic
    private String land;

    public Hochschule() {

    }

    //Getter-/ Setter
    public Long getHochschulnummer() {
        return this.hochschulnummer;
    }

    public void setHochschulnummer(Long hochschulnummer) {
        this.hochschulnummer = hochschulnummer;
    }

    public Collection<Student> getStudent() {
        return this.student;
    }

    public void setStudent(Collection<Student> student) {
        this.student = student;
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
