package com.github.aspatsalyuk.service.impl;

import com.github.aspatsalyuk.domain.repository.TrackRepository;
import com.github.aspatsalyuk.mapper.TrackMapper;
import com.github.aspatsalyuk.rest.dto.TrackDTO;
import com.github.aspatsalyuk.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final TrackMapper trackMapper;

    @Override
    public List<TrackDTO> getAllTracks() {
        return trackMapper.toDTOList(trackRepository.findAll());
    }

    @Override
    public TrackDTO getTrackById(Long id) {
        return trackMapper.toDTO(trackRepository.getById(id));
    }

    @Override
    public void deleteTrackById(Long id) {
        trackRepository.deleteById(id);
    }
}
