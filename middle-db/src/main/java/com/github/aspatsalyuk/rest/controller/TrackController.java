package com.github.aspatsalyuk.rest.controller;

import com.github.aspatsalyuk.rest.dto.TrackDTO;
import com.github.aspatsalyuk.service.TrackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(TrackController.TRACK_URL)
public class TrackController {

    protected static final String TRACK_URL = "tracks";
    protected static final String ID = "id";
    protected static final String ID_URL = "/{id}";

    private final TrackService trackService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<TrackDTO>> getAllTracks() {
        return ResponseEntity.ok(trackService.getAllTracks());
    }

    @GetMapping(
            value = ID_URL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<TrackDTO> getTrackById(@PathVariable(ID) @NotNull Long id) {
        return ResponseEntity.ok(trackService.getTrackById(id));
    }

    @DeleteMapping(
            value = ID_URL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Void> deleteTrackById(@PathVariable(ID) @NotNull Long id) {
        trackService.deleteTrackById(id);
        return ResponseEntity.ok().build();
    }
}
