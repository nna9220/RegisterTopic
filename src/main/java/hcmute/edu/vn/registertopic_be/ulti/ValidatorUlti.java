package hcmute.edu.vn.registertopic_be.ulti;

import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;

public class ValidatorUlti {
    public HashMap<String, String> toErrors(List<FieldError> fieldErrors) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (fieldErrors != null) {
            for (FieldError fieldError : fieldErrors) {
                hashMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }

        return hashMap;
    }
}
