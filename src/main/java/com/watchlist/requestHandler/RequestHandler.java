package com.watchlist.requestHandler;

import com.watchlist.model.Movie;
import com.watchlist.model.MovieSearchResult;
import com.watchlist.model.SearchResult;
import com.watchlist.practice.PracticeApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestHandler {

    private static final Logger log = LoggerFactory.getLogger(PracticeApplication.class);

    @Value("${url}")
    private String url;

    @Value("${apikey}")
    private String apiKey;

    private RestTemplate restTemplate;

    public RequestHandler(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<MovieSearchResult> searchMovie(String movieName){
        List<Movie> movieList = new ArrayList<Movie>();
        SearchResult searchResult = null;
        String requestUrl = url + "?s=" + movieName + "&apikey=" + apiKey;

        System.out.println(requestUrl);

        try{
            searchResult = restTemplate.getForObject(requestUrl, SearchResult.class);
            if(searchResult != null){
                return searchResult.getMsrList();
            }
        }
        catch (RestClientException e){
            log.error(e.toString());
        }

        return null;

    }


    public Movie getMovie(String movieName){
        String requestUrl = url + "?t=" + movieName + "&apikey=" + apiKey;

        Movie movie = null;
        try{
            movie = restTemplate.getForObject(requestUrl, Movie.class);
            //log.info(movie.toString());
        }
        catch (RestClientException e){
            log.error(e.toString());
        }
        catch(Exception e){
            log.error(e.toString());
        }

        return movie;
    }

    public Movie getMovieById(String imdbId){
        String requestUrl = url + "?i=" + imdbId + "&apikey=" + apiKey;

        Movie movie = null;
        try{
            movie = restTemplate.getForObject(requestUrl, Movie.class);
            //log.info(movie.toString());
        }
        catch (RestClientException e){
            log.error(e.toString());
        }
        catch(Exception e){
            log.error(e.toString());
        }

        return movie;

    }

}
