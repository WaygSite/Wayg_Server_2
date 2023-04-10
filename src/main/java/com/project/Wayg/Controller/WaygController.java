package com.project.Wayg.Controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Wayg.Entity.School;
import com.project.Wayg.Service.WaygService;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/wayg")
public class WaygController {
    private final WaygService waygService;

    @GetMapping("/school/info")
    public ResponseEntity<List<School>> schoolInfo() {
        List<School> school = waygService.schoolInfo();
        return ResponseEntity.ok(school);
    }

    @GetMapping("/school/search")
    public ResponseEntity<List<School>> searchSchool(@RequestParam String keyword){
        List<School> search= waygService.searchSchool(keyword);
        return ResponseEntity.ok(search);
    }

}
