package com.mff.belajar_consume_apipublik.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mff.belajar_consume_apipublik.model.movie.MoviesSearchResponse;
import com.mff.belajar_consume_apipublik.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

@RestController
public class MoviesController {
    @Autowired
    private MovieService movieService;

    @GetMapping(
            "/api/search"
    )
    public MoviesSearchResponse searchMovies(@RequestParam String title){
        return movieService.searchMovies(title);
    }

    @PostMapping(
            "/api/search"
    )
    public ResponseEntity<String> saveMovies(@RequestParam String title){

        MoviesSearchResponse result = movieService.searchMovies(title);

        if (result == null || result.getSearch() == null || result.getSearch().isEmpty()) {
            return ResponseEntity.ok("Tidak ada data yang ditemukan atau hasil pencarian kosong.");
        } else {
            movieService.saveMovies(result.getSearch());
        }


        // Simpan hasil pencarian dalam file JSON
        try (FileWriter fileWriter = new FileWriter("data_movies/hasil_pencarian"+UUID.randomUUID()+".json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(fileWriter, result.getSearch());
            return ResponseEntity.ok("Data berhasil disimpan dalam file JSON.");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.ok("Gagal menyimpan data dalam file JSON.");
        }

    }

}
