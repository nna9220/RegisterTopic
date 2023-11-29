package hcmute.edu.vn.registertopic_be.controller.Lecturer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lecturer/home")
public class HomeLecturerController {
    @GetMapping
    public ResponseEntity<?> getHome(){
        return ResponseEntity.ok("Home Lecturer");
    }
}
