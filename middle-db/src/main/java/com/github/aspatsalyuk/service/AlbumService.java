package com.github.aspatsalyuk.service;

import com.github.aspatsalyuk.rest.dto.AlbumDTO;

import java.util.List;

public interface AlbumService {

    List<AlbumDTO> getAllAlbums();

    AlbumDTO getAlbumById(Long id);
}
