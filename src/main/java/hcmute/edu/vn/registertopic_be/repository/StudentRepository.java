package hcmute.edu.vn.registertopic_be.repository;

import hcmute.edu.vn.registertopic_be.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT s FROM Student s")
    List<Student> getAllStudent();
}
