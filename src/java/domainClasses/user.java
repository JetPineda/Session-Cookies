/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainClasses;

import java.io.Serializable;

/**
 *
 * @author 686623
 */
public class user implements Serializable{
    
    
    public String username;
    public String password;
    

    public user() {
   
    }

    public user(String name, String month) {
        this.username = username;
        this.password = password;
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
