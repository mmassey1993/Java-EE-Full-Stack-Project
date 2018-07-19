package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Subject {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String subjectName;
	@Size(min=1, max=5)
	private String subjectRating;

	public Subject() {

	}

	public Subject(String subjectName, String subjectRating) {
		this.subjectName = subjectName;
		this.subjectRating = subjectRating;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectRating() {
		return subjectRating;
	}

	public void setSubjectRating(String subjectRating) {
		this.subjectRating = subjectRating;
	}
}
