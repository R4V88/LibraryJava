package r4v88.model;

import lombok.*;
import r4v88.model.enums.Type;

@Getter
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
}