package com.project.Wayg.Controller;

import com.project.Wayg.Entity.School;
import com.project.Wayg.Entity.dto.RequestDTO;
import com.project.Wayg.service.SearchService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/wayg")
public class SearchController{
    @Autowired
    private final SearchService waygService;

    @RequestMapping(value="/school/info", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<Page<School>> schoolInfo(@ApiParam(value = "Page number")
                                                        @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page-1, 12);
        Page<School> school = waygService.schoolInfo(pageable);
        return ResponseEntity.ok(school);
    }


    @RequestMapping(value="/school/search", method = {RequestMethod.GET})
    public ResponseEntity<List<School>> searchSchool(@RequestParam RequestDTO keyword){
        List<School> search= waygService.searchSchool(keyword);
        return ResponseEntity.ok(search);
    }


}
