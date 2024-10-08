package com.example.Operation.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Libraryname;
    @OneToMany(mappedBy = "library" , cascade = CascadeType.ALL , orphanRemoval = true)
    @JsonManagedReference
    private List<Book> bookList = new ArrayList<>();
}
