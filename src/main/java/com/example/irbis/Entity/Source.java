package com.example.irbis.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sources")
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "source")
    private String source;

    @OneToMany(mappedBy = "main_source", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Theme> themes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }
}
