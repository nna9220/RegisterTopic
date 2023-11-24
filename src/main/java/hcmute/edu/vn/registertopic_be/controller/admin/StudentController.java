package hcmute.edu.vn.registertopic_be.controller.admin;

import hcmute.edu.vn.registertopic_be.authentication.CheckedPermission;
import hcmute.edu.vn.registertopic_be.model.entity.*;
import hcmute.edu.vn.registertopic_be.model.mapper.StudentMapper;
import hcmute.edu.vn.registertopic_be.model.request.PersonRequest;
import hcmute.edu.vn.registertopic_be.model.request.StudentRequest;
import hcmute.edu.vn.registertopic_be.repository.PersonRepository;
import hcmute.edu.vn.registertopic_be.repository.SchoolYearRepository;
import hcmute.edu.vn.registertopic_be.repository.StudentClassRepository;
import hcmute.edu.vn.registertopic_be.service.PersonService;
import hcmute.edu.vn.registertopic_be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/admin/student")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentClassRepository studentClassRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private SchoolYearRepository schoolYearRepository;
    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentMapper.toStudentListDTO(studentList));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStudentAndPerson(@RequestParam(value = "personId", required = true) String personId,
                                                    @RequestParam(value = "firstName", required = true) String firstName,
                                                    @RequestParam(value = "lastName", required = true) String lastName,
                                                    @RequestParam(value = "email", required = true) String email,
                                                    @RequestParam(value = "gender", required = true) Byte gender,
                                                    @RequestParam(value = "birthDay", required = true) String birthDay,
                                                    @RequestParam(value = "phone", required = true) String phone,
                                                    @RequestParam(value = "major", required = true) String major,
                                                    @RequestParam(value = "class", required = true) int classId,
                                                    @RequestParam(value = "year", required = true) int yearId){

        try {
            if (CheckedPermission.isAdmin(personRepository)) {
                //Tạo person
                Person newPerson = new Person();
                newPerson.setPersonId(personId);
                newPerson.setFirstName(firstName);
                newPerson.setLastName(lastName);
                newPerson.setEmail(email);
                newPerson.setGender(gender);
                newPerson.setBirthDay(birthDay);
                newPerson.setPhone(phone);
                newPerson.setStatus(true);
                newPerson.setRole(Role.valueOf("Student"));
                var person = personRepository.save(newPerson);
                System.out.println(person.getPersonId());
                System.out.println(newPerson.getPersonId() + " "+ newPerson.getLastName());
                //Tạo sinh viên -> lấy id từ person vừa tạo
                StudentRequest newStudent = new StudentRequest();
                newStudent.setStudentId(newPerson.getPersonId());
                newStudent.setPersonId(person);
                newStudent.setMajor(major);
                List<Student> addStudent = new ArrayList<>();
                addStudent.add(studentMapper.toEntity(newStudent));
                //Tìm class với id tương ứng
                StudentClass existClass = studentClassRepository.findById(classId).orElse(null);
                if (existClass != null) {
                    newStudent.setStudentClass(existClass);
                    existClass.setStudents(addStudent);
                    studentClassRepository.save(existClass);
                }else {
                    System.out.println("Khong tim thay class");
                }
                //Tìm year với id tương ứng.
                SchoolYear existYear = schoolYearRepository.findById(yearId).orElse(null);
                if (existYear!= null) {
                    newStudent.setSchoolYear(existYear);
                    existYear.setStudents(addStudent);
                    System.out.println("Year: "+existYear.getStudents().get(0).getStudentId());
                    System.out.println(existYear.getStudents().get(0).getStudentId());
                    schoolYearRepository.save(existYear);
                }else {
                    System.out.println("Khong tim thay schoolYear");
                }
                for (Student x: existYear.getStudents()) {
                    System.out.println(x.getStudentId());
                    System.out.println(existYear.getStudents().size());
                }
                for (Student x: existClass.getStudents()) {
                    System.out.println("Class "+x.getStudentId());
                    System.out.println(existYear.getStudents().size());
                }
                Student saveStudent = studentService.saveStudent(newStudent);
                System.out.println(saveStudent.getPerson() + "" + newStudent.getPersonId());
                return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }catch (Exception e){
            logger.error("Lỗi: "+e.getMessage());
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable String id, @RequestBody PersonRequest request){
        return new ResponseEntity<>(personService.editPerson(id,request), HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id){
        return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.OK);
    }
}
