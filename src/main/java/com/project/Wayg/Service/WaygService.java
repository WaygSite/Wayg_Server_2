package com.project.Wayg.Service;

import com.project.Wayg.Entity.QSchool;
import com.project.Wayg.Entity.School;
import com.project.Wayg.Repository.WaygRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class WaygService {
    private final JPAQueryFactory queryFactory;
    private final WaygRepository waygRepository;
    public List<School> schoolInfo() {
        List<School> schools = (List<School>) waygRepository.findAll();
        return schools;
    }


}
