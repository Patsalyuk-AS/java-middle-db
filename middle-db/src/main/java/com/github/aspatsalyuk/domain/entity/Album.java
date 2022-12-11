package com.github.aspatsalyuk.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ALBUMS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "NAME")
    private String name;
}
