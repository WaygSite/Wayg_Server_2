package com.project.Wayg.service;

import com.project.Wayg.controller.dto.request.CategoryRequest;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Map;

@Service
@AllArgsConstructor
public class CategoryService {
    private JPAQueryFactory jpaQueryFactory;
    private WaygRepository waygRepository;

    public Page<School> categoryType(CategoryRequest category, int page, RequestDTO keyword) {
        Pageable pageable = PageRequest.of(page-1, 12);
        QSchool school = QSchool.school;
        BooleanBuilder builder = new BooleanBuilder();
        if(category.isNull() && keyword.getKeyword().equals("0") && pageable.isPaged()) {
            System.out.println("모두 검색되야함" + category.isNull());
            System.out.println("모두 검색되야함" + keyword.getKeyword().equals("0"));
            System.out.println("모두 검색되야함" + pageable.isPaged());
            // 검색어와 카테고리가 모두 입력되지 않았을 때 모든 컬럼 출력
            Page<School> schools = waygRepository.findAll(pageable);
            return schools;
        }else if(!category.isNull() && keyword.getKeyword().equals("0")){
            System.out.println("카테고리 검색되야함"+ !category.isNull());
            System.out.println("카테고리 검색되야함"+keyword.getKeyword().equals("0"));
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
            Page<School> schools = waygRepository.findAll(pageable);
            return schools;
        }

    }
}
