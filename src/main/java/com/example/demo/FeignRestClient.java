package com.example.demo;

import com.example.demo.Model.Category;
import com.example.demo.Model.Movie;
import com.example.demo.Model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "client", url = "http://localhost:9090",configuration=ClientConfig.class)
public interface FeignRestClient {

    @RequestMapping(method = RequestMethod.GET, value = "categories")
    List<Category> getAllCategories();

    @RequestMapping(method = RequestMethod.POST,value = "register")
    User registerUser(@RequestBody User user);

    @RequestMapping(method = RequestMethod.POST,value = "movies")
    Movie suggestMovie(@RequestParam(value = "identificationNumber") Long identificationNumber, @RequestBody Movie movie);

    @RequestMapping(method = RequestMethod.PATCH,value = "movies/{movie_id}")
    Movie updateMovie(@PathVariable(value = "movie_id") Long movie_id,@RequestParam(value = "user_id") Long user_id,@RequestBody Movie movie);

    @RequestMapping(method = RequestMethod.DELETE,value = "movies/{movie_id}")
    Void deleteMovie(@PathVariable(value = "movie_id") Long movie_id, @RequestParam(value = "user_id") Long user_id);

    @RequestMapping(method = RequestMethod.GET,value = "movies/{category_id}")
    List<Movie> getMoviesByCategoryIdAndType(@PathVariable(value = "category_id") Long category_id, @RequestParam(value="type") String type);

    @RequestMapping(method = RequestMethod.GET,value = "mymovies/{category_id}")
    List<Movie> getMyMoviesByCategoryId(@PathVariable(value = "category_id") Long category_id,@RequestParam(value = "identificationNumber") Long identificationNumber);

}
