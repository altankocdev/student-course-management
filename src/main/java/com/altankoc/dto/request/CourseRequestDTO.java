package com.altankoc.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO {

    @NotBlank(message = "Ders adı boş olamaz!")
    @Size(min = 2, max = 100, message = "Ders adı 2-100 karakter arası olmalı!")
    private String courseName;

    @Min(value = 1, message = "Kredi en az 1 olmalı!")
    private Integer credits;
}
