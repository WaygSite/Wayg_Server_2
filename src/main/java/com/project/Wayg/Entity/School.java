package com.project.Wayg.Entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="school_info")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String institution;
    private String gender;
    private String school_type;
    private String school_name;
    private String address;
    private LocalDate found_date;
    private String call_num;
    private String site;

}
