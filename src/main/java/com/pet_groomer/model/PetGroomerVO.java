package com.pet_groomer.model;

public class PetGroomerVO implements java.io.Serializable {
	private Integer pgId;
	private String pgName;
	private byte[] pgLicenses;
	private byte[] pgPic;
	private String pgArea;
	private String schDate;
	private String schTime;
	private String pgStatus;
	private String pgBio;
	private String pgPw;
	private String pgEmail;
	private Integer totalStars;
	private Integer ratingTimes;
	private Integer reportTimes;
	

	public PetGroomerVO() {
		super();
		
	}

	public Integer getPgId() {
		return pgId;
	}

	public void setPgId(Integer pgId) {
		this.pgId = pgId;
	}

	public String getPgName() {
		return pgName;
	}

	public void setPgName(String pgName) {
		this.pgName = pgName;
	}

	public byte[] getPgLicenses() {
		return pgLicenses;
	}

	public void setPgLicenses(byte[] pgLicenses) {
		this.pgLicenses = pgLicenses;
	}

	public byte[] getPgPic() {
		return pgPic;
	}

	public void setPgPic(byte[] pgPic) {
		this.pgPic = pgPic;
	}

	public String getPgArea() {
		return pgArea;
	}

	public void setPgArea(String pgArea) {
		this.pgArea = pgArea;
	}

	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	public String getSchTime() {
		return schTime;
	}

	public void setSchTime(String schTime) {
		this.schTime = schTime;
	}

	public String getPgStatus() {
		return pgStatus;
	}

	public void setPgStatus(String pgStatus) {
		this.pgStatus = pgStatus;
	}

	public String getPgBio() {
		return pgBio;
	}

	public void setPgBio(String pgBio) {
		this.pgBio = pgBio;
	}

	public String getPgPw() {
		return pgPw;
	}

	public void setPgPw(String pgPw) {
		this.pgPw = pgPw;
	}

	public String getPgEmail() {
		return pgEmail;
	}

	public void setPgEmail(String pgEmail) {
		this.pgEmail = pgEmail;
	}

	public Integer getTotalStars() {
		return totalStars;
	}

	public void setTotalStars(Integer totalStars) {
		this.totalStars = totalStars;
	}

	public Integer getRatingTimes() {
		return ratingTimes;
	}

	public void setRatingTimes(Integer ratingTimes) {
		this.ratingTimes = ratingTimes;
	}

	public Integer getReportTimes() {
		return reportTimes;
	}

	public void setReportTimes(Integer reportTimes) {
		this.reportTimes = reportTimes;
	}

}
