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
public class LecturerResponse implements Serializable {
    private String lecturerId;
    private String role;
    private String major;
}
