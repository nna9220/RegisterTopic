package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.StudentClass;
import hcmute.edu.vn.registertopic_be.model.request.StudentClassRequest;
import hcmute.edu.vn.registertopic_be.model.response.StudentClassResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentClassMapper {
    @Mapping(source = "studentClass.id", target = "id")
    @Mapping(source = "studentClass.classname", target = "classname")
    @Mapping(source = "studentClass.students", target = "students")
    StudentClassResponse toResponse(StudentClass studentClass);

    List<StudentClassResponse> toStudentClassListDTO(List<StudentClass> studentClasses);

    StudentClass toEntity(StudentClassRequest studentClassRequest);
}
