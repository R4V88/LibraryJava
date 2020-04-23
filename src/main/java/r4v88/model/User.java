package r4v88.model;

import lombok.*;
import r4v88.model.entity.UserRole;
import r4v88.model.enums.Gender;
import r4v88.model.enums.Role;

@Builder
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
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
