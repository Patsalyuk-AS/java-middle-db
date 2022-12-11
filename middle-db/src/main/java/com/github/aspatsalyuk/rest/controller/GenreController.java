package com.github.aspatsalyuk.rest.controller;

import com.github.aspatsalyuk.rest.dto.GenreDTO;
import com.github.aspatsalyuk.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(GenreController.GENRE_URL)
public class GenreController {

    protected static final String GENRE_URL = "genres";
    protected static final String ID = "id";

    private final GenreService genreService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<GenreDTO>> getAllGenres() {
        return ResponseEntity.ok(genreService.getAllGenres());
    }
}
