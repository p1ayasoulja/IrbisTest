package com.example.irbis.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "theme")
    private String theme;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "source_id")
    private Source main_source;
    @OneToMany(mappedBy = "main_theme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Source getMain_source() {
        return main_source;
    }

    public void setMain_source(Source main_source) {
        this.main_source = main_source;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
