package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.Person;
import hcmute.edu.vn.registertopic_be.model.request.PersonRequest;
import hcmute.edu.vn.registertopic_be.model.response.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    @Mapping(source = "person.personId", target = "personId")
    @Mapping(source = "person.lastName", target = "lastName")
    @Mapping(source = "person.firstName", target = "firstName")
    @Mapping(source = "person.email", target = "email")
    @Mapping(source = "person.phone", target = "phone")
    @Mapping(source = "person.gender", target = "gender")
    @Mapping(source = "person.role", target = "role")
    @Mapping(source = "person.birthDay", target = "birthDay")
    @Mapping(source = "person.status", target = "status")
    @Mapping(source = "person.comments", target = "comments")
    PersonResponse toResponse(Person person);

    List<PersonResponse> toPersonListDTO(List<Person> persons);

    Person toEntity(PersonRequest personRequest);
}
