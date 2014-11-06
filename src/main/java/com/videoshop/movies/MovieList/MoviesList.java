package com.videoshop.movies.MovieList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 10/16/14.
 */
public class MoviesList {

        List<String> collection;

        public void MovieList(){
            this.collection = new ArrayList<String>();
        }

        public int size(){
            return this.collection.size();
        }

        public void add(String movieName){
            this.collection.add(movieName);
        }
    }

