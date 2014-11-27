package com.videoshop.movies;


import java.util.*;

public class MoviesList {

    private Map<UUID, Movie> movies;

    public MoviesList(){
        this.movies = new HashMap<>();
    }

    public void addOrUpdate(Movie movie){
        if(null == movie.getId()){
            UUID id = UUID.randomUUID();
            movie.setId(id);
        }
        movies.put(movie.getId(), movie);
    }

    public int size(){
        return movies.size();
    }

    public boolean contains(Movie movie){
        return movies.containsKey(movie.getId());
    }

    public List<Movie> list(){
        List<Movie> movieList = new ArrayList<>(this.movies.values());
        Collections.sort(movieList);
        return movieList;
    }

    public Movie findById(UUID id){
        return (this.movies.containsKey(id) ? this.movies.get(id) : new Movie());
    }

}