package com.project.Wayg.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    String institution;
    String manOrWoman;
    String schoolType;
    String location;

    public boolean isNull() {
        if(this.institution == null && this.manOrWoman == null && this.schoolType == null && this.location == null) {
            return true;
        } else {
            return false;
        }
    }
}
