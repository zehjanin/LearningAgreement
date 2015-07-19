package fachklassen;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

// Enitätsklasse - JPA zur Datenhaltung (Datenhaltungsschicht)  

@Entity
public class Antragsposition implements Serializable {

    //Festlegung Primärschlüsselattribut
    @Id
    private Long positionsnnummer;
    
    //Beziehungen der Tabellen in Datenbank 
    @OneToOne(targetEntity = LearningAgreement.class,mappedBy = "antragsposition1", cascade = CascadeType.ALL)
    private LearningAgreement learningAgreement1;
    
     //Mapping der Attribute auf Datenbankspalten
    @Basic
    private String statusAntragsposition;
    @ManyToOne(targetEntity = Antrag.class)
    private Antrag antrag;
    
    @ManyToOne (targetEntity = Hochschule.class)
    private Hochschule hochschule;

  
    public Antragsposition() {

    }
   
    // Getter-/ Setter 
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
   
    public Antrag getAntrag() {
        return this.antrag;
    }

    public void setAntrag(Antrag antrag) {
        this.antrag = antrag;
    }
    
      public Hochschule getHochschule() {
        return hochschule;
    }

    public void setHochschule(Hochschule hochschule) {
        this.hochschule = hochschule;
    }

}
