package com.heavenhr.recruit.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import com.heavenhr.recruit.enumeration.ApplicationStatus;
import com.heavenhr.recruit.enumeration.StatusConverter;

@Entity
public class Application {
	@Id
	@GeneratedValue
	private Long id;
	@NotNull(message = "Offer id cannot be null")
	private Long relatedOffer;
	@Column(unique = true)
	private String candidateEmail;
	@Lob
	private String resumeText;
	@Convert(converter = StatusConverter.class)
	private ApplicationStatus applicationStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRelatedOffer() {
		return relatedOffer;
	}

	public void setRelatedOffer(Long relatedOffer) {
		this.relatedOffer = relatedOffer;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

	public String getResumeText() {
		return resumeText;
	}

	public void setResumeText(String resumeText) {
		this.resumeText = resumeText;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

}
