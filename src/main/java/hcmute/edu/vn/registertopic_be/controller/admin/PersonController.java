package hcmute.edu.vn.registertopic_be.controller.admin;

import hcmute.edu.vn.registertopic_be.authentication.CheckedPermission;
import hcmute.edu.vn.registertopic_be.model.entity.Person;
import hcmute.edu.vn.registertopic_be.repository.PersonRepository;
import hcmute.edu.vn.registertopic_be.service.Admin.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin/users")
public class    PersonController {
    @Autowired
    PersonService personService;
    //@Autowired
    //PersonMapper personMapper;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/list")
    public ResponseEntity<?> getUserExisted(){
        if (CheckedPermission.isAdmin(personRepository)) {
            List<Person> persons = personService.findAll();
            return ResponseEntity.ok(persons/*personMapper.toPersonListDTO(persons)*/);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @GetMapping("/current")
    public ResponseEntity<?> getUser(){
        if (CheckedPermission.isAdmin(personRepository)) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Person currentUser = (Person) authentication.getPrincipal();
            return ResponseEntity.ok(currentUser);
        }
        else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
