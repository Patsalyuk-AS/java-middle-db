package com.github.aspatsalyuk.service.impl;

import com.github.aspatsalyuk.domain.repository.GenreRepository;
import com.github.aspatsalyuk.mapper.GenreMapper;
import com.github.aspatsalyuk.rest.dto.GenreDTO;
import com.github.aspatsalyuk.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDTO> getAllGenres() {
        return genreMapper.toDTOList(genreRepository.findAll());
    }
}
