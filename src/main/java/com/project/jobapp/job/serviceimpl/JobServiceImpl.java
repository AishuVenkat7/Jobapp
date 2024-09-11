package com.project.jobapp.job.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.jobapp.job.Job;
import com.project.jobapp.job.JobRespository;
import com.project.jobapp.job.JobService;

@Service
public class JobServiceImpl implements JobService {

	private JobRespository jobRepository;

	public JobServiceImpl(JobRespository jobRepository) {
		this.jobRepository = jobRepository;
	}

	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}

	@Override
	public void createJob(Job job) {
		jobRepository.save(job);
	}

	@Override
	public Job findJobById(Long id) {
		return jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
	}

	@Override
	public boolean deleteJobById(Long id) {
		try {
			jobRepository.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateJob(Long id, Job updatedJob) {
		Optional<Job> jobOptional = jobRepository.findById(id);
		if(jobOptional.isPresent()) {
			Job existingJob = jobOptional.get();
			existingJob.setTitle(updatedJob.getTitle());
			existingJob.setDescription(updatedJob.getDescription());
			existingJob.setMinSalary(updatedJob.getMinSalary());
			existingJob.setMaxSalary(updatedJob.getMaxSalary());
			existingJob.setLocation(updatedJob.getLocation());
			jobRepository.save(existingJob);
			return true;
		}
		return false;
	}

}
