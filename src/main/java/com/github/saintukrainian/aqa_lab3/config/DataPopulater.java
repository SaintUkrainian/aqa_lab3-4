package com.github.saintukrainian.aqa_lab3.config;

import com.github.saintukrainian.aqa_lab3.entity.Doctor;
import com.github.saintukrainian.aqa_lab3.repository.DoctorRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataPopulater implements ApplicationListener<ApplicationReadyEvent> {

  private final DoctorRepository doctorRepository;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    log.info("Populating Doctor table");
    doctorRepository.saveAll(buildDoctors());
    log.info("Doctor table has been populated with data");
  }

  private static List<Doctor> buildDoctors() {
    return List.of(
        Doctor.builder()
            .firstName("Denys")
            .lastName("Matsenko")
            .build(),
        Doctor.builder()
            .firstName("Joshua")
            .lastName("Long")
            .build()
    );
  }
}
