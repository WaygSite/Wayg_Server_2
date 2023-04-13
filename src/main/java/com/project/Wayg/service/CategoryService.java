package com.project.Wayg.service;

import com.project.Wayg.Entity.QSchool;
import com.project.Wayg.Entity.School;
import com.project.Wayg.service.Impl.CategoryServiceImpl;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@AllArgsConstructor
public class CategoryService implements CategoryServiceImpl {
    private JPAQueryFactory jpaQueryFactory;

    public Page<School> categoryType(Map<String, Object> category, Pageable pageable) {
        String institution = category.get("institution").toString();
        String schoolType = category.get("schoolType").toString();
        String manOrWoman= category.get("manOrWoman").toString();
        String location = category.get("location").toString();

        QSchool school = QSchool.school;
        BooleanBuilder builder = new BooleanBuilder();

         new BooleanBuilder();
        if (!"전체".equals(institution)) {
            builder.and(school.institution.eq(institution));
        }
        if (!"전체".equals(schoolType)) {
            builder.and(school.school_type.eq(schoolType));
        }
        if (!"전체".equals(manOrWoman)) {
            builder.and(school.gender.eq(manOrWoman));
        }
        if (!"전체".equals(location)) {
            builder.and(school.address.contains(location));
        }


        QueryResults cate =jpaQueryFactory.selectFrom(school)
                .where(builder)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(cate.getResults());
    }

    public Page<School> locationSchool(String location, Pageable pageable) {
        QSchool school = QSchool.school;
        QueryResults loca =jpaQueryFactory.selectFrom(school)
                .where()
                .offset(pageable.getOffset())   // (2) 페이지 번호
                .limit(pageable.getPageSize())
                .fetchResults();

        return new PageImpl<>(loca.getResults());
    }


}
