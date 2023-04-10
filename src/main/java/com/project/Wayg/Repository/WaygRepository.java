package com.project.Wayg.Repository;

import com.project.Wayg.Entity.School;
import com.project.Wayg.config.QuerydslConfiguration;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaygRepository extends CrudRepository<School, Integer> {
}
