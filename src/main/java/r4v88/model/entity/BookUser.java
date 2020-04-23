package r4v88.model.entity;

import lombok.*;
import r4v88.model.Book;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class BookUser {
    private long id;

    @NonNull
    private Book book;
}
