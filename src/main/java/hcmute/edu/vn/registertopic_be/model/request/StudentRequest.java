package hcmute.edu.vn.registertopic_be.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest implements Serializable {
    private int studentId;
    private String major;
}
