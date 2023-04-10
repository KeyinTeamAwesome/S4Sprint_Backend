package com.keyin.rest.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
// DT ADDED April 10, 2023 - @Transactional
@Transactional
public interface MovieAPIService extends JpaRepository<Movie, Long> {

    // DT added April 10, 2023 public List<Movie> findAll();
    public List<Movie> findAll();

    public List<Movie> findByTitle(@Param("title") String title);
    public List<Movie> findByGenre(@Param("genre")String genre);
    public List<Movie> findByYear(@Param("year")int year);
    public List<Movie> findByReview(@Param("review")int review);


    public List<Movie> findByTitleContaining(@Param("title")String title);
    public List<Movie> findByGenreContaining(@Param("genre")String genre);
    public List<Movie> findByYearContaining(@Param("year")int year);
    public List<Movie> findByReviewContaining(@Param("review")int review);

}
