package org.jobportal.bean;

public class QualificationBean extends Entity {
private String schoolName;
private String gradYear;
private String specialization;
private String username;
private int SrNo;

public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public String getGradYear() {
	return gradYear;
}
public void setGradYear(String gradYear) {
	this.gradYear = gradYear;
}
public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String specialization) {
	this.specialization = specialization;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getSrNo() {
	return SrNo;
}
public void setSrNo(int srNo) {
	SrNo = srNo;
}
}
