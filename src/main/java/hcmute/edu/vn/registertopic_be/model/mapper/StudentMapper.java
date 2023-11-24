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
    @Mapping(source = "student.studentClass", target = "studentClass")
    @Mapping(source = "student.schoolYear", target = "schoolYear")
    @Mapping(source = "student.subjectId", target = "subjectId")
    @Mapping(source = "student.tasks", target = "tasks")
    @Mapping(source = "student.person", target = "personId")
    StudentResponse toResponse(Student student);

    List<StudentResponse> toStudentListDTO(List<Student> students);

    Student toEntity(StudentRequest studentRequest);
}
