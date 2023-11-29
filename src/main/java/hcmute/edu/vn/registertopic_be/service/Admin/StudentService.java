package hcmute.edu.vn.registertopic_be.service.Admin;

import hcmute.edu.vn.registertopic_be.exception.NotFoundException;
import hcmute.edu.vn.registertopic_be.model.entity.Student;
import hcmute.edu.vn.registertopic_be.model.mapper.StudentMapper;
import hcmute.edu.vn.registertopic_be.model.request.StudentRequest;
import hcmute.edu.vn.registertopic_be.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;
    private final String CLASS_NOT_FOUND = "Class not found";
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    public Student saveStudent(StudentRequest studentRequest){
        var student = studentMapper.toEntity(studentRequest);
        return studentRepository.save(student);
    }

    public Student detail(String id){
        Student existedStudent = studentRepository.findById(id).orElse(null);
        if (existedStudent!=null){
            return existedStudent;
        }else {
            throw new NotFoundException(CLASS_NOT_FOUND);
        }
    }

}
