package com.altankoc.service.enrollment;

import com.altankoc.dto.request.EnrollmentRequestDTO;
import com.altankoc.dto.response.EnrollmentResponseDTO;
import com.altankoc.entity.Course;
import com.altankoc.entity.Student;

import java.util.List;

public interface EnrollmentService {

    List<EnrollmentResponseDTO> getAllEnrollments();

    EnrollmentResponseDTO getEnrollmentById(Long id);

    EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO dto, Student student, Course course);

    void deleteEnrollment(Long id);

}
