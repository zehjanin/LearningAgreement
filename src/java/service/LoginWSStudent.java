/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author karl-heinz.rau
 */
public class LoginWSStudent {
    
    private int kundenNummer;
    private String name;
    private String errorLogin;

    public LoginWSStudent() {
    }

    public LoginWSStudent(int kundenNummer, String name) {
        this.kundenNummer = kundenNummer;
        this.name = name;
    }    

    public int getKundenNummer() {
        return kundenNummer;
    }

    public void setKundenNummer(int kundenNummer) {
        this.kundenNummer = kundenNummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getErrorLogin() {
        return errorLogin;
    }

    public void setErrorLogin(String errorLogin) {
        this.errorLogin = errorLogin;
    }
}
