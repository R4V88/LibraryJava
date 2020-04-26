package r4v88.model;

import lombok.*;
import r4v88.model.entity.UserRole;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import r4v88.model.enums.Gender;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User {
    private String name;
    private String lastname;
    private String login;
    private String email;
    private String password;
    private String dateOfBirth;
    private Gender gender;
    private UserRole userRole;
}
