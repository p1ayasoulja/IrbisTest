package com.example.irbis.Entity;

import javax.persistence.*;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "my_news")
    private String MyNews;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "theme_id")
    private Theme main_theme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMyNew() {
        return MyNews;
    }

    public void setMyNew(String myNew) {
        MyNews = myNew;
    }

    public Theme getMain_theme() {
        return main_theme;
    }

    public void setMain_theme(Theme main_theme) {
        this.main_theme = main_theme;
    }
}
