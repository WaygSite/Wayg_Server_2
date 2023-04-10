package com.project.Wayg.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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
    private String address;
    private String call_num;
    private String site;

}
