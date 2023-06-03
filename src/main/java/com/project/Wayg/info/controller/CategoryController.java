package com.project.Wayg.info.controller;
import com.project.Wayg.info.controller.dto.request.CategoryRequest;
import com.project.Wayg.info.controller.dto.request.KeywordRequest;
import com.project.Wayg.info.domain.school.School;
import com.project.Wayg.info.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
