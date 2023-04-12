package com.keyin.rest.api;

import org.owasp.encoder.Encode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public interface MovieAPIService extends JpaRepository<Movie, Long> {

    /* Partial Match (All Fields) */
    @Query("SELECT m FROM Movie m WHERE " +
            "LOWER(m.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(m.genre) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
//            "LOWER(m.year) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(m.review) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    public List<Movie> findByAllContaining(@Param("searchTerm") String searchTerm);

    /* Partial Match */
    public List<Movie> findByTitleContaining(@Param("title")String title);
    public List<Movie> findByGenreContaining(@Param("genre")String genre);
//    public List<Movie> findByYearContaining(@Param("year")int year);
    public List<Movie> findByReviewContaining(@Param("review")int review);

    /* Full Match */
    public List<Movie> findByTitle(@Param("title") String title);
    public List<Movie> findByGenre(@Param("genre")String genre);
//    public List<Movie> findByYear(@Param("year")int year);
    public List<Movie> findByReview(@Param("review")int review);

}
