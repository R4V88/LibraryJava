package r4v88.model.entity;

import lombok.*;
import r4v88.model.Book;

@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class UserBook {
    private long id;
    @NonNull private Book book;
}
