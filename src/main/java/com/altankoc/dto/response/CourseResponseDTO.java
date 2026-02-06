package com.altankoc.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseResponseDTO {

    private Long id;
    private String courseName;
    private Integer credits;
    private List<String> studentNames;
    private Integer enrolledStudentCount;
}
