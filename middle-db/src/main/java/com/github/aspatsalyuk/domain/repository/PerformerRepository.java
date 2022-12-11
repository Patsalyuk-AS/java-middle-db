package com.github.aspatsalyuk.domain.repository;

import com.github.aspatsalyuk.domain.entity.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface PerformerRepository extends JpaRepository<Performer, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "select p from Performer p " +
            "where p.id = :id")
    Optional<Performer> findPerformerByIdForUpdate(@Param("id") Long id);
}
