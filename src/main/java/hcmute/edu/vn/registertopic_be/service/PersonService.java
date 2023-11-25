package hcmute.edu.vn.registertopic_be.service;

import hcmute.edu.vn.registertopic_be.exception.NotFoundException;
import hcmute.edu.vn.registertopic_be.model.entity.Person;
import hcmute.edu.vn.registertopic_be.model.entity.Role;
import hcmute.edu.vn.registertopic_be.model.mapper.PersonMapper;
import hcmute.edu.vn.registertopic_be.model.request.PersonRequest;
import hcmute.edu.vn.registertopic_be.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonMapper personMapper;
    private final String CLASS_NOT_FOUND = "Class not found";
    public List<Person> findAll(){
        return personRepository.findAllPerson();
    }
    public Person savePerson(PersonRequest personRequest){
        var person = personMapper.toEntity(personRequest);
        return personRepository.save(person);
    }
    public Person getUserByEmail(String email){
        return personRepository.findByEmail(email).orElse(null);
    }

    public String processOAuthPostLogin(String email){
        Person existPerson = personRepository.getUserByEmail(email);
        String url = "";
        if (existPerson != null) {
            // Nếu người dùng có trong database
            Role role = existPerson.getRole();
            if (role.equals(Role.Admin)){
                url = "/admin/home";
            } else if (role.equals(Role.Student)) {
                url = "/student/home";
            } else if (role.equals(Role.Lecturer)) {
                url = "/lecturer/home";
            } else if (role.equals(Role.HeadOfDepartment)) {
                url = "/headOfDepartment/home";
            }
        } else {
            // Nếu không tìm thấy người dùng, ném ngoại lệ UserNotFoundException
            throw new UsernameNotFoundException("User not found in the database");
        }
        return url;
    }

    public Person editPerson(String id, PersonRequest personRequest){
        Person oldPerson = personRepository.findById(id).orElse(null);
        if (oldPerson!=null){
            oldPerson.setStatus(personRequest.isStatus());
            oldPerson.setPhone(personRequest.getPhone());
            oldPerson.setLastName(personRequest.getLastName());
            oldPerson.setFirstName(personRequest.getFirstName());
            oldPerson.setBirthDay(String.valueOf(personRequest.getBirthDay()));
            oldPerson.setRole(Role.valueOf(personRequest.getRole()));
            return personRepository.save(oldPerson);
        }else {
            throw new NotFoundException(CLASS_NOT_FOUND);
        }
    }

    public Person deletePerson(String id){
        Person oldPerson = personRepository.findById(id).orElse(null);
        if (oldPerson!=null){
            oldPerson.setStatus(false);
            return personRepository.save(oldPerson);
        }else {
            throw new NotFoundException(CLASS_NOT_FOUND);
        }
    }

    public Person detailPerson(String id){
        Person existedPerson = personRepository.findById(id).orElse(null);
        if (existedPerson!=null){
            return existedPerson;
        }else {
            throw new NotFoundException(CLASS_NOT_FOUND);
        }
    }

}
