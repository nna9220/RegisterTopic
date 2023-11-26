package hcmute.edu.vn.registertopic_be.model.request;

import hcmute.edu.vn.registertopic_be.model.entity.Lecturer;
import hcmute.edu.vn.registertopic_be.model.entity.Student;
import hcmute.edu.vn.registertopic_be.model.entity.Task;
import hcmute.edu.vn.registertopic_be.model.entity.TypeSubject;
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
public class SubjectRequest implements Serializable {
    private int subjectId;
    private String subjectName;
    private String major;
    private Double score;
    private String review;
    private String requirement;
    private String expected;
    private byte status;

    private TypeSubject typeSubject;
    private Lecturer instructorId;
    private Lecturer thesisAdvisorId;
    private String student1;
    private String student2;
    private List<Task> tasks;
    private String year;
}
