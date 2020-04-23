package r4v88.model.entity;

import lombok.*;
import r4v88.model.enums.Role;


@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class UserRole {
    private long id;
    @NonNull private Role role;
}
