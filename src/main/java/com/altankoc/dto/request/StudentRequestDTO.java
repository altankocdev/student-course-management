package com.altankoc.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

    @NotBlank(message = "İsim boş olamaz!")
    @Size(min = 2, max = 50, message = "İsim 2-50 karakter arası olmalı!")
    private String name;

}
