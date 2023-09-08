package com.mff.belajar_consume_apipublik.model.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveMovies {

    @NotBlank
    @JsonProperty("Title")
    private String title;

    @NotBlank
    @JsonProperty("Year")
    private String year;

    @NotBlank
    @JsonProperty
    private String imdbID;

    @NotBlank
    @JsonProperty("Type")
    private String type;

    @NotBlank
    @JsonProperty("Poster")
    private String poster;

}
