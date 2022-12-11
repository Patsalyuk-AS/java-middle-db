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
public class TrackDTO {

    @NotNull
    private String name;

    private Integer year;

    private String length;

    private String genre;

    private String album;

    private String performer;
}
