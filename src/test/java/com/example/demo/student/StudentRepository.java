import com.example.demo.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);

}
