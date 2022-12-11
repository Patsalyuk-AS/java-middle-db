package com.github.aspatsalyuk.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateTrackDTO {

    @NotNull
    private String name;

    private Integer year;

    private String length;

    private Integer numberOfPlays;

    private Long genreId;

    private Long albumId;

    private Long performerId;
}
