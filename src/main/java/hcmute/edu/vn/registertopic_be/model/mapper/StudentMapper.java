package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.Student;
import hcmute.edu.vn.registertopic_be.model.request.StudentRequest;
import hcmute.edu.vn.registertopic_be.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "student.studentId", target = "studentId")
    @Mapping(source = "student.major", target = "major")
    StudentResponse toResponse(Student student);

    List<StudentResponse> toStudentListDTO(List<Student> students);

    Student toEntity(StudentRequest studentRequest);
}
