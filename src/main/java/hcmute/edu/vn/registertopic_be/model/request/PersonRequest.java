package hcmute.edu.vn.registertopic_be.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import hcmute.edu.vn.registertopic_be.model.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest implements Serializable {
    private int personId;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    private byte gender;
    private String role;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDay;

    private String password;
    private boolean status;

    private List<Comment> comments;
}
