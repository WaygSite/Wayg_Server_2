package com.project.Wayg.service;

import com.project.Wayg.entity.QSchool;
import com.project.Wayg.entity.School;
import com.project.Wayg.entity.dto.RequestDTO;
import com.project.Wayg.repository.WaygRepository;
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
public class CategoryService{
    private JPAQueryFactory jpaQueryFactory;
    private WaygRepository waygRepository;

    public Page<School> categoryType(Map<String, Object> category, Pageable pageable, RequestDTO keyword) {
        if(category.isEmpty() && !keyword.getKeyword().isEmpty()){
            QSchool school = QSchool.school;
            QueryResults infoSearch = jpaQueryFactory.selectFrom(school)
                    .where(school.school_name.contains(keyword.getKeyword()))
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetchResults();

            return new PageImpl<>(infoSearch.getResults());
        }if(!category.isEmpty() && keyword.getKeyword().isEmpty()){
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

            QueryResults cate =jpaQueryFactory.selectFrom(school).where(builder)
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetchResults();

            return new PageImpl<>(cate.getResults());
        }else{
            Page<School> schools = waygRepository.findAll(pageable);
            return schools;
        }
    }
}
