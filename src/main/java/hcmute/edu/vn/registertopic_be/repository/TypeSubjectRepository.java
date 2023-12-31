package hcmute.edu.vn.registertopic_be.repository;

import hcmute.edu.vn.registertopic_be.model.entity.TypeSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeSubjectRepository extends JpaRepository<TypeSubject, Integer> {
    @Query("select t from TypeSubject t")
    public List<TypeSubject> getAllTypeSubject();
}
