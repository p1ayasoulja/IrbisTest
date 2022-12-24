package com.example.irbis.reqres;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetNewsResponse {
    private Long id;
    @JsonProperty("Описание новости")
    private String MyNews;

    public GetNewsResponse(Long id, String myNews) {
        this.id = id;
        MyNews = myNews;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMyNews(String myNews) {
        MyNews = myNews;
    }
}
