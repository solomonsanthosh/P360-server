package com.p360server.server.repository;

import com.p360server.server.model.Roadmap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoadmapRepository extends JpaRepository<Roadmap, Long> {
}
