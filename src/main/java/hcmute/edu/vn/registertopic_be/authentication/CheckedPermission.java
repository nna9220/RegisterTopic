package hcmute.edu.vn.registertopic_be.authentication;

import hcmute.edu.vn.registertopic_be.model.entity.Person;
import hcmute.edu.vn.registertopic_be.repository.PersonRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CheckedPermission {
    public static boolean isAdmin(PersonRepository personRepository) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email");
        Person currentUser = personRepository.getUserByEmail(email);
        return currentUser != null && currentUser.getRole().name().equals("Admin");
    }
    public static boolean isStudent(PersonRepository personRepository) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email");
        Person currentUser = personRepository.getUserByEmail(email);
        return currentUser != null && currentUser.getRole().name().equals("Student");
    }

    public static boolean isGuest(PersonRepository personRepository) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email");
        Person currentUser = personRepository.getUserByEmail(email);
        return currentUser != null && currentUser.getRole().name().equals("Guest");
    }

    public static boolean isLecturer(PersonRepository personRepository) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email");
        Person currentUser = personRepository.getUserByEmail(email);
        return currentUser != null && currentUser.getRole().name().equals("Lecturer");
    }

    public static boolean isHeadOfDepartment(PersonRepository personRepository) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2User user = (OAuth2User) authentication.getPrincipal();
        String email = user.getAttribute("email");
        Person currentUser = personRepository.getUserByEmail(email);
        return currentUser != null && currentUser.getRole().name().equals("HeadOfDepartment");
    }
}
