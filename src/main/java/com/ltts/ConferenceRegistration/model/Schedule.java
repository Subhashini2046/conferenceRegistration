package com.ltts.ConferenceRegistration.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private LocalDate sechduledDate;
	private String meetingLink;
	private String meetingPlatform;
	private int conIdPk;
	private String status;

	public Schedule() {
		super();
	}



	public Schedule(LocalDate sechduledDate, String meetingLink, String meetingPlatform, int conIdPk, String status) {
		super();
		this.sechduledDate = sechduledDate;
		this.meetingLink = meetingLink;
		this.meetingPlatform = meetingPlatform;
		this.conIdPk = conIdPk;
		this.status = status;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getConIdPk() {
		return conIdPk;
	}

	public void setConIdPk(int conIdPk) {
		this.conIdPk = conIdPk;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getSechduledDate() {
		return sechduledDate;
	}

	public void setSechduledDate(LocalDate sechduledDate) {
		this.sechduledDate = sechduledDate;
	}

	public String getMeetingLink() {
		return meetingLink;
	}

	public void setMeetingLink(String meetingLink) {
		this.meetingLink = meetingLink;
	}

	public String getMeetingPlatform() {
		return meetingPlatform;
	}

	public void setMeetingPlatform(String meetingPlatform) {
		this.meetingPlatform = meetingPlatform;
	}



	@Override
	public String toString() {
		return "Schedule [id=" + id + ", sechduledDate=" + sechduledDate + ", meetingLink=" + meetingLink
				+ ", meetingPlatform=" + meetingPlatform + ", conIdPk=" + conIdPk + ", status=" + status + "]";
	}

	
}
