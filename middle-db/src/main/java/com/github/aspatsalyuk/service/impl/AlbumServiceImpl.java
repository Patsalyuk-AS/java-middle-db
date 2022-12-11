package com.github.aspatsalyuk.service.impl;

import com.github.aspatsalyuk.domain.repository.AlbumRepository;
import com.github.aspatsalyuk.mapper.AlbumMapper;
import com.github.aspatsalyuk.rest.dto.AlbumDTO;
import com.github.aspatsalyuk.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public List<AlbumDTO> getAllAlbums() {
        return albumMapper.toDTOList(albumRepository.findAll());
    }

    @Override
    public AlbumDTO getAlbumById(Long id) {
        return albumMapper.toDTO(albumRepository.getById(id));
    }
}
