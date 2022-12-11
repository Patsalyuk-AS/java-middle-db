package com.github.aspatsalyuk.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TRACKS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "LENGTH")
    private String length;

    @Column(name = "NUMBER_OF_PLAYS")
    private Integer numberOfPlays;

    @ManyToOne
    @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID")
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "ALBUM_ID", referencedColumnName = "ID")
    private Album album;

    @ManyToOne
    @JoinColumn(name = "PERFORMER_ID", referencedColumnName = "ID")
    private Performer performer;
}
