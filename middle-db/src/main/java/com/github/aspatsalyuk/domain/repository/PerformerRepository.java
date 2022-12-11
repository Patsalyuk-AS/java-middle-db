package com.github.aspatsalyuk.domain.repository;

import com.github.aspatsalyuk.domain.entity.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformerRepository extends JpaRepository<Performer, Long> {
}
