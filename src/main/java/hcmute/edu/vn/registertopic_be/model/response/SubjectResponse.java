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
public class SubjectResponse implements Serializable {
    private int subjectId;
    private String subjectName;
    private String major;
    private Double score;
    private String review;
    private String requirement;
    private String expected;
    private byte status;
}
