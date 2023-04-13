package com.project.Wayg.service;

import com.project.Wayg.Entity.QSchool;
import com.project.Wayg.Entity.School;
import com.project.Wayg.Entity.dto.RequestDTO;
import com.project.Wayg.repository.WaygRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
@AllArgsConstructor
public class WaygService {
    private JPAQueryFactory jpaQueryFactory;
    private final WaygRepository waygRepository;
    public Page<School> schoolInfo(Pageable pageable) {
        Page<School> schools = waygRepository.findAll(pageable);
        return schools;
    }

    public Page<School> searchSchool(RequestDTO keyword, Pageable pageable){
        QSchool school = QSchool.school;
        QueryResults search = jpaQueryFactory.selectFrom(school)
                                .where(school.school_name.contains(keyword.getKeyword()))
                                .offset(pageable.getOffset())   // (2) 페이지 번호
                                .limit(pageable.getPageSize())
                                .fetchResults();

        return new PageImpl<>(search.getResults());
    }


    public Page<School> locationSchool(String location, Pageable pageable) {
        QSchool school = QSchool.school;
        QueryResults loca =jpaQueryFactory.selectFrom(school)
                .where(school.address.contains(location))
                .offset(pageable.getOffset())   // (2) 페이지 번호
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(loca.getResults());
    }
}
