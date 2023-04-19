package com.project.Wayg.repository;

import com.project.Wayg.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface WaygRepository extends JpaRepository<School, Integer> {

}
