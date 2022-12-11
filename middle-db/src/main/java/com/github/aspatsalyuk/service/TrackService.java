package com.github.aspatsalyuk.service;

import com.github.aspatsalyuk.rest.dto.TrackDTO;

import java.util.List;

public interface TrackService {

    List<TrackDTO> getAllTracks();

    TrackDTO getTrackById(Long id);

    void deleteTrackById(Long id);
}
