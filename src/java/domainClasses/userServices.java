/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainClasses;

/**
 *
 * @author 686623
 */

public class userServices {
    
      user validUsername1 = new user("adam","password");
      user validUsername2 = new user("betty","password");

   
    public boolean login(user user){
 
        if(user.getUsername().equalsIgnoreCase("adam") &&
           user.getPassword().equalsIgnoreCase("password") ||
           user.getUsername().equalsIgnoreCase("betty") &&
           user.getPassword().equalsIgnoreCase("password"))
        {
            return true;
        }else{
            return false;
        }

}
}
