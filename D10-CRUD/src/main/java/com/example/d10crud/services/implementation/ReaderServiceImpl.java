package com.example.d10crud.services.implementation;

import com.example.d10crud.entity.ReaderEntity;
import com.example.d10crud.repository.ReaderRepository;
import com.example.d10crud.services.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderServiceImpl implements ReaderService {
    private final ReaderRepository readerRepository;

    @Override
    public List<ReaderEntity> getAllReader() {
        return readerRepository.findAll();
    }

    @Override
    public Long insertReader(ReaderEntity readerEntity) {
        return readerRepository.save(readerEntity).getId();
    }

    @Override
    public List<ReaderEntity> getReaderById(Long readerId) {
        List<ReaderEntity> reader = new ArrayList<>();
        reader.add(readerRepository.findById(readerId).get());
        return reader;
    }
}
