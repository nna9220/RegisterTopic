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
public class StudentClassResponse implements Serializable {
    private int id;
    private String classname;
}
