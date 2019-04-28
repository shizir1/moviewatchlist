package com.watchlist.repository;

import com.watchlist.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {

    public Movie findByTitle(String title);



}
