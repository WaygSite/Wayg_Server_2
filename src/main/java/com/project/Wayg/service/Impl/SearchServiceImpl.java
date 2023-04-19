package com.project.Wayg.service.Impl;

import com.project.Wayg.entity.School;
import com.project.Wayg.entity.dto.RequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SearchServiceImpl {
    Page<School> schoolInfo(Pageable pageable, RequestDTO keyword);
}
