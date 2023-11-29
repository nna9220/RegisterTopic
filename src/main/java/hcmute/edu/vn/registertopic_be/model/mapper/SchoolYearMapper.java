package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.SchoolYear;
import hcmute.edu.vn.registertopic_be.model.request.SchoolYearRequest;
import hcmute.edu.vn.registertopic_be.model.response.SchoolYearResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolYearMapper {
    @Mapping(source = "schoolYear.yearId", target = "yearId")
    @Mapping(source = "schoolYear.year", target = "year")
    @Mapping(source = "schoolYear.students", target = "students")
    SchoolYearResponse toResponse(SchoolYear schoolYear);

    List<SchoolYearResponse> toSchoolYearListDTO(List<SchoolYear> schoolYears);

    SchoolYear toEntity(SchoolYearRequest schoolYearRequest);
}
