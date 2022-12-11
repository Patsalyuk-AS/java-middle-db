package com.github.aspatsalyuk.rest.controller;

import com.github.aspatsalyuk.rest.dto.PerformerDTO;
import com.github.aspatsalyuk.service.PerformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(PerformerController.PERFORMER_URL)
public class PerformerController {

    protected static final String PERFORMER_URL = "performers";
    protected static final String ID = "id";
    protected static final String ID_URL = "/{id}";

    private final PerformerService performerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<PerformerDTO>> getAllPerformers() {
        return ResponseEntity.ok(performerService.getAllPerformers());
    }

    @GetMapping(
            value = ID_URL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<PerformerDTO> getPerformerById(@PathVariable(ID) @NotNull Long id) {
        return ResponseEntity.ok(performerService.getPerformerById(id));
    }

    @PutMapping(
            value = ID_URL,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<PerformerDTO> updatePerformer(@PathVariable(ID) @NotNull Long id, @NotNull @RequestBody PerformerDTO performerDTO) {
        return ResponseEntity.ok(performerService.updatePerformer(id, performerDTO));
    }
}
