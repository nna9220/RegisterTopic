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
public class LecturerRequest implements Serializable {
    private String lecturerId;
    private String role;
    private String major;
}
