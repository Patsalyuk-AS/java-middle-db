package com.github.aspatsalyuk.rest.controller;

import com.github.aspatsalyuk.rest.dto.AlbumDTO;
import com.github.aspatsalyuk.service.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AlbumController.ALBUM_URL)
public class AlbumController {

    protected static final String ALBUM_URL = "albums";
    protected static final String ID = "id";
    protected static final String ID_URL = "/{id}";

    private final AlbumService albumService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<AlbumDTO>> getAllTracks() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }

    @GetMapping(
            value = ID_URL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<AlbumDTO> getTrackById(@PathVariable(ID) @NotNull Long id) {
        return ResponseEntity.ok(albumService.getAlbumById(id));
    }
}
