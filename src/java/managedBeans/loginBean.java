/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import controller.LAHandler;
import controller.LoginHandler;
import fachklassen.Antragsposition;
import fachklassen.LearningAgreement;
import fachklassen.LearningAgreementPosition;
import fachklassen.LehrveranstaltungAusland;
import fachklassen.LehrveranstaltungInland;
import fachklassen.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import service.LVAusland;
import service.WSClient;
import java.lang.reflect.Type;
import java.util.Collection;
import service.LV;

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
    private List <LehrveranstaltungInland> alleLehrveranstaltungenInland;
    private List <LehrveranstaltungAusland> alleLehrveranstaltungenAusland;
    private LVAusland lvAusland;

    public List<LehrveranstaltungAusland> getAlleLehrveranstaltungenAusland() {
        return alleLehrveranstaltungenAusland;
    }

    public void setAlleLehrveranstaltungenAusland(List<LehrveranstaltungAusland> alleLehrveranstaltungenAusland) {
        this.alleLehrveranstaltungenAusland = alleLehrveranstaltungenAusland;
    }

    public List<LehrveranstaltungInland> getAlleLehrveranstaltungenInland() {
        return alleLehrveranstaltungenInland;
    }

    public void setAlleLehrveranstaltungenInland(List<LehrveranstaltungInland> alleLehrveranstaltungenInland) {
        this.alleLehrveranstaltungenInland = alleLehrveranstaltungenInland;
    }

    public LehrveranstaltungInland getAusgewaehlteLVInland() {
        return ausgewaehlteLVInland;
    }

    public void setAusgewaehlteLVInland(LehrveranstaltungInland ausgewaehlteLVInland) {
        this.ausgewaehlteLVInland = ausgewaehlteLVInland;
    }
    private LehrveranstaltungInland ausgewaehlteLVInland;
    private LehrveranstaltungAusland ausgewaehlteLVAusland;

    public LehrveranstaltungAusland getAusgewaehlteLVAusland() {
        return ausgewaehlteLVAusland;
    }

    public void setAusgewaehlteLVAusland(LehrveranstaltungAusland ausgewaehlteLVAusland) {
        this.ausgewaehlteLVAusland = ausgewaehlteLVAusland;
    }
    
    
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
       la.getLearningAgreementPosition1().remove(lap);
        return "editLA.xhtml";
    }
   
   public String positionHinzufuegen(){
       alleLehrveranstaltungenInland=lAHandler.getAlleInlandskurse();
       WSClient wsClient=new WSClient();  
       Gson gson=new Gson();
        String alleLVAuslandString=wsClient.getLVAuslandJson(String.class);
        System.out.println(alleLVAuslandString);
        LV[] data= gson.fromJson(alleLVAuslandString, LV[].class);
        
        for (LV l :data){
            LehrveranstaltungAusland la=new LehrveranstaltungAusland();
            la.setCredits(l.getCredits());
            la.setLehrveranstaltungsnummer(l.getLehrveranstaltungsnummer());
            la.setName(l.getName());
            la.setSprache(l.getSprache());
            alleLehrveranstaltungenAusland.add(la);
        }
        
        //Type token = new TypeToken<Collection<LehrveranstaltungAusland>>(){}.getType();
       /* List<LehrveranstaltungAusland> alleLvAusland = gson.fromJson(alleLVAuslandString, token);
        for (LehrveranstaltungAusland l: alleLvAusland){
             alleLehrveranstaltungenAusland.add(l);
        }
  */
        
        //lvAusland=gson.fromJson(alleLVAuslandString, LVAusland.class);
       // System.out.println("lv in gson"+lvAusland.getAlleLV().get(0).getName());
      
    /*JsonParser parser = new JsonParser();
    JsonArray jArray = parser.parse(alleLVAuslandString).getAsJsonArray();

    ArrayList<LehrveranstaltungAusland> lcs = new ArrayList<LehrveranstaltungAusland>();

    for(JsonElement obj : jArray )
    {
        LehrveranstaltungAusland cse = gson.fromJson( obj , LehrveranstaltungAusland.class);
        lcs.add(cse);
    }*/
        
        wsClient.close(); 
      
        
        return "selectLectureHomecountry";
    }
   
}
