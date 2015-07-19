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
import javax.faces.application.FacesMessage;
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
public class loginBean implements Serializable {

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
        student = new Student();
        la = new LearningAgreement();

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

//    public String login (){
//        System.out.print(student.getBenutzername()+student.getPasswort());
//        student=loginHandler.login(student.getBenutzername(),student.getPasswort());
//        System.out.println(student.getBenutzername()+student.getNachname());
//        return "home.xhtml";
//    }
    public String login() throws Exception {
        this.student = loginHandler.login(this.student.getBenutzername(), this.student.getPasswort());
        if (this.student != null) {
            return "home.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage("login", new FacesMessage(FacesMessage.SEVERITY_WARN, "Falsche Benutzerdaten. Bitte überprüfen Sie Ihre Zugangsdaten", "Bitte überprüfen Sie Ihre Zugangsdaten"));
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().invalidateSession();
            return "login.xhtml";
        }
    }

    public String weiterleitungLA(Antragsposition a) {
        antragsposition = a;
        if (antragsposition.getStatusAntragsposition().equals("genehmigt")) {
            if (antragsposition.getLearningAgreement1() != null) {
                la = antragsposition.getLearningAgreement1();
            } else {
                la.setAntragsposition1(antragsposition);
            //antragsposition.setLearningAgreement1(la);
                //lAHandler.speichereAntragsposition(antragsposition);
                lAHandler.speichereNeuesLA(la);

            }
            return "editLA.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage("editLA", new FacesMessage(FacesMessage.SEVERITY_WARN, "Ihr Antrag ist noch nicht genehmigt. Sie können noch kein LA anlegen", "Warten Sie auf Genehmigung"));
        }
        return "home.xhtml";
    }

    public String positionLoeschen(LearningAgreementPosition lap) {
        lAHandler.loescheLAPosition(lap);
       //LearningAgreement la2 =lAHandler.findeLA(lap.getLearningAgreement1().getLearningAgreementNummer());
        //la=la2;
        la.getLearningAgreementPosition1().remove(lap);
        FacesContext.getCurrentInstance().renderResponse();
        return "editLA.xhtml";
    }

    public void userLogout() throws Exception {
        student = null;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().invalidateSession();
        facesContext.getExternalContext().redirect("login.xhtml");
    }
}
