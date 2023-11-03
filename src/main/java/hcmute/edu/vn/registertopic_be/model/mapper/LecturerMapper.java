package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.Lecturer;
import hcmute.edu.vn.registertopic_be.model.request.LecturerRequest;
import hcmute.edu.vn.registertopic_be.model.response.LecturerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LecturerMapper {
    @Mapping(source = "lecturer.lecturerId", target = "lecturerId")
    @Mapping(source = "lecturer.role", target = "role")
    @Mapping(source = "lecturer.major", target = "major")
    LecturerResponse toResponse(Lecturer lecturer);

    List<LecturerResponse> toLecturerListDTO(List<Lecturer> lecturers);

    Lecturer toEntity(LecturerRequest lecturerRequest);
}
