package com.niit.DAO;

import com.niit.model.Genres;

import java.util.List;


public interface GenresDAO {
    boolean addGenres(Genres genres);
    boolean deleteGenres(int gId);
    Genres getGenresById(int genreID);
    List<Genres> getAllGenres();
    void displayGenres(List<Genres> genresDisplay);
}
