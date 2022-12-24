package com.example.irbis.service.impl;

import com.example.irbis.service.ThemeService;
import com.example.irbis.Entity.Theme;
import com.example.irbis.repo.ThemeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ThemeServiceImpl implements ThemeService {
    private final ThemeRepo themeRepo;

    public ThemeServiceImpl(ThemeRepo themeRepo) {
        this.themeRepo = themeRepo;
    }

    @Override
    public Optional<Theme> getTheme(Long id) {
        if (themeRepo.existsById(id)) {
            return themeRepo.findById(id);
        } else return Optional.empty();
    }

    @Override
    public List<Theme> getAll() {
        return themeRepo.findAll();
    }
}
