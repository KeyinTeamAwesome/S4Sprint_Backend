package com.keyin.rest.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
public interface MovieAPIService extends JpaRepository<Movie, Long> {
    public List<Movie> findByTitle(@Param("title")String title);
    public List<Movie> findByGenre(@Param("genre")String genre);
    public List<Movie> findByYear(@Param("year")int year);

}
