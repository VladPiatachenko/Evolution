package sumdu.edu.ua.webstudent;

import com.mysql.jdbc.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erlkonig
 */
@WebServlet(name = "StudentAdd", urlPatterns = {"/StudentAdd"})
public class StudentAdd extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    try{
        
        HttpSession session = request.getSession();
        List<Student> students = (List<Student>)session.getAttribute("students");
        
        PrintWriter pw=null;
        try{
            pw=response.getWriter();
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException ex){
            ex.printStackTrace(pw);
            pw.print(ex.getMessage());
        }
        
        Connection conn=null;
        conn= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3311/university","root","root");
        
        if(request.getParameter("name")!=null && request.getParameter("surname")!=null){
            PreparedStatement ps= (PreparedStatement) conn.prepareStatement("Insert into student (name, surname, age, email, group_, faculty) "+
                    "Values (?, ?, ?, ?, ?, ?)");
            ps.setString(1,request.getParameter("name"));
            ps.setString(2,request.getParameter("surname"));
            ps.setInt(3,Integer.parseInt(request.getParameter("age")));
            ps.setString(4,request.getParameter("email"));
            ps.setString(5,request.getParameter("group"));
            ps.setString(6,request.getParameter("faculty"));
            ps.executeUpdate();
        }
        Statement s= (Statement) conn.createStatement();
        ResultSet rs=s.executeQuery("SELECT * FROM student;");
        students =new LinkedList<Student>();
        while(rs.next()){
            Student student = new Student(rs.getString(2),rs.getString(3), Integer.parseInt(rs.getString(4)),rs.getString(5),rs.getString(6),rs.getString(7));
            students.add(student);
        }
        session.setAttribute("students", students);
        
        //request.setAttribute("students",students);
        response.sendRedirect("/student.jsp");
        
    }
    catch(SQLException ex){
            Logger.getLogger(StudentAdd.class.getName()).log(Level.SEVERE, null,ex);
    }
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}