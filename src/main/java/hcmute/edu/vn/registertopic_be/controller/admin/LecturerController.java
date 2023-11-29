package hcmute.edu.vn.registertopic_be.controller.admin;

import hcmute.edu.vn.registertopic_be.authentication.CheckedPermission;
import hcmute.edu.vn.registertopic_be.model.entity.*;
import hcmute.edu.vn.registertopic_be.model.mapper.LecturerMapper;
import hcmute.edu.vn.registertopic_be.model.request.LecturerRequest;
import hcmute.edu.vn.registertopic_be.model.request.PersonRequest;
import hcmute.edu.vn.registertopic_be.repository.LecturerRepository;
import hcmute.edu.vn.registertopic_be.repository.PersonRepository;
import hcmute.edu.vn.registertopic_be.service.Admin.LecturerService;
import hcmute.edu.vn.registertopic_be.service.Admin.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/lecturer")
public class LecturerController {
    private static final Logger logger = LoggerFactory.getLogger(LecturerController.class);

    @Autowired
    private LecturerService lecturerService;
    @Autowired
    private LecturerMapper lecturerMapper;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private LecturerRepository lecturerRepository;
    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllLecturer(){
        List<Lecturer> lecturers = lecturerService.getAllLec();
        return ResponseEntity.ok(lecturerMapper.toLecturerListDTO(lecturers));
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
                                                    @RequestParam(value = "role", required = true) String role){

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
                newPerson.setRole(Role.valueOf(role));
                var person = personRepository.save(newPerson);

                System.out.println(person.getPersonId());
                System.out.println(newPerson.getPersonId() + "xem thu ne "+ newPerson.getLastName());

                //Tạo giảng viên -> lấy id từ person vừa tạo
                LecturerRequest newLecturer = new LecturerRequest();
                newLecturer.setLecturerId(personId);
                newLecturer.setPerson(person);
                newLecturer.setRole(role);
                newLecturer.setMajor(major);
                System.out.println(newLecturer.getLecturerId() + " " + newLecturer.getPerson() + " " + newLecturer.getMajor()
                        + " "+ newLecturer.getRole() + " " + newLecturer.getTasks());
                lecturerRepository.save(lecturerMapper.toEntity(newLecturer));

                return new ResponseEntity<>(newLecturer, HttpStatus.CREATED);
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
        if (CheckedPermission.isAdmin(personRepository)) {
            return new ResponseEntity<>(personService.editPerson(id, request), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable String id){
        if (CheckedPermission.isAdmin(personRepository)) {
            return new ResponseEntity<>(personService.deletePerson(id), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getDetail(@PathVariable String id){
        if (CheckedPermission.isAdmin(personRepository)) {
            return new ResponseEntity<>(lecturerService.detail(id),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
