package com.project.Wayg.Service;

import com.project.Wayg.Entity.QSchool;
import com.project.Wayg.Entity.School;
import com.project.Wayg.Repository.WaygRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@AllArgsConstructor
public class WaygService {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    private final WaygRepository waygRepository;
    public List<School> schoolInfo() {
        List<School> schools = (List<School>) waygRepository.findAll();
        return schools;
    }

    public List<School> searchSchool(String keyword){
        QSchool school = QSchool.school;
        List<School> search = (List<School>) jpaQueryFactory.selectFrom(school).where(school.school_name.contains(keyword)).fetch();
        return search;
//                .stream().filter(s -> s.getSchool_name().equals(keyword));
    }



}
