package com.project.Wayg.Controller;

import com.project.Wayg.Entity.School;
import com.project.Wayg.Entity.dto.RequestDTO;
import com.project.Wayg.Service.WaygService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/wayg")
public class WaygController {
    private final WaygService waygService;

    @GetMapping("/school/info")
    public ResponseEntity<Page<School>> schoolInfo(@PageableDefault(size=12, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<School> school = waygService.schoolInfo(pageable);
        return ResponseEntity.ok(school);
    }


    @RequestMapping(value="/school/search", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<Page<School>> searchSchool(@RequestParam RequestDTO keyword,
                                                     @RequestParam(defaultValue = "0") String location,
                                                     @PageableDefault(size=12, direction = Sort.Direction.DESC) Pageable pageable){
        Page<School> search= waygService.searchSchool(keyword, location, pageable);
        return ResponseEntity.ok(search);
    }

    @RequestMapping(value="/school/location", method={RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Page<School>> locationSchool(@RequestParam String category,
                                                     @PageableDefault(size=12, direction = Sort.Direction.DESC) Pageable pageable){
        Page<School> categoryType = waygService.locationSchool(category, pageable);
        return ResponseEntity.ok(categoryType);
    }

}
