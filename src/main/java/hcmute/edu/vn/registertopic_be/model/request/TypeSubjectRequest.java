package hcmute.edu.vn.registertopic_be.model.request;

import hcmute.edu.vn.registertopic_be.model.entity.RegistrationPeriod;
import hcmute.edu.vn.registertopic_be.model.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TypeSubjectRequest implements Serializable {
    private int typeId;
    private String typeName;
    private List<Subject> subjectsList;
    private List<RegistrationPeriod> registrationPeriods;
}
