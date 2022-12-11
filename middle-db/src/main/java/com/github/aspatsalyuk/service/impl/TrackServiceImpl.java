package com.github.aspatsalyuk.service.impl;

import com.github.aspatsalyuk.domain.entity.Track;
import com.github.aspatsalyuk.domain.repository.AlbumRepository;
import com.github.aspatsalyuk.domain.repository.GenreRepository;
import com.github.aspatsalyuk.domain.repository.PerformerRepository;
import com.github.aspatsalyuk.domain.repository.TrackRepository;
import com.github.aspatsalyuk.exception.MiddleDBException;
import com.github.aspatsalyuk.mapper.TrackMapper;
import com.github.aspatsalyuk.rest.dto.TrackDTO;
import com.github.aspatsalyuk.rest.dto.UpdateTrackDTO;
import com.github.aspatsalyuk.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.github.aspatsalyuk.dictionary.ErrorDescription.TRACK_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TrackServiceImpl implements TrackService {

    private final TrackRepository trackRepository;
    private final PerformerRepository performerRepository;
    private final AlbumRepository albumRepository;
    private final GenreRepository genreRepository;
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

    @Override
    public TrackDTO insertTrack(UpdateTrackDTO updateTrackDTO) {
        Track track = trackMapper.fromUpdateTrackDTO(updateTrackDTO);
        fillTrackByGenreAlbumPerformer(updateTrackDTO, track);
        return trackMapper.toDTO(trackRepository.save(track));
    }

    @Override
    @Transactional
    public TrackDTO updateTrack(Long id, UpdateTrackDTO updateTrackDTO) {
        Track track = trackRepository.findTrackByIdForUpdate(id).orElseThrow(
                () -> new MiddleDBException(TRACK_NOT_FOUND.getStatusCode(), TRACK_NOT_FOUND.getErrorCode(), TRACK_NOT_FOUND.getDescription())
        );
        trackMapper.updateTrackFromUpdateTrackDTO(updateTrackDTO, track);
        fillTrackByGenreAlbumPerformer(updateTrackDTO, track);
        return trackMapper.toDTO(trackRepository.save(track));
    }

    private void fillTrackByGenreAlbumPerformer(UpdateTrackDTO updateTrackDTO, Track track) {
        if (updateTrackDTO.getPerformerId() != null) {
            track.setPerformer(performerRepository.getById(updateTrackDTO.getPerformerId()));
        }
        if (updateTrackDTO.getAlbumId() != null) {
            track.setAlbum(albumRepository.getById(updateTrackDTO.getAlbumId()));
        }
        if (updateTrackDTO.getGenreId() != null) {
            track.setGenre(genreRepository.getById(updateTrackDTO.getGenreId()));
        }
    }
}
