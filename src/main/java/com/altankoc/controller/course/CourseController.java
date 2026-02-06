package com.altankoc.controller.course;

import com.altankoc.dto.request.CourseRequestDTO;
import com.altankoc.dto.response.CourseResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseController {

    ResponseEntity<List<CourseResponseDTO>> getAllCourses();

    ResponseEntity<CourseResponseDTO> findCourseById(Long id);

    ResponseEntity<CourseResponseDTO> createCourse(CourseRequestDTO dto);

    ResponseEntity<Void> deleteCourse(Long id);
}
