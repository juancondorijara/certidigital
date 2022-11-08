package com.ms_person.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {

    @Id private Long id;
    @Column private String id_type;
    @Column private String id_number;
    @Column private String name;
    @Column private String lastname;
    @Column private String cellphone;
    @Column private String email;
    @Column private Integer level;
    @Column private String username;
    @Column private String password;
    @Column private boolean active;
}
