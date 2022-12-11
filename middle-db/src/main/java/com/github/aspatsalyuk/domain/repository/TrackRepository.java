package com.github.aspatsalyuk.domain.repository;

import com.github.aspatsalyuk.domain.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

}
