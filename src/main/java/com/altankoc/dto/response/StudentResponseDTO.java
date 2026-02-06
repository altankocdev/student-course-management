package com.altankoc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

    private Long id;
    private String name;
    private List<String> courseNames;

}
