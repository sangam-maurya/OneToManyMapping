package com.example.Operation.Controller;

import com.example.Operation.Payload.BookDto;
import com.example.Operation.Payload.dtoBook;
import com.example.Operation.Service.BookService;
import com.example.Operation.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    @PostMapping
    public dtoBook createReg (@RequestBody dtoBook bookDto){
        dtoBook bookDto1 = service.crearteReg(bookDto);
        return bookDto;
    }
}
