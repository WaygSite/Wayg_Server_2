package com.project.Wayg.controller;

import com.project.Wayg.entity.School;
import com.project.Wayg.entity.dto.*;
import com.project.Wayg.service.SearchService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/wayg")
public class SearchController{
    private final SearchService waygService;

    @RequestMapping(value="/school/info", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<Page<School>> schoolInfo(@ApiParam(value = "Page number")
                                                        @RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "0") RequestDTO keyword){
        Pageable pageable = PageRequest.of(page-1, 12);
        Page<School> school = waygService.schoolInfo(pageable, keyword);
        return ResponseEntity.ok(school);
    }
}
