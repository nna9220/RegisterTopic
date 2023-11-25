package hcmute.edu.vn.registertopic_be.model.response;

import hcmute.edu.vn.registertopic_be.model.entity.Person;
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
public class LecturerResponse implements Serializable {
    private String lecturerId;
    private String role;
    private String major;
    private Person person;
    private List<Subject> listSubInstruct;
    private List<Subject> listSubCounterArgument;
    private List<Task> tasks;
}
