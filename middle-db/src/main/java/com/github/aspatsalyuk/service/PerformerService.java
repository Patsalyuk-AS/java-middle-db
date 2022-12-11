package com.github.aspatsalyuk.service;

import com.github.aspatsalyuk.rest.dto.PerformerDTO;

import java.util.List;

public interface PerformerService {

    List<PerformerDTO> getAllPerformers();

    PerformerDTO getPerformerById(Long id);

    PerformerDTO updatePerformer(Long id, PerformerDTO performerDTO);
}
