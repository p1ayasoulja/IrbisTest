package com.example.irbis.service.impl;

import com.example.irbis.service.SourceService;
import com.example.irbis.Entity.Source;
import com.example.irbis.repo.SourceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SourceServiceImpl implements SourceService {
    private final SourceRepo sourceRepo;

    public SourceServiceImpl(SourceRepo sourceRepo) {
        this.sourceRepo = sourceRepo;
    }

    @Override
    public Optional<Source> getSource(Long id) {
        if (sourceRepo.existsById(id)) {
            return sourceRepo.findById(id);
        } else return Optional.empty();
    }

    @Override
    public List<Source> getAll() {
        return sourceRepo.findAll();
    }
}
