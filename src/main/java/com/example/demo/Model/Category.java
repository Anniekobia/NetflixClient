
package com.example.demo.Model;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Category {

    private Long id;

    private Set<Movie> movies = new HashSet<>();

    private String name;

    private  Category(){

    }

    public Category( String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "mId=" + id +
                ", movies=" + movies +
                ", mName='" + name + '\'' +
                '}';
    }
}
