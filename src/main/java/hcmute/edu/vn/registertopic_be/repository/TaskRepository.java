package hcmute.edu.vn.registertopic_be.repository;

import hcmute.edu.vn.registertopic_be.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
