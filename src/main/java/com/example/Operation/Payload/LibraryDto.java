package com.example.Operation.Payload;


import com.example.Operation.Entity.Book;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class LibraryDto {
    private long id;
    private String Libraryname;
    private List<Book> bookList = new ArrayList<>();
}
