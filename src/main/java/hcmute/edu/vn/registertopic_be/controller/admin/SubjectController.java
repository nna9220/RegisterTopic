package hcmute.edu.vn.registertopic_be.controller.admin;

import hcmute.edu.vn.registertopic_be.model.mapper.SubjectMapper;
import hcmute.edu.vn.registertopic_be.service.Admin.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(subjectMapper.toSubjectListDTO(subjectService.getAll()));
    }
}
