/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domainClasses.user;
import domainClasses.userServices;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 686623
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
          String logoutMessage = request.getParameter("message");
          request.setAttribute("message", logoutMessage);
        Cookie getUname = getCookie(request,"userNameCookie");
        if(getUname != null)
        {
            request.setAttribute("rememberMe", getUname.getValue());
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);  
        }else if("Logged Out".equals(logoutMessage))
        {
        request.getSession().invalidate();
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);    
        }
 
        
 
     
        
            
        
  

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("uName");
        String passWord = request.getParameter("pWord");
        String rememberme = request.getParameter("rememberMe");

        userServices uS = new userServices();

        user u = new user();
        u.setUsername(request.getParameter("uName"));
        u.setPassword(request.getParameter("pWord"));
        request.setAttribute("user", u);

        HttpSession session = request.getSession();

        if (uS.login(u) == true && rememberme == null) {
            session.setAttribute("username", u.getUsername());
            response.sendRedirect("/home");
            Cookie c = getCookie(request, userName);
            if(c != null){
                c.setMaxAge(0);
                 response.addCookie(c);
            }
        } else if (uS.login(u) == true && rememberme != null) {
            Cookie c = new Cookie("userNameCookie", u.getUsername());
            response.addCookie(c);

            request.setAttribute("helloMessage", "Hello, " + userName);
            response.sendRedirect("/home");
        } else {
            request.setAttribute("uName", userName);
            request.setAttribute("errorMessage", "Invalid username or password");
            response.sendRedirect("/");
        }

    }
    
    private Cookie getCookie(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        if(cookies == null){
            return null;
        }else{
            for(Cookie c: cookies){
                if(c.getName().equals(name)){
                    return c;
                }
            }
        }
        return null;
    }
}
