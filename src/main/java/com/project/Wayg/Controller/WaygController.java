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
                                                     @PageableDefault(size=12, direction = Sort.Direction.DESC) Pageable pageable){
        Page<School> search= waygService.searchSchool(keyword, pageable);
        return ResponseEntity.ok(search);
    }

}
