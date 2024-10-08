package com.example.Operation.Service;

import com.example.Operation.Entity.Book;
import com.example.Operation.Entity.Library;
import com.example.Operation.Payload.BookDto;
import com.example.Operation.Payload.LibraryDto;
import com.example.Operation.Payload.dtoBook;
import com.example.Operation.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository repository;
    private final ModelMapper mapper;

    public dtoBook crearteReg(dtoBook book) {
        Book save = repository.save(mapToEntity(book));
        dtoBook dtoBook = mapToDto(save);
        return dtoBook;

    }


    public dtoBook mapToDto(Book book) {
        return mapper.map(book, dtoBook.class);
    }

    public Book mapToEntity(dtoBook bookDto) {
        return mapper.map(bookDto, Book.class);
    }
}
