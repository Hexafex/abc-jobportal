package org.jobportal.bean;
/**
 * This the job post Bean class that will hold
 * information to be displayed pertaining to the jobpostBean
 * @author Izzul
 *
 */
public class JobPostBean extends Entity {
private String postContent;
private String postTitle;
private String username;

public String getPostContent() {
	return postContent;
}
public void setPostContent(String postContent) {
	this.postContent = postContent;
}
public String getPostTitle() {
	return postTitle;
}
public void setPostTitle(String postTitle) {
	this.postTitle = postTitle;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

}
