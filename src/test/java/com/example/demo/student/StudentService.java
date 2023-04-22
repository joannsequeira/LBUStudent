import com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        // business logic to create new student
    }

    public Student getStudentByEmail(String email) {
        // business logic to retrieve student by email
    }

    public void deleteStudent(Student student) {
        // business logic to delete student
    }
}
