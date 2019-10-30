
package com.example.demo.Model;

import java.util.List;
import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Movie {

    private List<Category> mCategories;
    private Long id;
    private String mTitle;
    private String mType;

    public Movie(List<Category> mCategories, String mTitle) {
        this.mCategories = mCategories;
        this.mTitle = mTitle;
    }

    private Movie(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mCategories=" + mCategories +
                ", mId=" + id +
                ", mTitle='" + mTitle + '\'' +
                ", mType='" + mType + '\'' +
                '}';
    }
}
