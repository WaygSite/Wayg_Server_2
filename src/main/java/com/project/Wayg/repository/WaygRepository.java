package com.project.Wayg.repository;

import com.project.Wayg.Entity.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaygRepository extends JpaRepository<School, Integer> {
    Page<School> findAll(Pageable pageable);
}
