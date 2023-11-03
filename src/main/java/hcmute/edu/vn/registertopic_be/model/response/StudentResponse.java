package hcmute.edu.vn.registertopic_be.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse implements Serializable {
    private int studentId;
    private String major;
}
