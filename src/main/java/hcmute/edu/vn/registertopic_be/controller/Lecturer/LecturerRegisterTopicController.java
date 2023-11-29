package hcmute.edu.vn.registertopic_be.controller.Lecturer;

import hcmute.edu.vn.registertopic_be.authentication.CheckedPermission;
import hcmute.edu.vn.registertopic_be.controller.admin.LecturerController;
import hcmute.edu.vn.registertopic_be.model.entity.*;
import hcmute.edu.vn.registertopic_be.model.mapper.SubjectMapper;
import hcmute.edu.vn.registertopic_be.model.request.SubjectRequest;
import hcmute.edu.vn.registertopic_be.repository.*;
import hcmute.edu.vn.registertopic_be.service.Admin.StudentService;
import hcmute.edu.vn.registertopic_be.service.Admin.SubjectService;
import hcmute.edu.vn.registertopic_be.service.Lecturer.LecturerSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/lecturer/subject")
public class LecturerRegisterTopicController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private LecturerSubjectService lecturerSubjectService;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TypeSubjectRepository typeSubjectRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    private static final Logger logger = LoggerFactory.getLogger(LecturerController.class);

    @PostMapping("/register")
    public ResponseEntity<?> lecturerRegisterTopic(@RequestParam("topicName") String name,
                                                   @RequestParam("major") String major,
                                                   @RequestParam("typeSubject") int typeSubject,
                                                   @RequestParam("requirement") String requirement,
                                                   @RequestParam("expected") String expected,
                                                   @RequestParam(value = "student1", required = false) String student1,
                                                   @RequestParam(value = "student2", required = false) String student2) {

        try {

            SubjectRequest newSubject = new SubjectRequest();
            newSubject.setSubjectName(name);
            newSubject.setMajor(major);
            //Tim typeSubject theo id
            TypeSubject existedType = typeSubjectRepository.findById(typeSubject).orElse(null);
            newSubject.setTypeSubject(existedType);

            newSubject.setExpected(expected);
            newSubject.setRequirement(requirement);
            Subject subjectEntity = subjectMapper.toEntity(newSubject);
            subjectRepository.save(subjectEntity);
            if (existedType!=null){
                existedType.setSubjectsList(Collections.singletonList(subjectEntity));
            }
            //Tim student
            System.out.println("Id: " + newSubject.getSubjectId());
            if (StringUtils.hasText(student1)) {
                var existedStudent1 = studentRepository.findById(student1).orElse(null);
                if (existedStudent1 != null) {
                    subjectEntity.setStudent1(student1);
                    existedStudent1.setSubjectId(subjectEntity);
                    studentRepository.save(existedStudent1);
                }
            }
            if (StringUtils.hasText(student2)) {
                var existedStudent2 = studentRepository.findById(student2).orElse(null);
                if (existedStudent2 != null) {
                    subjectEntity.setStudent2(student2);
                    existedStudent2.setSubjectId(subjectEntity);
                    studentRepository.save(existedStudent2);
                }
            }
            //Tim giang vien dang dang ky de tai
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            OAuth2User user = (OAuth2User) authentication.getPrincipal();
            String email = user.getAttribute("email");
            Person currentUser = personRepository.getUserByEmail(email);
            Lecturer existedLecturer = lecturerRepository.findById(currentUser.getPersonId()).orElse(null);
            //Tao list Subject
            if (existedLecturer != null) {
                subjectEntity.setInstructorId(existedLecturer);
                existedLecturer.setListSubInstruct(Collections.singletonList(subjectEntity));
                lecturerRepository.save(existedLecturer);
            }
            int currentYear = Year.now().getValue();
            subjectEntity.setYear(String.valueOf(currentYear));

            subjectRepository.save(subjectEntity);
            return new ResponseEntity<>(subjectMapper.toResponse(subjectEntity), HttpStatus.CREATED);
        }catch (Exception e){
            logger.error("Lỗi: "+e.getMessage());
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
