package hcmute.edu.vn.registertopic_be.model.response;

import hcmute.edu.vn.registertopic_be.model.entity.*;
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
public class StudentResponse implements Serializable {
    private String studentId;
    private String major;
    private StudentClass studentClass;
    private SchoolYear schoolYear;
    private Subject subjectId;
    private List<Task> tasks;
    private Person personId;
}
