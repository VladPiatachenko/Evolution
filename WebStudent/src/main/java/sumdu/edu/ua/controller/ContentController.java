/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sumdu.edu.ua.repo.ContentRepo;
import sumdu.edu.ua.repo.StudentRepo;

import sumdu.edu.ua.model.Content;
import sumdu.edu.ua.model.Student;

/**
 *
 * @author Oksana
 */
@Controller
public class ContentController {
    List<Content> scores;
    ApplicationContext factory;
     
    @Autowired
    StudentRepo srepo;
    
    @Autowired
    ContentRepo scorepo;
    
        @RequestMapping(value = "UserContent", method=RequestMethod.GET)
        public ModelAndView formContent(@RequestParam("id2") String id2,HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException{ 
            ModelAndView modelNview = new ModelAndView();
            modelNview.setViewName("score");
            ApplicationContext factory = new ClassPathXmlApplicationContext("/spring.xml");
            Student st=srepo.getOne(Integer.parseInt(id2));
            modelNview.addObject("user",st);
            scores=scorepo.getScoresByStId(st.getId());
            modelNview.addObject("scores",scores);
            return modelNview;
        }

    
}
