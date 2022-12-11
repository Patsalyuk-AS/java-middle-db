package com.github.aspatsalyuk.mapper;

import com.github.aspatsalyuk.domain.entity.Genre;
import com.github.aspatsalyuk.rest.dto.GenreDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GenreMapper {

    GenreDTO toDTO(Genre genre);

    List<GenreDTO> toDTOList(List<Genre> genreList);
}
