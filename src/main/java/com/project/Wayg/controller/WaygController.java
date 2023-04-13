package com.project.Wayg.controller;

import com.project.Wayg.Entity.School;
import com.project.Wayg.Entity.dto.RequestDTO;
import com.project.Wayg.service.WaygService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/wayg")
public class WaygController {
    private final WaygService waygService;

    @GetMapping("/school/info")
    @ApiOperation(value = "Get Info")
    public ResponseEntity<Page<School>> schoolInfo(@ApiParam(value = "Page number")
                                                    @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page-1,12);
        Page<School> school = waygService.schoolInfo(pageable);
        return ResponseEntity.ok(school);
    }


    @RequestMapping(value="/school/search", method = {RequestMethod.POST, RequestMethod.GET})
    public ResponseEntity<Page<School>> searchSchool(@RequestParam RequestDTO keyword,
                                                     @ApiParam(value = "Page number")
                                                     @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page-1, 12);
        Page<School> search= waygService.searchSchool(keyword, pageable);
        return ResponseEntity.ok(search);
    }

    @RequestMapping(value="/school/location", method={RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Page<School>> locationSchool(@RequestParam String location,
                                                       @ApiParam(value = "Page number")
                                                       @RequestParam(defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page-1, 12);
        Page<School> locationSchool = waygService.locationSchool(location, pageable);
        return ResponseEntity.ok(locationSchool);

    }

}
