package com.project.Wayg.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="school")
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
