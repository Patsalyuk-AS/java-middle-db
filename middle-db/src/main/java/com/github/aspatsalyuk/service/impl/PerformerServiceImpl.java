package com.github.aspatsalyuk.service.impl;

import com.github.aspatsalyuk.domain.entity.Performer;
import com.github.aspatsalyuk.domain.repository.PerformerRepository;
import com.github.aspatsalyuk.exception.MiddleDBException;
import com.github.aspatsalyuk.mapper.PerformerMapper;
import com.github.aspatsalyuk.rest.dto.PerformerDTO;
import com.github.aspatsalyuk.service.PerformerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.github.aspatsalyuk.dictionary.ErrorDescription.TRACK_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PerformerServiceImpl implements PerformerService {

    private final PerformerRepository performerRepository;
    private final PerformerMapper performerMapper;

    @Override
    public List<PerformerDTO> getAllPerformers() {
        return performerMapper.toDTOList(performerRepository.findAll());
    }

    @Override
    public PerformerDTO getPerformerById(Long id) {
        return performerMapper.toDTO(performerRepository.getById(id));
    }

    @Override
    public PerformerDTO updatePerformer(Long id, PerformerDTO performerDTO) {
        Performer performer = performerRepository.findById(id).orElseThrow(
                () -> new MiddleDBException(TRACK_NOT_FOUND.getStatusCode(), TRACK_NOT_FOUND.getErrorCode(), TRACK_NOT_FOUND.getDescription())
        );
        performerMapper.updateFromDTO(performerDTO, performer);
        return performerMapper.toDTO(performerRepository.save(performer));
    }
}
