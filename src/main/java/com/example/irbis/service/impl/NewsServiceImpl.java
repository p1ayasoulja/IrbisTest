package com.example.irbis.service.impl;

import com.example.irbis.Entity.Source;
import com.example.irbis.service.NewsService;
import com.example.irbis.Entity.News;
import com.example.irbis.Entity.Theme;
import com.example.irbis.repo.NewsRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepo newsRepo;

    public NewsServiceImpl(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }

    @Override
    public Optional<News> getOneNews(Long id) {
        if (newsRepo.existsById(id)) {
            return newsRepo.findById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<News> getAll() {
        return newsRepo.findAll();
    }

    @Override
    public List<News> getByTheme(Long id) {
        List<News> allNews = newsRepo.findAll();
        List<News> newsByThemeList = new ArrayList<>();
        allNews.forEach(news -> {
            if (news.getMain_theme().getId() == id) {
                newsByThemeList.add(news);
            }
        });
        return newsByThemeList;
    }

    @Override
    public List<News> getBySource(Long id) {
        List<News> allNews = newsRepo.findAll();
        List<News> newsByThemeList = new ArrayList<>();
        allNews.forEach(news -> {
            if (news.getMain_theme().getMain_source().getId() == id) {
                newsByThemeList.add(news);
            }
        });
        return newsByThemeList;
    }
}
