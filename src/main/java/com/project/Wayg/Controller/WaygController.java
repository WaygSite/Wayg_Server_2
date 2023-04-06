package com.project.Wayg.Controller;

import com.project.Wayg.Entity.School;
import com.project.Wayg.Service.WaygService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/wayg")
public class WaygController {
    private final WaygService waygService;

    @GetMapping("/school/info")
    public ResponseEntity<List<School>> schoolInfo(){
        List<School> school = waygService.schoolInfo();
        return ResponseEntity.status(HttpStatus.OK).body(school);
    }
}
