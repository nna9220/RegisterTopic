package hcmute.edu.vn.registertopic_be.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import hcmute.edu.vn.registertopic_be.model.entity.TypeSubject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationPeriodRequest implements Serializable {
    private int periodId;

    private Date registrationTimeStart;
    private Date registrationTimeEnd;

    private String registrationName;
    private TypeSubject typeSubjectId;
}
