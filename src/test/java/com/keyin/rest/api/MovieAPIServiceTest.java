package com.keyin.rest.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.keyin.rest.api.Movie;
import com.keyin.rest.api.MovieAPIService;

@DataJpaTest
public class MovieAPIServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieAPIService movieAPIService;

    @Test
    public void testFindByTitleContaining() {
        // --- Arrange ---

        // Create a new Movie object
        Movie movie1 = new Movie();
        // Set the title of the movie to "The Godfather"
        movie1.setTitle("The Godfather");
        // Save the movie to the test entity manager
        entityManager.persist(movie1);

        // Create another new Movie object
        Movie movie2 = new Movie();
        // Set the title of the movie to "The Shawshank Redemption"
        movie2.setTitle("The Shawshank Redemption");
        // Save the movie to the test entity manager
        entityManager.persist(movie2);

        // Flush the changes to the test entity manager to the database
        entityManager.flush();

        // --- Act ---

        // Call the findByTitleContaining method of the MovieAPIService with parameter "The"
        List<Movie> movies = movieAPIService.findByTitleContaining("The");

        // --- Assert ---

        // Assert that the returned list has size of 2
        assertEquals(2, movies.size());

        // Assert that the first movie's title is "The Godfather"
        assertEquals("The Godfather", movies.get(0).getTitle());
        System.out.println("\nMovie 1:");
        System.out.println("\tExpected: \tThe Godfather");
        System.out.println("\tActual: \t" + movies.get(0).getTitle());

        // Assert that the second movie's title is "The Shawshank Redemption"
        assertEquals("The Shawshank Redemption", movies.get(1).getTitle());
        System.out.println("Movie 1:");
        System.out.println("\tExpected: \tThe Shawshank Redemption");
        System.out.println("\tActual: \t" + movies.get(1).getTitle() + "\n");
    }

    @Test
    public void testFindByGenreContaining() {
        // --- Arrange ---

        // Create a new Movie object
        Movie movie1 = new Movie();
        // Set the Genre of the movie to "The Godfather"
        movie1.setGenre("Horror|Comedy");
        // Save the movie to the test entity manager
        entityManager.persist(movie1);

        // Create another new Movie object
        Movie movie2 = new Movie();
        // Set the genre of the movie to "The Shawshank Redemption"
        movie2.setGenre("Satire|Comedy");
        // Save the movie to the test entity manager
        entityManager.persist(movie2);

        // Flush the changes to the test entity manager to the database
        entityManager.flush();

        // --- Act ---

        // Call the findByGenreContaining method of the MovieAPIService with parameter "The"
        List<Movie> movies = movieAPIService.findByGenreContaining("Comedy");

        // --- Assert ---

        // Assert that the returned list has size of 2
        assertEquals(2, movies.size());

        // Assert that the first movie's genre is "The Godfather"
        assertEquals("Horror|Comedy", movies.get(0).getGenre());
        System.out.println("\nMovie 1:");
        System.out.println("\tExpected: \tHorror|Comedy");
        System.out.println("\tActual: \t" + movies.get(0).getGenre());

        // Assert that the second movie's genre is "The Shawshank Redemption"
        assertEquals("Satire|Comedy", movies.get(1).getGenre());
        System.out.println("Movie 2:");
        System.out.println("\tExpected: \tSatire|Comedy");
        System.out.println("\tActual: \t" + movies.get(1).getGenre() + "\n");
    }
}