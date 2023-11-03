package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.RegistrationPeriod;
import hcmute.edu.vn.registertopic_be.model.request.RegistrationPeriodRequest;
import hcmute.edu.vn.registertopic_be.model.response.RegistrationPeriodResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistrationPeriodMapper {
    @Mapping(source = "registrationPeriod.periodId", target = "periodId")
    @Mapping(source = "registrationPeriod.registrationTime", target = "registrationTime")
    @Mapping(source = "registrationPeriod.registrationName", target = "registrationName")
    RegistrationPeriodResponse toResponse(RegistrationPeriod registrationPeriod);

    List<RegistrationPeriodResponse> toRegistrationPeriodListDTO(List<RegistrationPeriod> registrationPeriods);

    RegistrationPeriod toEntity(RegistrationPeriodRequest registrationPeriodRequest);
}
