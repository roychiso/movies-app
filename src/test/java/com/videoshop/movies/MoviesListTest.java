package com.videoshop.movies;

import com.videoshop.movies.MovieList.Movie;
import com.videoshop.movies.MovieList.MoviesList;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * Created by steve on 10/16/14.
 */
public class MoviesListTest {

    MoviesList movieList;

    @Before
    public void setUp() throws Exception{
        movieList = new MoviesListTest();
    }

    @Test
    public void emptyListSize() throws Exception{

        MoviesList movieList = new MoviesList();
        assertThat(movieList.size(), is(0));
    }

    @Test
    public void sizeAfterAddingOneMovie() throws Exception{
        Movie startWars = new Movie("StartWars");
        movieList.add("StarWars");
        assertThat(movieList.size(), is(1));
    }
}
