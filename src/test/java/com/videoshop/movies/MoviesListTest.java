package com.videoshop.movies;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class MoviesListTest {

    MoviesList movieList;

    @Before
    public void setUp() throws Exception{
        movieList = new MoviesList();
    }

    @Test
    public void emptyListSize() throws Exception{
        assertThat(movieList.size(), is(0));
    }

    @Test
    public void sizeAfterAddingOneMovie() throws Exception{
        Movie starWars = new Movie("Star Wars");
        movieList.addOrUpdate(starWars);
        assertThat(movieList.size(), is(1));
    }

    @Test
    public void sizeAfterAddingTwoMovies() throws Exception{
        Movie starWars = new Movie("Star Wars");
        Movie titanic = new Movie("Titanic");
        movieList.addOrUpdate(starWars);
        movieList.addOrUpdate(titanic);
        assertThat(movieList.size(), is(2));
    }

    @Test
    public void containsMovie() throws Exception{
        Movie starWars = new Movie("Star Wars");
        Movie titanic = new Movie("Titanic");
        Movie cars = new Movie("Cars");
        movieList.addOrUpdate(starWars);
        movieList.addOrUpdate(titanic);
        assertThat(movieList.contains(starWars), is(true));
        assertThat(movieList.contains(titanic), is(true));
        assertThat(movieList.contains(cars), is(false));
    }

    @Test
    public void movieList() throws Exception{
        Movie starWars = new Movie("Star Wars");
        Movie titanic = new Movie("Titanic");
        movieList.addOrUpdate(starWars);
        movieList.addOrUpdate(titanic);
        List<Movie> theList = movieList.list();
        assertThat(theList.get(0).getTitle(), is("Star Wars"));
        assertThat(theList.get(1).getTitle(), is("Titanic"));
    }

    @Test
    public void findById() throws Exception{
        Movie starWars = new Movie("Star Wars");
        movieList.addOrUpdate(starWars);
        Movie found = movieList.findById(starWars.getId());

        assertThat(found, is(not(nullValue())));
        assertThat(found.getId(), is(starWars.getId()));
    }

    @Test
    public void findByIdNotFound() throws Exception{
        Movie notFound = movieList.findById(UUID.randomUUID());
        assertThat(notFound, is(not(nullValue())));
        assertThat(notFound.getId(), is(nullValue()));
        assertThat(notFound.getTitle(), is(nullValue()));
    }
}