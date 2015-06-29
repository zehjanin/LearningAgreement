/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.LoginHandler;
import fachklassen.Student;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import fachklassen.Student;
/**
 *
 * @author karl-heinz.rau
 */
@Stateless
@Path("laRestServices")
public class LARestServices {
    @EJB
    LoginHandler laHandler;

    public LARestServices() {
    }   
    
    @GET
    @Path("/loginJson/{kdnr}/{pw}")
    @Consumes ("application/json")
    @Produces({"application/json"})
    public LoginWSStudent loginJson(@PathParam("kdnr") String benutzername, @PathParam("pw") String passwort) {
        Student student = laHandler.login(benutzername, passwort);
        LoginWSStudent loginWSStudent=new LoginWSStudent();
        if (student == null) {
            loginWSStudent.setErrorLogin("KundenNummer oder Passwort falsch");
        }
        else{
            loginWSStudent.setBenutzername(student.getBenutzername());
            loginWSStudent.setName(student.getNachname());
        }
        return loginWSStudent;
    }    
   /* 
    @GET
    @Path("/kontoUebersichtJson/{kdnr}")
    //@Produces({"application/json"})
    public KontoUebersichtWSUebersicht getKontoUebersichtJson(
            @PathParam("kdnr") int kundennummer) {
        KontoUebersichtWSUebersicht kontoUebersicht = 
                new KontoUebersichtWSUebersicht();
        Kunde kunde = laHandler.findeKunde(kundennummer);
        kontoUebersicht.setKundenNummer(kundennummer);
        kontoUebersicht.setName(kunde.getName());
        for (Konto konto : kunde.getKontenliste()) {
            KontoUebersichtWSPosition kuwsp = new KontoUebersichtWSPosition();
            kuwsp.setKontoArt(konto.getClass().getSimpleName());
            kuwsp.setKontoNummer(konto.getKontonummer());
            kuwsp.setKontoStand(konto.getKontostand());
            kontoUebersicht.getKontoUebersichtPositionen().add(kuwsp);
        }
        return kontoUebersicht;
    }       
    
    @GET
    @Path("/ueberweisungJson/{kdnr}/{vonKtoNr}/{nachKtoNr}/{betrag}/{datum}")   
    @Produces({"application/json"})
    public UeberweisungWS ueberweisenJson(
            @PathParam("kdnr") int kundenNummer,
            @PathParam("vonKtoNr") int vonKontoNummer, 
            @PathParam("nachKtoNr") int nachKontoNumer,
            @PathParam("betrag") double betrag,
            @PathParam("datum") long datum 
            ) {
        UeberweisungWS ueberweisungWS=new UeberweisungWS();
        try {
            Ueberweisung ueberweisung=laHandler.
                    ueberweisen(vonKontoNummer, nachKontoNumer, betrag, new Date(datum), kundenNummer);
            ueberweisungWS.setBetrag(ueberweisung.getBetrag());
            ueberweisungWS.setVonKonto(ueberweisung.getVonKonto().getKontonummer());
            ueberweisungWS.setNachKonto(ueberweisung.getNachKonto().getKontonummer());
            ueberweisungWS.setUeberweisungId(ueberweisung.getId());
           
        } catch (VonKontoNummerException ex) {             
            ueberweisungWS.setErrorVonKonto(ex.getMessage());                 
        }   
        catch(NachKontoNummerException ex){
            ueberweisungWS.setErrorNachKonto(ex.getMessage());
        }
        catch(UeberweisungException ex){
            ueberweisungWS.setErrorUeberweisung(ex.getMessage());
        }
        finally{
            return ueberweisungWS;
        }
    }  */  
}
