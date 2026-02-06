package com.altankoc.service.student;

import com.altankoc.dto.request.StudentRequestDTO;
import com.altankoc.dto.response.StudentResponseDTO;
import com.altankoc.entity.Student;
import com.altankoc.mapper.StudentMapper;
import com.altankoc.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return repository.findAll().stream()
                .map(studentMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı: "+id));
        return studentMapper.toResponseDto(student);
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO requestDTO) {
        Student student = studentMapper.toEntity(requestDTO);

        Student savedStudent = repository.save(student);

        return studentMapper.toResponseDto(savedStudent);
    }

    @Override
    public void deleteStudent(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı: "+id));

        repository.deleteById(id);
    }
}
