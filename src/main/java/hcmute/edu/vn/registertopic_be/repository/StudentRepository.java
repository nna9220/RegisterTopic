package hcmute.edu.vn.registertopic_be.repository;

import hcmute.edu.vn.registertopic_be.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
