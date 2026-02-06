package com.altankoc.service.student;

import com.altankoc.dto.request.StudentRequestDTO;
import com.altankoc.dto.response.StudentResponseDTO;

import java.util.List;

public interface StudentService {

    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO getStudentById(Long id);

    StudentResponseDTO createStudent(StudentRequestDTO requestDTO);

    void deleteStudent(Long id);


}
