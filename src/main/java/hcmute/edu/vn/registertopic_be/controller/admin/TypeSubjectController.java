package hcmute.edu.vn.registertopic_be.controller.admin;

import hcmute.edu.vn.registertopic_be.authentication.CheckedPermission;
import hcmute.edu.vn.registertopic_be.model.entity.TypeSubject;
import hcmute.edu.vn.registertopic_be.model.mapper.TypeSubjectMapper;
import hcmute.edu.vn.registertopic_be.model.request.TypeSubjectRequest;
import hcmute.edu.vn.registertopic_be.repository.PersonRepository;
import hcmute.edu.vn.registertopic_be.service.TypeSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Bảng cứng, không thực hiện thêm
@RestController
@RequestMapping("/api/admin/typeSubject")
public class TypeSubjectController {
    @Autowired
    private TypeSubjectService typeSubjectService;
    @Autowired
    private TypeSubjectMapper typeSubjectMapper;
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/list")
    public ResponseEntity<?> getAllTypeSubjectExisted(){
        if (CheckedPermission.isAdmin(personRepository)) {
            List<TypeSubject> typeSubjects = typeSubjectService.findAll();
            return ResponseEntity.ok(typeSubjectMapper.toTypeSubjectListDTO(typeSubjects));
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> saveTypeSubject(@RequestBody TypeSubjectRequest typeSubjectRequest){
        if (CheckedPermission.isAdmin(personRepository)) {
            typeSubjectRequest.setTypeName(typeSubjectRequest.getTypeName());
        /*{
          "typeName": "Tiểu Luận Chuyên Ngành"
            },
            {
          "typeName": "Khóa Luận Tốt Nghiệp"
        }*/
            return new ResponseEntity<>(typeSubjectService.createTypeSubject(typeSubjectRequest), HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
