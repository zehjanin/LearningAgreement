package fachklassen;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Heimathochschule extends Hochschule implements Serializable {

    @Id
    private Long id1;

    public Heimathochschule() {

    }
   
    public Long getId1() {
        return this.id1;
    }

    public void setId1(Long id1) {
        this.id1 = id1;
    }
}
