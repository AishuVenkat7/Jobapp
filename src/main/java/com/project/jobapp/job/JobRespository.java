package com.project.jobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRespository extends JpaRepository<Job, Long> {

}
