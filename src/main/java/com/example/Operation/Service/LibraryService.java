package com.example.Operation.Service;


import com.example.Operation.Entity.Library;
import com.example.Operation.Excpection.ResourceNotFoundException;
import com.example.Operation.Payload.LibraryDto;
import com.example.Operation.repo.LibraryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@org.springframework.stereotype.Service
public class LibraryService {

    private final LibraryRepository repository;
    private final ModelMapper mapper;

    @Transactional
    public LibraryDto createReg( LibraryDto library){
        Library libraryEntity = mapToEntiy(library);
        if (libraryEntity.getBookList() != null) {
            libraryEntity.getBookList().forEach(book -> book.setLibrary(libraryEntity));
        }
        Library savedLibrary = repository.save(libraryEntity);
        return mapToDto(savedLibrary);
    }

    public List<LibraryDto> findAllData(){
        List<Library> all = repository.findAll();
        List<LibraryDto> libraryDtoStream = all.stream().map(r -> mapToDto(r)).toList();
        return libraryDtoStream;
    }

    public LibraryDto mapToDto(Library library){
        LibraryDto map = mapper.map(library, LibraryDto.class);
        return map;
    }
    public Library mapToEntiy(LibraryDto libraryDto){
        Library map = mapper.map(libraryDto, Library.class);
        return map;
    }

    public LibraryDto findById( long id){
        Library resourceNotFound = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        LibraryDto libraryDto = mapToDto(resourceNotFound);
        return libraryDto;
    }
}

