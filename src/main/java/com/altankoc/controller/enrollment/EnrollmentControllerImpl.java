package com.altankoc.controller.enrollment;

import com.altankoc.dto.request.EnrollmentRequestDTO;
import com.altankoc.dto.response.EnrollmentResponseDTO;
import com.altankoc.entity.Course;
import com.altankoc.entity.Student;
import com.altankoc.service.enrollment.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentControllerImpl implements EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Override
    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDTO>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentResponseDTO> findEnrollmentById(@PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getEnrollmentById(id));
    }

    @Override
    @PostMapping
    public ResponseEntity<EnrollmentResponseDTO> createEnrollment(@RequestBody EnrollmentRequestDTO dto, Student student, Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enrollmentService.createEnrollment(dto,student,course));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
        return ResponseEntity.noContent().build();
    }
}
