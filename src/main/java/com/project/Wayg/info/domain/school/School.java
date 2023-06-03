package com.project.Wayg.info.domain.school;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String institution;
    private String gender;
    private String school_type;
    private String school_name;
    private String address;
    private Timestamp found_date;
    private String call_num;
    private String site;
    private String imageUrl;

}
