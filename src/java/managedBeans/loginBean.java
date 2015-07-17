/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import controller.LAHandler;
import controller.LoginHandler;
import fachklassen.Antragsposition;
import fachklassen.LearningAgreement;
import fachklassen.LearningAgreementPosition;
import fachklassen.Student;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Janina
 */
@ManagedBean
@SessionScoped
public class loginBean implements Serializable{
    @EJB
    private LoginHandler loginHandler;
    @EJB
    private LAHandler lAHandler;
    
    private Student student;
    private Antragsposition antragsposition;
    private LearningAgreement la;
    
    
    public Antragsposition getAntragsposition() {
        return antragsposition;
    }

    public void setAntragsposition(Antragsposition antragsposition) {
        this.antragsposition = antragsposition;
    }

    public LearningAgreement getLa() {
        return la;
    }

    public void setLa(LearningAgreement la) {
        this.la = la;
    }
 
      
    public loginBean() {
        student=new Student();
        la = new LearningAgreement();
      
    }
    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

          
    public String login (){
        System.out.print(student.getBenutzername()+student.getPasswort());
        student=loginHandler.login(student.getBenutzername(),student.getPasswort());
        System.out.println(student.getBenutzername()+student.getNachname());
        return "home.xhtml";
    }
    
     public String weiterleitungLA(Antragsposition a){
        antragsposition=a;
       if (antragsposition.getLearningAgreement1()!=null){
            la=antragsposition.getLearningAgreement1();
        }
        else{
            la.setAntragsposition1(antragsposition);
            //antragsposition.setLearningAgreement1(la);
            //lAHandler.speichereAntragsposition(antragsposition);
            lAHandler.speichereNeuesLA(la);
            
        }
        return "editLA.xhtml";
    }
   public String positionLoeschen (LearningAgreementPosition lap){
       lAHandler.loescheLAPosition(lap);
       //LearningAgreement la2 =lAHandler.findeLA(lap.getLearningAgreement1().getLearningAgreementNummer());
       //la=la2;
       la.getLearningAgreementPosition1().remove(lap);
       FacesContext.getCurrentInstance().renderResponse();
        return "editLA.xhtml";
    }
   
}
