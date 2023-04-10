package com.keyin.rest.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Movie {
/*
    {
        "id":1,
            "title":"Search for the Beast",
            "genre":"Horror",
            "year":2008,
    }
*/
@Id
    @SequenceGenerator(name = "movie_sequence", sequenceName = "movie_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(generator = "movie_sequence")

    private long id;
    private String title;
    private String genre;
    private int year;

    @Min(value = 1, message = "Review must be at least 1")
    @Max(value = 5, message = "Review must be at most 5")
    private int review;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }
}
