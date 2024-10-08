package com.example.Operation.Payload;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private double price;
}
