package fachklassen;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

// Enitätsklasse - JPA zur Datenhaltung (Datenhaltungsschicht) 
@Entity()
public class LearningAgreement implements Serializable {

    //Beziehungen der Tabellen in Datenbank
    @OneToMany(targetEntity = LearningAgreementPosition.class, mappedBy = "learningAgreement1")
    private Collection<LearningAgreementPosition> learningAgreementPosition1;
    @OneToOne(targetEntity = Antragsposition.class)
    private Antragsposition antragsposition1;

    //Festlegung Primärschlüsselattribut (automatische Wertgenerierung) 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long learningAgreementNummer;

    //Mapping der Attribute auf Datenbankspalten
    @Basic
    private String endeAuslandsaufenthalt;
    @Basic
    private String beginnAuslandsaufenthalt;

    public LearningAgreement() {

    }

    //Getter-/Setter 
    public Collection<LearningAgreementPosition> getLearningAgreementPosition1() {
        return this.learningAgreementPosition1;
    }

    public void setLearningAgreementPosition1(Collection<LearningAgreementPosition> learningAgreementPosition1) {
        this.learningAgreementPosition1 = learningAgreementPosition1;
    }

    public Antragsposition getAntragsposition1() {
        return this.antragsposition1;
    }

    public void setAntragsposition1(Antragsposition antragsposition1) {
        this.antragsposition1 = antragsposition1;
    }

    public Long getLearningAgreementNummer() {
        return this.learningAgreementNummer;
    }

    public void setLearningAgreementNummer(Long learningAgreementNummer) {
        this.learningAgreementNummer = learningAgreementNummer;
    }

    public String getEndeAuslandsaufenthalt() {
        return this.endeAuslandsaufenthalt;
    }

    public void setEndeAuslandsaufenthalt(String endeAuslandsaufenthalt) {
        this.endeAuslandsaufenthalt = endeAuslandsaufenthalt;
    }

    public String getBeginnAuslandsaufenthalt() {
        return this.beginnAuslandsaufenthalt;
    }

    public void setBeginnAuslandsaufenthalt(String beginnAuslandsaufenthalt) {
        this.beginnAuslandsaufenthalt = beginnAuslandsaufenthalt;
    }
}
