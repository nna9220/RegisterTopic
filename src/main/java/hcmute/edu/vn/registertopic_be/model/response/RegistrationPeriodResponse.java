package hcmute.edu.vn.registertopic_be.model.response;

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
public class RegistrationPeriodResponse implements Serializable {
    private int periodId;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registrationTimeStart;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registrationTimeEnd;

    private String registrationName;
    private TypeSubject typeSubjectId;
}
