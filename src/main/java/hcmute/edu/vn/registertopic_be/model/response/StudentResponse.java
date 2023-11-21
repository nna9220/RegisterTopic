package hcmute.edu.vn.registertopic_be.model.response;

import hcmute.edu.vn.registertopic_be.model.entity.SchoolYear;
import hcmute.edu.vn.registertopic_be.model.entity.StudentClass;
import hcmute.edu.vn.registertopic_be.model.entity.Subject;
import hcmute.edu.vn.registertopic_be.model.entity.Task;
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
    private int studentId;
    private String major;
    private StudentClass studentClass;
    private SchoolYear schoolYear;
    private Subject subjectId;
    private List<Task> tasks;
}
