package hcmute.edu.vn.registertopic_be.controller.admin;

import hcmute.edu.vn.registertopic_be.model.entity.Person;
import hcmute.edu.vn.registertopic_be.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class    PersonController {
    @Autowired
    PersonService personService;
    //@Autowired
    //PersonMapper personMapper;

    @GetMapping("/list")
    public ResponseEntity<?> getUserExisted(){
        List<Person> persons = personService.findAll();
        return ResponseEntity.ok( persons/*personMapper.toPersonListDTO(persons)*/);
    }
}
