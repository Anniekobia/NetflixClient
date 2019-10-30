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

        User user = feignRestClient.registerUser(new User(509L,"Annie"));
        System.err.println(user.toString());

        List<Category> category = feignRestClient.getAllCategories();
        System.err.println(category);
        for (Category c:category) {
            System.err.println("Category: "+c.toString()+"\n");
        }

        Movie movie = feignRestClient.suggestMovie(user.getIdentificationNumber(),new Movie(category,"My movie"));
        System.out.println(movie.toString()+"\n");

        List<Movie> allTypeMovies = feignRestClient.getMoviesByCategoryIdAndType(1L,"Suggested");
        System.err.println(allTypeMovies.toString()+"\n");

        List<Movie> myMovies = feignRestClient.getMyMoviesByCategoryId(1l,user.getIdentificationNumber());
        System.err.println(myMovies.toString()+"\n");

        Movie updatedMovie = feignRestClient.updateMovie(movie.getId(),user.getIdentificationNumber(),new Movie(category,"Our movie"));
        System.out.println(updatedMovie.toString()+"\n");

        List<Movie> allTypeMoviesafter = feignRestClient.getMoviesByCategoryIdAndType(1L,"Suggested");
        System.err.println(allTypeMoviesafter.toString()+"\n");

        List<Movie> myMoviesafter = feignRestClient.getMyMoviesByCategoryId(1l,user.getIdentificationNumber());
        System.err.println(myMoviesafter.toString()+"\n");

        Void deletedMovie = feignRestClient.deleteMovie(movie.getId(),user.getIdentificationNumber());
//        System.out.println(deletedMovie.toString()+"\n");

        List<Movie> myMoviesNow = feignRestClient.getMoviesByCategoryIdAndType(1L,"Suggested");
        System.err.println(myMoviesNow.toString()+"\n");

        List<Movie> myMoviesafterd = feignRestClient.getMyMoviesByCategoryId(1l,user.getIdentificationNumber());
        System.err.println(myMoviesafterd.toString()+"\n");

    }


}






