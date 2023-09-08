package com.mff.belajar_consume_apipublik.service;

import com.mff.belajar_consume_apipublik.entity.Movies;
import com.mff.belajar_consume_apipublik.model.movie.MoviesSearchResponse;
import com.mff.belajar_consume_apipublik.model.movie.SaveMovies;
import com.mff.belajar_consume_apipublik.model.movie.Search;
import com.mff.belajar_consume_apipublik.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MoviesRepository moviesRepository;
    @Override
    public MoviesSearchResponse searchMovies(String title) {

        String apiUrl = "http://www.omdbapi.com/?apikey=2d8d4885&s="+title;

        ResponseEntity<MoviesSearchResponse> response = restTemplate.getForEntity(apiUrl , MoviesSearchResponse.class);

        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to fetch entity from the API");
        }
    }

    @Override
    public void saveMovies(List<Search> request) {

        List<Movies> moviesList = new ArrayList<>();

      if(request != null) {
          for(Search saveMovies : request){
              Movies movies = new Movies();
              movies.setTitle(saveMovies.getTitle());
              movies.setImdbID(saveMovies.getImdbID());
              movies.setYear(saveMovies.getYear());
              movies.setType(saveMovies.getType());
              movies.setPoster(saveMovies.getPoster());

              moviesList.add(movies);
          }
      } else {
          throw new RuntimeException("gagal menyimpan data karna data null");
      }

        moviesRepository.saveAll(moviesList);

    }
}
