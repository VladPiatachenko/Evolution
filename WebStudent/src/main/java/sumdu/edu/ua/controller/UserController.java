/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sumdu.edu.ua.model.User;
import sumdu.edu.ua.security.UserRepository;

/**
 *
 * @author Oksana
 */
@Controller
public class UserController {
    ApplicationContext factory = new ClassPathXmlApplicationContext("/spring.xml");;
    
    @Autowired
    UserRepository repo;
           
       
                    
        @PostMapping("/signup")
	public String register(HttpServletRequest request) {
            User user = (User)factory.getBean("User");
            if(request.getParameter("email")!=""&&request.getParameter("password")!=""){
            user.setUsername(request.getParameter("email"));
            user.setPass(new BCryptPasswordEncoder().encode(request.getParameter("password")));
            repo.save(user);
            }
            return "login";
	}
     
        
}
