package com.github.saintukrainian.aqa_lab3.api;

import com.github.saintukrainian.aqa_lab3.entity.Doctor;
import com.github.saintukrainian.aqa_lab3.repository.DoctorRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctors")
public class DoctorController {

  private final DoctorRepository doctorRepository;

  @GetMapping("/")
  public List<Doctor> fetchAllDoctors() {
    return doctorRepository.findAll();
  }
}
