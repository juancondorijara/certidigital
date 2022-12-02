package com.as201_ms_career.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "career")
public class Career {
    @Id private Long id;
    @Column private String name;
    @Column private String boss;
    @Column private String area;
    @Column private Integer institute_id;
    @Column private double pension;
    @Column private Integer quantity_course;
    @Column private Integer quantity_semester;
    @Column private boolean active;
}