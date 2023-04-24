package com.project.Wayg.controller;
import com.project.Wayg.entity.School;
import com.project.Wayg.entity.dto.RequestDTO;
import com.project.Wayg.service.CategoryService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/wayg")
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;
    @RequestMapping(value="/school/category", method=RequestMethod.GET)
    public ResponseEntity<Page<School>> categoryType(Map<String, Object> category,
                                                     @ApiParam(value = "Page number")
                                                     @RequestParam(defaultValue = "1") int page,
                                                     @RequestParam(defaultValue = "0") RequestDTO keyword){
        Pageable pageable = PageRequest.of(page-1, 12);
        Page<School> locationSchool = categoryService.categoryType(category, pageable, keyword);
        return ResponseEntity.ok(locationSchool);
    }
}
