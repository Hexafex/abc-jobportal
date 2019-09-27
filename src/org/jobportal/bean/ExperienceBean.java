package org.jobportal.bean;
/**
 * This the Experience Bean class that will hold
 * information to be displayed pertaining to the experiencebean
 * @author Izzul
 *
 */
public class ExperienceBean extends Entity {
 private String companyName;
 private String jobTitle;
 private String username;
 private String yearsOfExp;
 private int SrNo;
 
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getYearsOfExp() {
		return yearsOfExp;
	}
	public void setYearsOfExp(String yearsOfExp) {
		this.yearsOfExp = yearsOfExp;
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
