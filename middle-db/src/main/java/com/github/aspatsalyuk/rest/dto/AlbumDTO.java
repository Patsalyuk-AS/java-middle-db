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
public class AlbumDTO {

    @NotNull
    private Long id;

   @NotNull
    private String name;
}
