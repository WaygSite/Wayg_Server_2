package com.project.Wayg.Controller;

import com.project.Wayg.Entity.School;
import com.project.Wayg.Service.WaygService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/wayg")
public class WaygController {
    private final WaygService waygService;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET})
    @GetMapping("/school/info")
    public List<School> schoolInfo() {
        List<School> school = waygService.schoolInfo();
        return school;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("success");
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/hello")
    public String helloTest(){
        return "HELLO";
    }
}
