package com.keyin.rest.api;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.keyin.rest.api.Movie;
import com.keyin.rest.api.MovieAPIService;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MovieAPIServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieAPIService movieAPIService;

    @Test
    public void testFindByAllContainingTitleSearch() {

        // --- Arrange ---

        // Create a new Movie object
        Movie movie1 = new Movie();
        // Set the title of the movie to "The Godfather"
        movie1.setTitle("The Godfather");
        movie1.setGenre("Horror|Comedy");
        movie1.setReview(1);
        // Save the movie to the test entity manager
        entityManager.persist(movie1);

        // Create another new Movie object
        Movie movie2 = new Movie();
        // Set the title of the movie to "The Shawshank Redemption"
        movie2.setTitle("The Shawshank Redemption");
        movie2.setGenre("Satire|Comedy");
        movie2.setReview(1);
        // Save the movie to the test entity manager
        entityManager.persist(movie2);

        // Create another new Movie object
        Movie movie3 = new Movie();
        // Set the title of the movie to "The Shawshank Redemption"
        movie3.setTitle("A Star Is Born");
        movie3.setGenre("Drama");
        movie3.setReview(5);
        // Save the movie to the test entity manager
        entityManager.persist(movie3);

        // Flush the changes to the test entity manager to the database
        entityManager.flush();

        // --- Act ---

        // Call the findByAllContaining method of the MovieAPIService with the search term as the argument
        List<Movie> movies = movieAPIService.findByAllContaining("The");

        // --- Assert ---

        System.out.println("\n# of Records Found:");
        assertEquals(2, movies.size());
        System.out.println("""     
                \t    Expected: \t2
                \t    Actual:   \t""" + movies.size() + "\n");

        System.out.println("Is Record Found?:");
        assertTrue(movies.contains(movie1));
        System.out.println("""
                \tMovie 1:
                \t    Expected: \ttrue
                \t    Actual:   \t""" + movies.contains(movie1));
        assertTrue(movies.contains(movie2));
        System.out.println("""
                \tMovie 2:
                \t    Expected: \ttrue
                \t    Actual:   \t""" + movies.contains(movie2));
        assertFalse(movies.contains(movie3));
        System.out.println("""
                \tMovie 3:
                \t    Expected: \tfalse
                \t    Actual:   \t""" + movies.contains(movie3) + "\n");

        System.out.println("\"Title\" Field Value:");
        assertEquals("The Godfather", movies.get(0).getTitle());
        System.out.println("""
                \tMovie 1:
                \t    Expected: \tThe Godfather
                \t    Actual:   \t""" + movies.get(0).getTitle());
        assertEquals("The Shawshank Redemption", movies.get(1).getTitle());
        System.out.println("""
                \tMovie 2:
                \t    Expected: \tThe Shawshank Redemption
                \t    Actual:   \t""" + movies.get(1).getTitle() + "\n");
    }

    @Test
    public void testFindByAllContainingGenreSearch() {

        // --- Arrange ---

        Movie movie1 = new Movie();

        movie1.setTitle("The Godfather");
        movie1.setGenre("Horror|Comedy");
        movie1.setReview(1);
        entityManager.persist(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("The Shawshank Redemption");
        movie2.setGenre("Satire|Comedy");
        movie2.setReview(1);
        entityManager.persist(movie2);

        Movie movie3 = new Movie();
        movie3.setTitle("A Star Is Born");
        movie3.setGenre("Drama");
        movie3.setReview(5);
        entityManager.persist(movie3);

        entityManager.flush();

        // --- Act ---

        List<Movie> movies = movieAPIService.findByAllContaining("Comedy");

        // --- Assert ---

        System.out.println("\n# of Records Found:");
        System.out.println("""
                \t    Expected: \t2
                \t    Actual:   \t""" + movies.size() + "\n");

        System.out.println("Is Record Found?:");
        assertTrue(movies.contains(movie1));
        System.out.println("""
                \tMovie 1:
                \t    Expected: \ttrue
                \t    Actual:   \t""" + movies.contains(movie1));
        assertTrue(movies.contains(movie2));
        System.out.println("""
                \tMovie 2:
                \t    Expected: \ttrue
                \t    Actual:   \t""" + movies.contains(movie2));
        assertFalse(movies.contains(movie3));
        System.out.println("""
                \tMovie 3:
                \t    Expected: \tfalse
                \t    Actual:   \t""" + movies.contains(movie3) + "\n");

        System.out.println("\"Genre\" Field Value:");
        assertEquals("Horror|Comedy", movies.get(0).getGenre());
        System.out.println("""
                \tMovie 1:
                \t    Expected: \tHorror|Comedy
                \t    Actual:   \t""" + movies.get(0).getGenre());
        assertEquals("Satire|Comedy", movies.get(1).getGenre());
        System.out.println("""
                \tMovie 2:
                \t    Expected: \tSatire|Comedy
                \t    Actual:   \t""" + movies.get(1).getGenre() + "\n");
    }

    @Test
    public void testFindByAllContainingReviewSearch() {

        // --- Arrange ---

        Movie movie1 = new Movie();
        movie1.setTitle("The Godfather");
        movie1.setGenre("Horror|Comedy");
        movie1.setReview(1);
        entityManager.persist(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("The Shawshank Redemption");
        movie2.setGenre("Satire|Comedy");
        movie2.setReview(1);
        entityManager.persist(movie2);

        Movie movie3 = new Movie();
        movie3.setTitle("A Star Is Born");
        movie3.setGenre("Drama");
        movie3.setReview(5);
        entityManager.persist(movie3);

        entityManager.flush();

        // --- Act ---

        List<Movie> movies = movieAPIService.findByAllContaining("1");

        // --- Assert ---

        System.out.println("\n# of Records Found:");
        assertEquals(2, movies.size());
        System.out.println("""     
                \t    Expected: \t2
                \t    Actual:   \t""" + movies.size() + "\n");

        System.out.println("Is Record Found?:");
        assertTrue(movies.contains(movie1));
        System.out.println("""
                \tMovie 1:
                \t    Expected: \ttrue
                \t    Actual:   \t""" + movies.contains(movie1));
        assertTrue(movies.contains(movie2));
        System.out.println("""
                \tMovie 2:
                \t    Expected: \ttrue
                \t    Actual:   \t""" + movies.contains(movie2));
        assertFalse(movies.contains(movie3));
        System.out.println("""
                \tMovie 3:
                \t    Expected: \tfalse
                \t    Actual:   \t""" + movies.contains(movie3) + "\n");

        System.out.println("\"Review\" Field Value:");
        assertEquals(1, movies.get(0).getReview());
        System.out.println("""
                \tMovie 1:
                \t    Expected: \t1
                \t    Actual:   \t""" + movies.get(0).getReview());
        assertEquals(1, movies.get(1).getReview());
        System.out.println("""
                \tMovie 2:
                \t    Expected: \t1
                \t    Actual:   \t""" + movies.get(1).getReview() + "\n");
    }

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
        System.out.println("\nMovie 1's Title:");
        System.out.println("\tExpected: \tThe Godfather");
        System.out.println("\tActual: \t" + movies.get(0).getTitle());

        // Assert that the second movie's title is "The Shawshank Redemption"
        assertEquals("The Shawshank Redemption", movies.get(1).getTitle());
        System.out.println("Movie 1's Title:");
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

        // Assert that the first movie's genre is "Horror|Comedy"
        assertEquals("Horror|Comedy", movies.get(0).getGenre());
        System.out.println("\nMovie 1's Genre:");
        System.out.println("\tExpected: \tHorror|Comedy");
        System.out.println("\tActual: \t" + movies.get(0).getGenre());

        // Assert that the second movie's genre is "Satire|Comedy"
        assertEquals("Satire|Comedy", movies.get(1).getGenre());
        System.out.println("Movie 2:");
        System.out.println("\tExpected: \tSatire|Comedy");
        System.out.println("\tActual: \t" + movies.get(1).getGenre() + "\n");
    }

    @Test
    public void testFindByTitle() {
        // --- Arrange ---

        // Create a new Movie object
        Movie movie1 = new Movie();
        // Set the title of the movie to "The Godfather"
        movie1.setTitle("The Godfather");
        // Save the movie to the test entity manager
        entityManager.persist(movie1);


        // Flush the changes to the test entity manager to the database
        entityManager.flush();

        // --- Act ---

        // Call the findByTitleContaining method of the MovieAPIService with parameter "The"
        List<Movie> movies = movieAPIService.findByTitle("The Godfather");

        // --- Assert ---

        // Assert that the returned list has size of 2
        assertEquals(1, movies.size());

        // Assert that the first movie's title is "The Godfather"
        assertEquals("The Godfather", movies.get(0).getTitle());
        System.out.println("\nMovie 1's Title:");
        System.out.println("\tExpected: \tThe Godfather");
        System.out.println("\tActual: \t" + movies.get(0).getTitle());
    }

    @Test
    public void testFindByGenre() {
        // Create a new Movie object
        Movie movie1 = new Movie();
        // Set the Genre of the movie to "Horror|Comedy"
        movie1.setGenre("Horror|Comedy");
        // Save the movie to the test entity manager
        entityManager.persist(movie1);


        // Flush the changes to the test entity manager to the database
        entityManager.flush();

        // --- Act ---

        // Call the findByGenreContaining method of the MovieAPIService with parameter "The"
        List<Movie> movies = movieAPIService.findByGenre("Horror|Comedy");

        // --- Assert ---

        // Assert that the returned list has size of 2
        assertEquals(1, movies.size());

        // Assert that the first movie's genre is "Horror|Comedy"
        assertEquals("Horror|Comedy", movies.get(0).getGenre());
        System.out.println("\nMovie 1's Genre:");
        System.out.println("\tExpected: \tHorror|Comedy");
        System.out.println("\tActual: \t" + movies.get(0).getGenre());

    }


    // to test the findByReview method
    @Test
    public void testFindByReview() {
        // --- Arrange ---

        // Create a new Movie object
        Movie movie1 = new Movie();
        // Set the title of the movie to "The Godfather"
        movie1.setReview(1);
        // Save the movie to the test entity manager
        entityManager.persist(movie1);

        // Flush the changes to the test entity manager to the database
        entityManager.flush();

        // --- Act ---

        // Call the findByReview method of the MovieAPIService with parameter 5
        List<Movie> movies = movieAPIService.findByReview(1);

        // --- Assert ---

        // Assert that the returned list has size of 2
        assertEquals(1, movies.size());

        // Assert that the first movie's title is "The Godfather"
        assertEquals(1, movies.get(0).getReview());
        System.out.println("\nMovie 1 Review:");
        System.out.println("\tExpected: \t1");
        System.out.println("\tActual: \t" + movies.get(0).getReview());

    }


}