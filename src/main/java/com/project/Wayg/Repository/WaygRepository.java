package com.project.Wayg.Repository;

import com.project.Wayg.Entity.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaygRepository extends CrudRepository<School, Integer> {
}
