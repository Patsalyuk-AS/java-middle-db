package com.github.aspatsalyuk.domain.repository;

import com.github.aspatsalyuk.domain.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface TrackRepository extends JpaRepository<Track, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "select tr from Track tr " +
            "where tr.id = :id")
    Optional<Track> findTrackByIdForUpdate(@Param("id") Long id);
}
