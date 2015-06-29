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
    
    private String benutzername;
    private String name;
    private String errorLogin;

    public LoginWSStudent() {
    }

    public LoginWSStudent(String benutzername, String name) {
        this.benutzername = benutzername;
        this.name = name;
    }    

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
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
