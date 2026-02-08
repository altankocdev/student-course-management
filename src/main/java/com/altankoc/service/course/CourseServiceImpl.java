package com.altankoc.service.course;

import com.altankoc.dto.request.CourseRequestDTO;
import com.altankoc.dto.response.CourseResponseDTO;
import com.altankoc.entity.Course;
import com.altankoc.exception.ResourceNotFoundException;
import com.altankoc.mapper.CourseMapper;
import com.altankoc.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final CourseMapper courseMapper;


    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return repository.findAll().stream()
                .map(courseMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ders bulunamadı: "+id));

        return courseMapper.toResponseDto(course);
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {

        Course course = courseMapper.toEntity(dto);
        Course savedCourse = repository.save(course);

        return courseMapper.toResponseDto(savedCourse);
    }

    @Override
    public void deleteCourse(Long id) {

        Course course = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ders bulunamadı: "+id));

        repository.deleteById(id);

    }
}
