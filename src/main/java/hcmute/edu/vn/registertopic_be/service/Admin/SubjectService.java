package hcmute.edu.vn.registertopic_be.service.Admin;

import hcmute.edu.vn.registertopic_be.model.entity.Subject;
import hcmute.edu.vn.registertopic_be.model.mapper.SubjectMapper;
import hcmute.edu.vn.registertopic_be.model.response.SubjectResponse;
import hcmute.edu.vn.registertopic_be.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectMapper subjectMapper;

    public List<Subject> getAll(){
        return subjectRepository.findAllSubject();
    }
}
