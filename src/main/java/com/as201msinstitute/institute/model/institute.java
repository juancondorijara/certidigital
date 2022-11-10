package com.as201msinstitute.institute.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "institute")
public class institute {

    @Id private Long id;
    @Column private String name;
    @Column private String ruc;
    @Column private String area;
    @Column private boolean active;

}
