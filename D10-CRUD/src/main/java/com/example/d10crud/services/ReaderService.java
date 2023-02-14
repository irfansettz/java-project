package com.example.d10crud.services;

import com.example.d10crud.entity.ReaderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReaderService {
    List<ReaderEntity> getAllReader();

    Long insertReader(ReaderEntity readerEntity);

    List<ReaderEntity> getReaderById(Long readerId);
}
