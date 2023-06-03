package com.project.Wayg.info.repository;

import com.project.Wayg.info.domain.school.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaygRepository extends JpaRepository<School, Integer> {
    School findById(int id);
}
