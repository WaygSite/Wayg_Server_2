package com.project.Wayg.Service;

import com.project.Wayg.Entity.QSchool;
import com.project.Wayg.Entity.School;
import com.project.Wayg.Entity.dto.RequestDTO;
import com.project.Wayg.Repository.WaygRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@AllArgsConstructor
public class WaygService {
    @Autowired
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
        //.stream().filter(s -> s.getSchool_name().equals(keyword));
    }



}
