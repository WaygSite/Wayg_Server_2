package com.project.Wayg.service.Impl;

import com.project.Wayg.Entity.School;
import com.project.Wayg.Entity.dto.RequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchServiceImpl {
    List<School> searchSchool(RequestDTO keyword);
    Page<School> schoolInfo(Pageable pageable);
}
