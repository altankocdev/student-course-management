package com.altankoc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentResponseDTO {

    private Long enrollmentId;
    private Long studentId;
    private Long courseId;
    private String studentName;
    private String courseName;
    private LocalDate enrollmentDate;
}
