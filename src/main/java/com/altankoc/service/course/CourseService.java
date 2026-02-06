package com.altankoc.service.course;

import com.altankoc.dto.request.CourseRequestDTO;
import com.altankoc.dto.response.CourseResponseDTO;
import com.altankoc.entity.Course;

import java.util.List;

public interface CourseService {

    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO getCourseById(Long id);

    CourseResponseDTO createCourse(CourseRequestDTO dto);

    void deleteCourse(Long id);

}
