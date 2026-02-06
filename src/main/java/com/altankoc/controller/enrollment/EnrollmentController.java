package com.altankoc.controller.enrollment;

import com.altankoc.dto.request.EnrollmentRequestDTO;
import com.altankoc.dto.response.EnrollmentResponseDTO;
import com.altankoc.entity.Course;
import com.altankoc.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EnrollmentController {

    ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollments();

    ResponseEntity<EnrollmentResponseDTO> findEnrollmentById(Long id);

    ResponseEntity<EnrollmentResponseDTO> createEnrollment(EnrollmentRequestDTO dto, Student student, Course course);

    ResponseEntity<Void> deleteEnrollment(Long id);

}
