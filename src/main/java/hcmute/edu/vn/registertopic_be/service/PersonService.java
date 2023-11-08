package hcmute.edu.vn.registertopic_be.service;

import hcmute.edu.vn.registertopic_be.model.entity.Person;
import hcmute.edu.vn.registertopic_be.model.entity.Role;
import hcmute.edu.vn.registertopic_be.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public List<Person> findAll(){
        return personRepository.findAllPerson();
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

}
