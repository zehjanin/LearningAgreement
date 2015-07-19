/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import fachklassen.Student;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author janina
 */
//Stateless: Session Bean sind dem Clienten (LoginBean) lediglich für Dauer eines Methodenaufrufs zugeordnet 
@Stateless
public class LoginHandler implements Serializable {

    //verwaltet Enteties und kontrolliert ihren Lebenszyklus 
    @PersistenceContext
    private EntityManager em;
    private Student student;
    private String test;

    public LoginHandler() {
    }

    //Überprüfen ob Student in Datenbank vorhanden und Benutzername = Passwort (mit übergegebenen Werten) 
    //Rückgabe des kompletten Studenten oder null 
    public Student login(String benutzername, String passwort) {
        initialize();
        try {
            Query query;
            query = em.createNamedQuery("findeStudentMitPasswort", Student.class);
            query.setParameter("benutzername", benutzername);
            query.setParameter("passwort", passwort);
            student = (Student) query.getSingleResult();
            System.out.print("EJB:" + student.getBenutzername() + student.getPasswort());
            return student;
        } catch (NoResultException e) {
            System.out.println("fehler, konnte student nicht finden");
            return null;
        }
    }

    public Student findeStudent(String benutzername) {
        student = em.find(Student.class, benutzername);
        return student;
    }

    //Getter-/Setter EntityManager
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private void initialize() {
        try {

        } catch (Exception ex) {
            Logger.getLogger(LoginHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
