package hcmute.edu.vn.registertopic_be.service.Lecturer;

import hcmute.edu.vn.registertopic_be.model.entity.Lecturer;
import hcmute.edu.vn.registertopic_be.model.entity.Major;
import hcmute.edu.vn.registertopic_be.model.entity.Subject;
import hcmute.edu.vn.registertopic_be.model.mapper.SubjectMapper;
import hcmute.edu.vn.registertopic_be.model.request.SubjectRequest;
import hcmute.edu.vn.registertopic_be.repository.LecturerRepository;
import hcmute.edu.vn.registertopic_be.repository.SubjectRepository;
import hcmute.edu.vn.registertopic_be.service.Admin.LecturerService;
import hcmute.edu.vn.registertopic_be.service.Admin.StudentService;
import hcmute.edu.vn.registertopic_be.service.Admin.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LecturerSubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SubjectMapper subjectMapper;

    //Dang ky de tai
    public Subject lecturerRegisterTopic(SubjectRequest subjectRequest){
        try {
            return subjectRepository.save(subjectMapper.toEntity(subjectRequest));

        }catch (Exception e){
            throw e;
        }
    }
}
