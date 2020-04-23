package r4v88.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import r4v88.model.enums.Role;

@Getter
@AllArgsConstructor
@ToString
public class UserRole {
    private int id;
    private Role role;
}
