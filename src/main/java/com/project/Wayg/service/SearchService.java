package com.project.Wayg.service;

import com.project.Wayg.Entity.QSchool;
import com.project.Wayg.Entity.School;
import com.project.Wayg.Entity.dto.RequestDTO;

import com.project.Wayg.config.SwaggerConfiguration;
import com.project.Wayg.service.Impl.SearchServiceImpl;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.project.Wayg.repository.WaygRepository;

@Service
@AllArgsConstructor
public class SearchService implements SearchServiceImpl {
    private JPAQueryFactory jpaQueryFactory;
    private WaygRepository waygRepository;

    public Page<School> schoolInfo(Pageable pageable, RequestDTO keyword) {
        QSchool qSchool = QSchool.school;
        if (keyword.getKeyword().equals("0")) {
            Page<School> schools = waygRepository.findAll(pageable);
            return schools;
        }else{
            QueryResults infoSearch = jpaQueryFactory.selectFrom(qSchool)
                    .where(qSchool.school_name.contains(keyword.getKeyword()))
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetchResults();

            return new PageImpl<>(infoSearch.getResults());
        }
    }
}
