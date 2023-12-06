package sumdu.edu.ua.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sumdu.edu.ua.model.Student;


/**
 *
 * @author Erlkonig
 */
@Repository("StudentDAO")
@EnableTransactionManagement
public class StudentDAO {
    
   	@Autowired
	private SessionFactory sessionFactory;
	
        @Transactional
        public void addStudent(Student a){
		Session session;
                try {
                    session = sessionFactory.getCurrentSession();
                } catch (HibernateException e) {
                    session = sessionFactory.openSession();
                }
		session.save(a);
	}
        
        
        @Transactional
	public List<Student> getStudents(){
            Session session = sessionFactory.getCurrentSession();
            List <Student> stud = session.createQuery("FROM Student").list();
            return stud;
        }
        
        @Transactional
	public Student getStudent(int id){
            Session session = sessionFactory.getCurrentSession();
            return (Student) session.get(Student.class, id);
        }
}