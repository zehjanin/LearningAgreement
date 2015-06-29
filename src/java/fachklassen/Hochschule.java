package fachklassen;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;

@Entity
public class Hochschule implements Serializable {

    @Id
    private Long hochschulnummer;
    @OneToMany(targetEntity = Student.class,mappedBy = "hochschule")
    private Collection<Student> student;
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
