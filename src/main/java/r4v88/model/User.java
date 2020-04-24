package r4v88.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import r4v88.model.enums.Gender;
import r4v88.model.enums.Role;

@Getter
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
    private Role role;
}
