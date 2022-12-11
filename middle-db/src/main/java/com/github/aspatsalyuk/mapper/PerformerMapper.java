package com.github.aspatsalyuk.mapper;

import com.github.aspatsalyuk.domain.entity.Performer;
import com.github.aspatsalyuk.rest.dto.PerformerDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface PerformerMapper {

    PerformerDTO toDTO(Performer performer);

    List<PerformerDTO> toDTOList(List<Performer> performerList);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "name", target = "name")
    void updateFromDTO(PerformerDTO performerDTO, @MappingTarget Performer performer);
}
