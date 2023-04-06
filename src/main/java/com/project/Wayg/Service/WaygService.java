package com.project.Wayg.Service;

import com.project.Wayg.Entity.School;
import com.project.Wayg.Repository.WaygRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WaygService {
    private final WaygRepository waygRepository;
    public List<School> schoolInfo() {
        List<School> schools = (List<School>) waygRepository.findAll();
        return schools;
    }
}
