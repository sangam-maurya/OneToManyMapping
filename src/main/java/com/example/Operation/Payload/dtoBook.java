package com.example.Operation.Payload;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class dtoBook {
    private Long id;
    private String title;
    private String author;
    private double price;
    private dtoLibrary library;
}
