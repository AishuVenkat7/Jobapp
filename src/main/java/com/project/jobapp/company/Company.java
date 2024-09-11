package com.project.jobapp.company;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.jobapp.job.Job;
import com.project.jobapp.review.Review;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "company")
	private List<Job> jobs;
	
	@OneToMany(mappedBy = "company")
	private List<Review> reviews;

}
