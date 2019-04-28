package com.yahoofinance.repository;

import com.yahoofinance.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

public interface MovieRepository extends MongoRepository<Movie, String> {

    public Movie findByTitle(String title);



}
