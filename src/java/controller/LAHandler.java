/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fachklassen.Antragsposition;
import fachklassen.LearningAgreement;
import fachklassen.LearningAgreementPosition;
import fachklassen.LehrveranstaltungInland;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Janina
 */
//Stateless: Session Bean sind dem Clienten (LoginBean) lediglich für Dauer eines Methodenaufrufs zugeordnet 
@Stateless
public class LAHandler {

    //verwaltet Enteties und kontrolliert ihren Lebenszyklus 
    @PersistenceContext
    EntityManager em;

    public LAHandler() {
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void speichereAntragsposition(Antragsposition a) {
        try {
            em.refresh(a);
        } catch (Exception e) {

        }
    }

    ////Löschen LA aus Datenbank
    public void loescheLAPosition(LearningAgreementPosition laposition) {
        laposition = em.merge(laposition);
        em.remove(laposition);
    }

    //Speichern neues LA in Datenbank
    public void speichereNeuesLA(LearningAgreement la) {
        em.persist(la);
    }

    //Suchen LA in Datenbank
    public LearningAgreement findeLA(long lanummer) {
        LearningAgreement la;
        la = em.find(LearningAgreement.class, lanummer);
        return la;
    }

    public List<LehrveranstaltungInland> getAlleInlandskurse() {
         TypedQuery<LehrveranstaltungInland> query =
        em.createQuery("SELECT L FROM LehrveranstaltungInland L", LehrveranstaltungInland.class);
        List<LehrveranstaltungInland> alleLehrveranstaltungenInland;
        alleLehrveranstaltungenInland = query.getResultList();
        return alleLehrveranstaltungenInland;
    }
    

}
