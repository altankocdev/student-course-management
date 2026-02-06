package com.altankoc.service.enrollment;

import com.altankoc.dto.request.EnrollmentRequestDTO;
import com.altankoc.dto.response.EnrollmentResponseDTO;
import com.altankoc.entity.Course;
import com.altankoc.entity.Enrollment;
import com.altankoc.entity.Student;
import com.altankoc.mapper.EnrollmentMapper;
import com.altankoc.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository repository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public List<EnrollmentResponseDTO> getAllEnrollments() {
        return repository.findAll()
                .stream()
                .map(enrollmentMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public EnrollmentResponseDTO getEnrollmentById(Long id) {
        Enrollment enrollment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ders kaydı bulunamadı: "+id));

        return enrollmentMapper.toResponseDto(enrollment);
    }

    @Override
    public EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO dto, Student student, Course course) {

        Enrollment enrollment = enrollmentMapper.toEntity(dto,student,course);

        Enrollment savedEnrollment = repository.save(enrollment);

        return enrollmentMapper.toResponseDto(savedEnrollment);
    }

    @Override
    public void deleteEnrollment(Long id) {

        Enrollment enrollment = repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Ders kaydı bulunamadı: "+id));

        repository.deleteById(id);
    }
}
