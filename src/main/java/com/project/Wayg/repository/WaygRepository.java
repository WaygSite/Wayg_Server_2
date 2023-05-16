package com.project.Wayg.repository;

import com.project.Wayg.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaygRepository extends JpaRepository<School, Integer> {

}
