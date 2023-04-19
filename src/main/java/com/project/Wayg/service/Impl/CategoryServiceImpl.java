package com.project.Wayg.service.Impl;

import com.project.Wayg.entity.School;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface CategoryServiceImpl{
    Page<School> categoryType(Map<String, Object> category, Pageable pageable);
}
