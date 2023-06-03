package com.project.Wayg.info.service;

import com.project.Wayg.info.domain.school.QSchool;
import com.project.Wayg.info.controller.dto.request.CategoryRequest;
import com.project.Wayg.info.controller.dto.request.KeywordRequest;
import com.project.Wayg.info.domain.school.School;
import com.project.Wayg.info.repository.WaygRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private JPAQueryFactory jpaQueryFactory;
    private WaygRepository waygRepository;

    public Page<School> categoryType(CategoryRequest category, int page, KeywordRequest keyword) {
        //페이지 처리
        Pageable pageable = PageRequest.of(page-1, 12);
        QSchool school = QSchool.school;
        BooleanBuilder builder = new BooleanBuilder();
        if(category.isNull() && keyword.getKeyword().equals("0") && pageable.isPaged()) {
            // 검색어와 카테고리가 모두 입력되지 않았을 때 모든 컬럼 출력
            Page<School> schools = waygRepository.findAll(pageable);
            return schools;
        }else if(!category.isNull() && keyword.getKeyword().equals("0")){
            // 카테고리만 입력했을 때
            String institution = category.getInstitution();
            String schoolType = category.getSchoolType();
            String manOrWoman = category.getManOrWoman();
            String location = category.getLocation();

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

            QueryResults searchCategory = jpaQueryFactory.selectFrom(school)
                    .where(builder)
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetchResults();

            return new PageImpl<>(searchCategory.getResults());

        }else if(!keyword.getKeyword().equals("0")){
            // 키워드에 해당하는 검색 수행
            QueryResults infoSearch = jpaQueryFactory.selectFrom(school)
                    .where(school.school_name.contains(keyword.getKeyword()))
                    .offset(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .fetchResults();

            return new PageImpl<>(infoSearch.getResults());
        }else{
            // 페이지만 입력하였을 때
            Page<School> schools = waygRepository.findAll(pageable);
            return schools;
        }

    }
}
