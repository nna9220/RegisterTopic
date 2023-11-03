package hcmute.edu.vn.registertopic_be.service;

import hcmute.edu.vn.registertopic_be.model.entity.Person;
import hcmute.edu.vn.registertopic_be.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public List<Person> findAll(){
        return personRepository.findAllPerson();
    }
}
