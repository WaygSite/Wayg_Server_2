package com.project.Wayg.controller;
import com.project.Wayg.controller.dto.request.CategoryRequest;
import com.project.Wayg.controller.dto.request.KeywordRequest;
import com.project.Wayg.domain.School;
import com.project.Wayg.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping("/wayg")
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;
    @RequestMapping(value="/school/category", method=RequestMethod.GET)
    public ResponseEntity<Page<School>> categoryType(@RequestParam(defaultValue = "1") int page,
                                                     @RequestParam(defaultValue = "0") KeywordRequest keyword,
                                                     CategoryRequest category){

        Page<School> locationSchool = categoryService.categoryType(category, page, keyword);
        return ResponseEntity.ok(locationSchool);
    }
}
