package com.altankoc.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentRequestDTO {

    @NotNull(message = "Öğrenci ID boş olamaz!")
    private Long studentId;

    @NotNull(message = "Ders ID boş olamaz!")
    private Long courseId;

    private LocalDate enrollmentDate;
}
