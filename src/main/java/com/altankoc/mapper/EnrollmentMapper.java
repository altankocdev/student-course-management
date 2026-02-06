package com.altankoc.mapper;

import com.altankoc.dto.request.EnrollmentRequestDTO;
import com.altankoc.dto.response.EnrollmentResponseDTO;
import com.altankoc.entity.Course;
import com.altankoc.entity.Enrollment;
import com.altankoc.entity.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EnrollmentMapper {

    public EnrollmentResponseDTO toResponseDto(Enrollment enrollment) {

        EnrollmentResponseDTO enrollmentResponseDTO = new EnrollmentResponseDTO();

        enrollmentResponseDTO.setEnrollmentId(enrollment.getId());

        enrollmentResponseDTO.setStudentId(enrollment.getStudent().getId());
        enrollmentResponseDTO.setStudentName(enrollment.getStudent().getName());

        enrollmentResponseDTO.setCourseId(enrollment.getCourse().getId());
        enrollmentResponseDTO.setCourseName(enrollment.getCourse().getCourseName());

        enrollmentResponseDTO.setEnrollmentDate(enrollment.getEnrollmentDate());

        return enrollmentResponseDTO;
    }

    public Enrollment toEntity(EnrollmentRequestDTO dto, Student student, Course course) {
        Enrollment enrollment = new Enrollment();

        enrollment.setStudent(student);
        enrollment.setCourse(course);

        if(dto.getEnrollmentDate() != null) {
            enrollment.setEnrollmentDate(dto.getEnrollmentDate());
        } else {
            enrollment.setEnrollmentDate(LocalDate.now());
        }

        return enrollment;
    }


}
