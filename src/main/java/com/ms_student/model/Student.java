package com.ms_student.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

    @Id private Long id;
    @Column private Long person_id;
    @Column private Long career_id;
    @Column private String institutional_email;
    @Column private String pay_method;
    @Column private String admission_date;
    @Column private String guardian_name;
    @Column private String home_phone;
    @Column private String status;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String person_name;
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String career_name;

}