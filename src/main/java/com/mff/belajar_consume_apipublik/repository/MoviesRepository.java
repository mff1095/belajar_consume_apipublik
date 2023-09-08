package com.mff.belajar_consume_apipublik.repository;

import com.mff.belajar_consume_apipublik.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies , Integer> {



}
