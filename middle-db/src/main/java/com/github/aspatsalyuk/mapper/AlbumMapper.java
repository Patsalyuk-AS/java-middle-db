package com.github.aspatsalyuk.mapper;

import com.github.aspatsalyuk.domain.entity.Album;
import com.github.aspatsalyuk.rest.dto.AlbumDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AlbumMapper {

    AlbumDTO toDTO(Album album);

    List<AlbumDTO> toDTOList(List<Album> albumList);
}
