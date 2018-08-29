package com.example.waelelsharkawy.newsfeedapp;

public class News {
    private String article_title;
    private String section_name;
    private String author_name;
    private String publish_date;
    private String web_url;

    News(String article_title, String section_name, String auther_name, String publish_date, String web_url) {
        this.article_title = article_title;
        this.section_name = section_name;
        this.author_name = auther_name;
        this.publish_date = publish_date;
        this.web_url = web_url;
    }

    public String getArticle_title() {
        return article_title;
    }

    public String getSection_name() {
        return section_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public String getWeb_url() {
        return web_url;
    }
}
