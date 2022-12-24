package com.example.irbis.service;

import com.example.irbis.Entity.Theme;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface ThemeService {
    Optional<Theme> getTheme(Long id);

    List<Theme> getAll();
}
