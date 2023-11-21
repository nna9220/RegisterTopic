package hcmute.edu.vn.registertopic_be.service;

import hcmute.edu.vn.registertopic_be.model.entity.StudentClass;
import hcmute.edu.vn.registertopic_be.model.mapper.StudentClassMapper;
import hcmute.edu.vn.registertopic_be.model.request.StudentClassRequest;
import hcmute.edu.vn.registertopic_be.repository.StudentClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentClassService {
    @Autowired
    private StudentClassRepository studentClassRepository;
    @Autowired
    private StudentClassMapper studentClassMapper;
    public StudentClass createStudentClass(StudentClassRequest studentClassRequest){
        var studentClass = studentClassMapper.toEntity(studentClassRequest);
        return studentClassRepository.save(studentClass);
    }
    public List<StudentClass> findAll(){
        return studentClassRepository.getAllStudentClass();
    }

    public StudentClass getStudentClassById(int id){
        return studentClassRepository.findById(id).orElse(null);
    }

    public StudentClass editStudentClass(StudentClass studentClass){
        return studentClassRepository.save(studentClass);
    }
}
