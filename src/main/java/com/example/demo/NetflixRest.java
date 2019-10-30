package com.example.demo;

import com.example.demo.Model.Category;
import com.example.demo.Model.Movie;
import com.example.demo.Model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NetflixRest implements CommandLineRunner {
    private  final FeignRestClient feignRestClient;

    public NetflixRest(FeignRestClient feignRestClient) {
        this.feignRestClient = feignRestClient;
    }

    @Override
    public void run(String... args) throws Exception {

        User user = feignRestClient.registerUser(new User(99L,"Jim"));
        System.err.println(user.toString());

        List<Category> category = feignRestClient.getAllCategories();
        System.err.println(category);
        for (Category c:category) {
            System.err.println("Category: "+c.toString()+"\n");
        }

        Movie movie = feignRestClient.suggestMovie(user.getIdentificationNumber(),new Movie(category,"Recent movie"));
        System.out.println(movie.toString()+"\n");

        List<Movie> allTypeMovies = feignRestClient.getMoviesByCategoryIdAndType(1L,"Suggested");
        System.err.println(allTypeMovies.toString()+"\n");

        List<Movie> myMovies = feignRestClient.getMyMoviesByCategoryId(1l,user.getIdentificationNumber());
        System.err.println(myMovies.toString()+"\n");
//
//        Movie updatedMovie = feignRestClient.updateMovie(movie.getmId(),user.getIdentificationNumber(),new Movie(category,"Not the grinch"));
//        System.out.println(updatedMovie.toString());
//
//        List<Movie> myUpdatedMovies = feignRestClient.getMoviesByCategoryIdAndType(1L,"Suggested");
//        System.err.println(myUpdatedMovies.toString());
//
//        Void deletedMovie = feignRestClient.deleteMovie(movie.getmId(),user.getIdentificationNumber());
//        System.out.println(deletedMovie.toString());
//
//        List<Movie> myMoviesNow = feignRestClient.getMoviesByCategoryIdAndType(1L,"Suggested");
//        System.err.println(myMoviesNow.toString());

    }


}






