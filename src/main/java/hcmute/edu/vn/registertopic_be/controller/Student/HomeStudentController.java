package hcmute.edu.vn.registertopic_be.controller.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student/home")
public class HomeStudentController {
    @GetMapping
    public ResponseEntity<?> getHome(){
        return ResponseEntity.ok("Home student");
    }
}
