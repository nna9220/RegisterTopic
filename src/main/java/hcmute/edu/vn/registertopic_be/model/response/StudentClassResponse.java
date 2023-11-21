package hcmute.edu.vn.registertopic_be.model.response;

import hcmute.edu.vn.registertopic_be.model.entity.Student;
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
public class StudentClassResponse implements Serializable {
    private int id;
    private String classname;

    private List<Student> students;
}
