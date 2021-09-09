package com.ltts.ConferenceRegistration.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manuscript {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String manuscriptType;
	private String areaOfResearch;
	private String titleOfPaper;
	private String NameOfAuthor1;
	private String restOfTheAuthors;
	private LocalDate dateOfSubmittion;
	private String paperfileName;
	private int conIdFk;
	private String userEmailFk;
	private String status;

	public Manuscript() {
		super();
	}

	public Manuscript(String manuscriptType, String areaOfResearch, String titleOfPaper, String nameOfAuthor1,
			String restOfTheAuthors, LocalDate dateOfSubmittion, String paperfileName, int conIdFk, String userEmailFk,
			String status) {
		super();
		this.manuscriptType = manuscriptType;
		this.areaOfResearch = areaOfResearch;
		this.titleOfPaper = titleOfPaper;
		NameOfAuthor1 = nameOfAuthor1;
		this.restOfTheAuthors = restOfTheAuthors;
		this.dateOfSubmittion = dateOfSubmittion;
		this.paperfileName = paperfileName;
		this.conIdFk = conIdFk;
		this.userEmailFk = userEmailFk;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserEmailFk() {
		return userEmailFk;
	}

	public void setUserEmailFk(String userEmailFk) {
		this.userEmailFk = userEmailFk;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManuscriptType() {
		return manuscriptType;
	}

	public void setManuscriptType(String manuscriptType) {
		this.manuscriptType = manuscriptType;
	}

	public String getAreaOfResearch() {
		return areaOfResearch;
	}

	public void setAreaOfResearch(String areaOfResearch) {
		this.areaOfResearch = areaOfResearch;
	}

	public String getTitleOfPaper() {
		return titleOfPaper;
	}

	public void setTitleOfPaper(String titleOfPaper) {
		this.titleOfPaper = titleOfPaper;
	}

	public String getNameOfAuthor1() {
		return NameOfAuthor1;
	}

	public void setNameOfAuthor1(String nameOfAuthor1) {
		NameOfAuthor1 = nameOfAuthor1;
	}

	public String getRestOfTheAuthors() {
		return restOfTheAuthors;
	}

	public void setRestOfTheAuthors(String restOfTheAuthors) {
		this.restOfTheAuthors = restOfTheAuthors;
	}

	public LocalDate getDateOfSubmittion() {
		return dateOfSubmittion;
	}

	public void setDateOfSubmittion(LocalDate dateOfSubmittion) {
		this.dateOfSubmittion = dateOfSubmittion;
	}

	public String getPaperfileName() {
		return paperfileName;
	}

	public void setPaperfileName(String paperfileName) {
		this.paperfileName = paperfileName;
	}

	public int getConIdFk() {
		return conIdFk;
	}

	public void setConIdFk(int conIdFk) {
		this.conIdFk = conIdFk;
	}

	@Override
	public String toString() {
		return "Manuscript [id=" + id + ", manuscriptType=" + manuscriptType + ", areaOfResearch=" + areaOfResearch
				+ ", titleOfPaper=" + titleOfPaper + ", NameOfAuthor1=" + NameOfAuthor1 + ", restOfTheAuthors="
				+ restOfTheAuthors + ", dateOfSubmittion=" + dateOfSubmittion + ", paperfileName=" + paperfileName
				+ ", conIdFk=" + conIdFk + ", userEmailFk=" + userEmailFk + ", status=" + status + "]";
	}

}
