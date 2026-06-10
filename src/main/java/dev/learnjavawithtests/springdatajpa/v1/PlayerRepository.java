package dev.learnjavawithtests.springdatajpa.v1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
    boolean existsByName(String name);

    List<PlayerEntity> findAllByOrderByWinsDescNameAsc();
}

