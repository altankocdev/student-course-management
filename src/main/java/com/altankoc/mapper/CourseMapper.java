package com.altankoc.mapper;


import com.altankoc.dto.request.CourseRequestDTO;
import com.altankoc.dto.response.CourseResponseDTO;
import com.altankoc.entity.Course;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseResponseDTO toResponseDto(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();

        dto.setId(course.getId());
        dto.setCourseName(course.getCourseName());
        dto.setCredits(course.getCredits());

        dto.setStudentNames(
                course.getEnrollments().stream()
                        .map(enrollment -> enrollment.getStudent().getName())
                        .collect(Collectors.toList())
        );

        dto.setEnrolledStudentCount(course.getEnrollments().size());

        return dto;
    }

    public Course toEntity(CourseRequestDTO courseRequestDTO) {
        Course course = new Course();

        course.setCourseName(courseRequestDTO.getCourseName());
        course.setCredits(courseRequestDTO.getCredits());

        return course;
    }
}
