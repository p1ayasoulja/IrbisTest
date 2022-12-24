package com.example.irbis.service;

import com.example.irbis.Entity.Source;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface SourceService {
    Optional<Source> getSource(Long id);
    List<Source> getAll();
}
