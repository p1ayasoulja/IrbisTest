package com.example.irbis.service;

import com.example.irbis.Entity.News;
import com.example.irbis.Entity.Source;
import com.example.irbis.Entity.Theme;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface NewsService {
    Optional<News> getOneNews(Long id);

    List<News> getAll();

    //    List<News> getBySource(Source source);
    List<News> getByTheme(Long id);

    List<News> getBySource(Long id);
}
