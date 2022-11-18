package com.github.saintukrainian.aqa_lab3.repository;

import com.github.saintukrainian.aqa_lab3.entity.DoctorSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedule, Long> {

}
