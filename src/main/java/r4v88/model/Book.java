package r4v88.model;

import lombok.*;
<<<<<<< HEAD
import r4v88.model.entity.BookUser;
import r4v88.model.enums.Type;

@Getter
@AllArgsConstructor
=======
import r4v88.model.enums.Type;

@Getter
>>>>>>> dev
@ToString
@EqualsAndHashCode
@Builder
public class Book {
    private String title;
    private int isbn;
    private String publisher;
    private String year;
    private Type type;
    private boolean isBorrowed;
<<<<<<< HEAD
    private BookUser bookUser;
}
=======
}
>>>>>>> dev
