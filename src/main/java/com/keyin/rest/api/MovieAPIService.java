package com.keyin.rest.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public interface MovieAPIService extends JpaRepository<Movie, Long> {

    /* ----- Partial Match (All Fields) ----- */

    /* The @Query annotation enables us to create custom prepared statements for our
    queries, and mitigate security risks by sanitizing user input and preventing SQL
    injection attacks. */
    @Query("SELECT m FROM Movie m WHERE " +
            "LOWER(m.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(m.genre) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(m.review) LIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    /* The @Param annotation binds the method parameter to the query parameter. */
    public List<Movie> findByAllContaining(@Param("searchTerm") String searchTerm);


    /* ----- Partial Match ----- */

    @Query("SELECT m FROM #{#entityName} m WHERE m.title LIKE %:title%")
    public List<Movie> findByTitleContaining(@Param("title") String title);

    @Query("SELECT m FROM #{#entityName} m WHERE m.genre LIKE %:genre%")
    public List<Movie> findByGenreContaining(@Param("genre") String genre);

    /* ❗ A partial match method for "Review" is not necessary due to the nature of
    matching a single digit integer. */


    /* ----- Full Match ----- */
    @Query("SELECT m FROM #{#entityName} m WHERE m.title LIKE CONCAT('%', :title, '%')")
    public List<Movie> findByTitle(@Param("title") String title);

    @Query("SELECT m FROM #{#entityName} m WHERE m.genre LIKE CONCAT('%', :genre, '%')")
    public List<Movie> findByGenre(@Param("genre") String genre);

    @Query("SELECT m FROM #{#entityName} m WHERE m.review = :review")
    public List<Movie> findByReview(@Param("review") int review);

}

