package com.as201_ms_career.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Institute {
    @Id private Long id;
    private String name;
    private String ruc;
    private boolean active;
}
