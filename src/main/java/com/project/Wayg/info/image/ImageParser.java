package com.project.Wayg.info.image;

import com.project.Wayg.info.domain.school.School;
import com.project.Wayg.info.repository.WaygRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.IOException;

public class ImageParser {
    private ResourceLoader resourceLoader;
    private WaygRepository waygRepository;

    public ImageParser(ResourceLoader resourceLoader, WaygRepository schoolRepository) {
        this.resourceLoader = resourceLoader;
        this.waygRepository = schoolRepository;
    }

    public void parseImageFileNamesAndSaveUrl() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:/static/image");
        File imageDirectory = resource.getFile();
        File[] imageFiles = imageDirectory.listFiles();

        for (File imageFile : imageFiles) {
            if (imageFile.isFile()) {
                String fileName = imageFile.getName();
                String idStr = fileName.substring(0, fileName.lastIndexOf('.'));
                int id = Integer.parseInt(idStr);

                School school = waygRepository.findById(id);
                if (school != null) {
                    String imageUrl = "/image/" + fileName; // 이미지 파일의 URL 생성
                    school.setImageUrl(imageUrl);
                    waygRepository.save(school);
                }
            }
        }
    }
}