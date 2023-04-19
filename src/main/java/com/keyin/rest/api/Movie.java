package com.keyin.rest.api;

import javax.persistence.*;


@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String title;
    private String genre;
    private int review;

    public Movie() {

    }

    public Movie(long id, String title, String genre, int review) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.review = review;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return ("""
                {
                    "id":%d,
                    "title":"%s",
                    "genre":"%s",
                    "review":%d
                }
                """
                .formatted(id, title, genre, review));
    }

}

