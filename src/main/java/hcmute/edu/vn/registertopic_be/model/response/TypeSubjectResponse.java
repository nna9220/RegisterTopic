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
public class TypeSubjectResponse implements Serializable {
    private int typeId;
    private String typeName;
}
