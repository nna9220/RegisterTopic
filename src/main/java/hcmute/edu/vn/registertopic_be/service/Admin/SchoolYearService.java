package hcmute.edu.vn.registertopic_be.service.Admin;

import hcmute.edu.vn.registertopic_be.model.entity.SchoolYear;
import hcmute.edu.vn.registertopic_be.model.mapper.SchoolYearMapper;
import hcmute.edu.vn.registertopic_be.model.request.SchoolYearRequest;
import hcmute.edu.vn.registertopic_be.repository.SchoolYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolYearService {
    @Autowired
    private SchoolYearRepository schoolYearRepository;
    @Autowired
    private SchoolYearMapper schoolYearMapper;

    public List<SchoolYear> findAll(){
        return schoolYearRepository.getAllSchoolYear();
    }
    public SchoolYear createSchoolYear(SchoolYearRequest schoolYearRequest){
        var schoolYear =schoolYearMapper.toEntity(schoolYearRequest);
        return schoolYearRepository.save(schoolYear);
    }

    public SchoolYear editSchoolYear(SchoolYear schoolYear){
        return schoolYearRepository.save(schoolYear);
    }
}
