/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sumdu.edu.ua.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sumdu.edu.ua.dao.ContentDAO;
import sumdu.edu.ua.dao.StudentDAO;
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
    private StudentDAO sdao;
    @Autowired
    private ContentDAO cdao;
    
        @RequestMapping(value = "UserContent", method=RequestMethod.GET)
        public ModelAndView formContent(@RequestParam("id2") String id2,Model m,HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException{ 
            ModelAndView modelNview = new ModelAndView();
            modelNview.setViewName("score");
            ApplicationContext factory = new ClassPathXmlApplicationContext("/spring.xml");
            Student st=sdao.getStudent(Integer.parseInt(id2));
            modelNview.addObject("user",st);
            scores=cdao.getScores(st.getId());
            modelNview.addObject("scores",scores);
            return modelNview;
        }

    
}
