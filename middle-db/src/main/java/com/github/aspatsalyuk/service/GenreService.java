package com.github.aspatsalyuk.service;

import com.github.aspatsalyuk.rest.dto.GenreDTO;

import java.util.List;

public interface GenreService {

    List<GenreDTO> getAllGenres();
}
