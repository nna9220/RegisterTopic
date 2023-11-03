package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.Subject;
import hcmute.edu.vn.registertopic_be.model.request.SubjectRequest;
import hcmute.edu.vn.registertopic_be.model.response.SubjectResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    @Mapping(source = "subject.subjectId", target = "subjectId")
    @Mapping(source = "subject.subjectName", target = "subjectName")
    @Mapping(source = "subject.major", target = "major")
    @Mapping(source = "subject.score", target = "score")
    @Mapping(source = "subject.review", target = "review")
    @Mapping(source = "subject.requirement", target = "requirement")
    @Mapping(source = "subject.expected", target = "expected")
    @Mapping(source = "subject.status", target = "status")
    SubjectResponse toResponse(Subject subject);

    List<SubjectResponse> toSubjectListDTO(List<Subject> subjects);

    Subject toEntity(SubjectRequest subjectRequest);
}
