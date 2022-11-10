package com.ms_student.model;

import org.springframework.data.annotation.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Career {

    @Id private Long id;
    private String name;
    private String boss;
    private String area;
    private Integer institute_id;
    private double pension;
    private Integer quantity_course;
    private Integer quantity_semester;
    private boolean active;

}
