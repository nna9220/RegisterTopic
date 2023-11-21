package hcmute.edu.vn.registertopic_be.model.request;

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
public class SchoolYearRequest implements Serializable {
    private int yearId;
    private String year;

    private List<Student> students;
}
