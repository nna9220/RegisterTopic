package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.TypeSubject;
import hcmute.edu.vn.registertopic_be.model.request.TypeSubjectRequest;
import hcmute.edu.vn.registertopic_be.model.response.TypeSubjectResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeSubjectMapper {
    @Mapping(source = "typeSubject.typeId", target = "typeId")
    @Mapping(source = "typeSubject.typeName", target = "typeName")
    TypeSubjectResponse toResponse(TypeSubject typeSubject);

    List<TypeSubjectResponse> toTypeSubjectListDTO(List<TypeSubject> typeSubjects);

    TypeSubject toEntity(TypeSubjectRequest typeSubjectRequest);
}
