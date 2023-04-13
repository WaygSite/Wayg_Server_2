package com.project.Wayg.service.Impl;

import com.project.Wayg.Entity.School;
import com.project.Wayg.Entity.dto.RequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SearchServiceImpl {
    Page<School> searchSchool(RequestDTO keyword, Pageable pageable);
    Page<School> schoolInfo(Pageable pageable);
}
