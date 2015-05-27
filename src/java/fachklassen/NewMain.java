package fachklassen;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Janina
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("LearningAgreementPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Student s =new Student ();
        s.setNachname("Nachname");
        s.setMatrikelnummer(457571);
        tx.begin();
        em.persist(s);
        tx.commit();
        em.close();
        emf.close();
        
    }
    
}
