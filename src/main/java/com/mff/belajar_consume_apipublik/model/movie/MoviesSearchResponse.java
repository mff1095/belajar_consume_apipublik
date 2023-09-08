package com.mff.belajar_consume_apipublik.model.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesSearchResponse {

    @JsonProperty("Search")
    private List<Search> search;

    private Integer totalResults;

    @JsonProperty("Response")
    private String response;

}
