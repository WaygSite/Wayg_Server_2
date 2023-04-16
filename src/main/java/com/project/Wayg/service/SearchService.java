package com.project.Wayg.service;

import com.project.Wayg.Entity.QSchool;
import com.project.Wayg.Entity.School;
import com.project.Wayg.Entity.dto.RequestDTO;

import com.project.Wayg.service.Impl.SearchServiceImpl;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.project.Wayg.repository.WaygRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SearchService implements SearchServiceImpl {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    private WaygRepository waygRepository;
    public Page<School> schoolInfo(Pageable pageable) {
        Page<School> schools = waygRepository.findAll(pageable);
        return schools;
    }

    public List<School> searchSchool(RequestDTO keyword){
        QSchool school = QSchool.school;
        List<School> search =  jpaQueryFactory.selectFrom(school)
                                .where(school.school_name.contains(keyword.getKeyword())).fetch();
        return search;
    }
}
