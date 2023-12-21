package sumdu.edu.ua.repo;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sumdu.edu.ua.model.Content;
import sumdu.edu.ua.model.Student;

@Repository
public interface ContentRepo extends JpaRepository<Student, Integer>{
    @Query("from Content where stud_id= :id")
    List<Content> getScoresByStId(@Param("id") int id);
}
