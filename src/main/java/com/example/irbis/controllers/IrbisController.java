package com.example.irbis.controllers;

import com.example.irbis.Entity.News;
import com.example.irbis.reqres.GetNewsResponse;
import com.example.irbis.service.NewsService;
import com.example.irbis.service.SourceService;
import com.example.irbis.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/irbis")
public class IrbisController {
    private final NewsService newsService;
    private final ThemeService themeService;
    private final SourceService sourceService;

    @Autowired
    public IrbisController(NewsService newsService, ThemeService themeService, SourceService sourceService) {
        this.newsService = newsService;
        this.themeService = themeService;
        this.sourceService = sourceService;
    }

    @RequestMapping(value = "/news/all", method = RequestMethod.GET)
    public ResponseEntity<List<GetNewsResponse>> getAllNews() {
        List<News> newsList = newsService.getAll();
        List<GetNewsResponse> getNewsResponseList = new ArrayList<>();
        newsList.forEach(news -> getNewsResponseList.add(new GetNewsResponse(news.getId(), news.getMyNew())));
        return ResponseEntity.ok(getNewsResponseList);
    }

    @RequestMapping(value = "/news/theme/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<GetNewsResponse>> getNewsByTheme(@PathVariable("id") Long id) {
        List<News> newsList = newsService.getByTheme(id);
        List<GetNewsResponse> getNewsResponseList = new ArrayList<>();
        newsList.forEach(news -> getNewsResponseList.add(new GetNewsResponse(news.getId(), news.getMyNew())));
        return ResponseEntity.ok(getNewsResponseList);
    }

    @RequestMapping(value = "/news/source/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<GetNewsResponse>> getNewsBySource(@PathVariable("id") Long id) {
        List<News> newsList = newsService.getBySource(id);
        List<GetNewsResponse> getNewsResponseList = new ArrayList<>();
        newsList.forEach(news -> getNewsResponseList.add(new GetNewsResponse(news.getId(), news.getMyNew())));
        return ResponseEntity.ok(getNewsResponseList);
    }

}
