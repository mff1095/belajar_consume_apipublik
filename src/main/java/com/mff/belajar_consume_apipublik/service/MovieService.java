package com.mff.belajar_consume_apipublik.service;

import com.mff.belajar_consume_apipublik.model.movie.MoviesSearchResponse;
import com.mff.belajar_consume_apipublik.model.movie.SaveMovies;
import com.mff.belajar_consume_apipublik.model.movie.Search;

import java.util.List;

public interface MovieService {

    MoviesSearchResponse searchMovies(String title);

    void saveMovies(List<Search> request);

}
