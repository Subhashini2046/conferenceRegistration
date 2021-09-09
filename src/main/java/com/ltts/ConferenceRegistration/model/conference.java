package com.ltts.ConferenceRegistration.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class conference {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int conId;
	private String title;
	private String publicationIssue;
	private LocalDate submissionDeadline;
	private LocalDate startDate;
	private LocalDate endDate;
	private String status;
	private LocalDate conDate;
	
	
	public conference() {
		super();
	}
	public conference(String title, String publicationIssue, LocalDate submissionDeadline,
			LocalDate startDate, LocalDate endDate) {
		super();
		this.title = title;
		this.publicationIssue = publicationIssue;
		this.submissionDeadline = submissionDeadline;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	public LocalDate getConDate() {
		return conDate;
	}
	public void setConDate(LocalDate conDate) {
		this.conDate = conDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getConId() {
		return conId;
	}
	public void setConId(int conId) {
		this.conId = conId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublicationIssue() {
		return publicationIssue;
	}
	public void setPublicationIssue(String publicationIssue) {
		this.publicationIssue = publicationIssue;
	}
	public LocalDate getSubmissionDeadline() {
		return submissionDeadline;
	}
	public void setSubmissionDeadline(LocalDate submissionDeadline) {
		this.submissionDeadline = submissionDeadline;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "conference [conId=" + conId + ", title=" + title + ", publicationIssue=" + publicationIssue
				+ ", submissionDeadline=" + submissionDeadline + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", status=" + status + ", conDate=" + conDate + "]";
	}
	
	
	
}
