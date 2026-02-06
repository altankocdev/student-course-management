package com.altankoc.mapper;

import com.altankoc.dto.request.StudentRequestDTO;
import com.altankoc.dto.response.StudentResponseDTO;
import com.altankoc.entity.Student;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StudentMapper {

    public StudentResponseDTO toResponseDto(Student student) {

        StudentResponseDTO dto = new StudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());

        dto.setCourseNames(
                student.getEnrollments().stream()
                        .map(enrollment -> enrollment.getCourse().getCourseName())
                        .collect(Collectors.toList())
        );

        return dto;
    }



    public Student toEntity(StudentRequestDTO studentRequestDTO) {

        Student student = new Student();

        student.setName(studentRequestDTO.getName());

        return student;
    }
}
