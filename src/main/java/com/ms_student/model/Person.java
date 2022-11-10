package com.ms_student.model;

import org.springframework.data.annotation.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id private Long id;
    private String id_type;
    private String id_number;
    private String name;
    private String lastname;
    private String cellphone;
    private String email;
    private Integer level;
    private String username;
    private String password;
    private boolean active;

}
