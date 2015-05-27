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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author karl-heinz.rau
 */
@Stateless
public class LAHandler implements Serializable {

    @PersistenceContext
    private EntityManager em;
    private Student student;
    private String test;


    public LAHandler() {
    }

    public Student login(String benutzername, String passwort) {
//         initialize();
        try {
            Query query = em.createNamedQuery("findeStudentMitPasswort");
            query.setParameter("pw", passwort);
            query.setParameter("benutzername", benutzername);
            student = (Student) query.getSingleResult();
            return student;
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }
    }

    public Student findeStudent (String benutzername) {
        student = em.find(Student.class, benutzername);
        return student;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


    public void setKunde(Student student) {
        this.student = student;
    }

    private void initialize() {
        try {
            
        } catch (Exception ex) {
            Logger.getLogger(LAHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



   

}
