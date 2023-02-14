package com.example.d10crud.controller;

import com.example.d10crud.dto.ResponseBookDTO;
import com.example.d10crud.dto.ResponseReaderDTO;
import com.example.d10crud.entity.ReaderEntity;
import com.example.d10crud.services.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;
    @GetMapping
    public ResponseReaderDTO getReaders(){
        ResponseReaderDTO response = new ResponseReaderDTO();
        response.setCode(200);
        response.setMessage("success");
        response.setData(readerService.getAllReader());
        return response;
    }

    @PostMapping
    public ResponseReaderDTO insertReader(@RequestBody ReaderEntity readerEntity){
        Long readerId = readerService.insertReader(readerEntity);
        ResponseReaderDTO response = new ResponseReaderDTO();
        response.setCode(201);
        response.setMessage("Data created");
        response.setData(readerService.getReaderById(readerId));
        return response;
    }
}
