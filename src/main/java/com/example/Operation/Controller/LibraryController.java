package com.example.Operation.Controller;

import com.example.Operation.Entity.Library;
import com.example.Operation.Payload.LibraryDto;
import com.example.Operation.Service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LibraryController {

    private final LibraryService service;
    @PostMapping
    public LibraryDto createReg(@RequestBody LibraryDto library){
        LibraryDto reg = service.createReg(library);
        return reg;
    }
    @GetMapping
    public List<LibraryDto> getAllData(){
        List<LibraryDto> allData = service.findAllData();
        return allData;
    }
    @GetMapping("/{id}")
    public LibraryDto findByid(@PathVariable long id){
        LibraryDto byId = service.findById(id);
        return byId;
    }
}
