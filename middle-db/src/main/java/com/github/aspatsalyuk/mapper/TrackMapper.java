package com.github.aspatsalyuk.mapper;

import com.github.aspatsalyuk.domain.entity.Track;
import com.github.aspatsalyuk.rest.dto.TrackDTO;
import com.github.aspatsalyuk.rest.dto.UpdateTrackDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper
public interface TrackMapper {

    @Mapping(source = "genre.name", target = "genre")
    @Mapping(source = "album.name", target = "album")
    @Mapping(source = "performer.name", target = "performer")
    TrackDTO toDTO(Track track);

    List<TrackDTO> toDTOList(List<Track> trackList);

    Track fromUpdateTrackDTO(UpdateTrackDTO updateTrackDTO);

    @BeanMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
    void updateTrackFromUpdateTrackDTO(UpdateTrackDTO updateTrackDTO, @MappingTarget Track updatedTrack);
}
