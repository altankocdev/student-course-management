package com.altankoc.controller.student;

import com.altankoc.dto.request.StudentRequestDTO;
import com.altankoc.dto.response.StudentResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentController {

    ResponseEntity<List<StudentResponseDTO>> getAllStudents();

    ResponseEntity<StudentResponseDTO> getStudentById(Long id);

    ResponseEntity<StudentResponseDTO> createStudent(StudentRequestDTO requestDTO);

    ResponseEntity<Void> deleteStudent(Long id);
}
