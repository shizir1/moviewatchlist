package com.yahoofinance.io;

import com.yahoofinance.model.Movie;
import com.yahoofinance.model.MovieSearchResult;
import com.yahoofinance.repository.MovieRepository;
import com.yahoofinance.requestHandler.RequestHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class IOHandler {

    private MovieRepository movieRepository;
    private RequestHandler requestHandler;

    public IOHandler(MovieRepository movieRepository, RequestHandler requestHandler){
        this.movieRepository = movieRepository;
        this.requestHandler = requestHandler;
    }

    public void showMenu(){

        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("What do you want to do?");
            System.out.println("1- Add a movie to my watchlist");
            System.out.println("2- Print my watchlist");
            System.out.println("3- Exit");

            try{
                int choice = in.nextInt();
                System.out.println(choice);
                if(choice == 1)
                    addMenu();
                if(choice == 2)
                    print();
                if(choice == 3)
                    break;
            }
            catch (Exception e){
                System.err.println(e.toString());
            }
        }

    }

    public void addMenu(){
        System.out.println("\n1- Search for a movie");
        System.out.println("2- Feeling lucky");
        Scanner in = new Scanner(System.in);
        //in.nextLine();

        try{
            int choice = in.nextInt();
            in.nextLine();
            System.out.println("Enter the name of the movie:");
            String movieName = in.nextLine();

            if(choice == 1){
                movieRepository.insert(chooseMovie(movieName));
            }
            else if(choice == 2){
                movieRepository.insert(requestHandler.getMovie(movieName));
            }
        }
        catch (Exception e){
            System.err.println(e.toString());
        }

    }

    // Handle array index out of bounds exception!!!!
    public Movie chooseMovie(String searchStr){

        Scanner in = new Scanner(System.in);
        System.out.println("Please make a selection:");

        List<MovieSearchResult> movieList = requestHandler.searchMovie(searchStr);
        for(int i  = 0; i < movieList.size(); i++){
            System.out.println(i+1 + "- " + movieList.get(i));
        }

        int choice = in.nextInt();

        return requestHandler.getMovieById(movieList.get(choice-1).getImdbId());
    }

    public void print(){
        System.out.println("\nYour watchlist:");
        System.out.println("-------------------------------");
        for (Movie movie : movieRepository.findAll()) {
            System.out.println(movie);
        }
        System.out.println();    }



}
