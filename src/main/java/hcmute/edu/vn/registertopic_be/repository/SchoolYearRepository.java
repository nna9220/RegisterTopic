package hcmute.edu.vn.registertopic_be.repository;

import hcmute.edu.vn.registertopic_be.model.entity.SchoolYear;
import hcmute.edu.vn.registertopic_be.model.request.SchoolYearRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolYearRepository extends JpaRepository<SchoolYear, Integer> {
    @Query("select y from SchoolYear y")
    List<SchoolYear> getAllSchoolYear();
}
