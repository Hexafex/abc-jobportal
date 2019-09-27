package org.jobportal.bean;

public class CommentBean extends Entity {
private String msgContent;
private String username;
private int postId;


public String getMsgContent() {
	return msgContent;
}
public void setMsgContent(String msgContent) {
	this.msgContent = msgContent;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getPostId() {
	return postId;
}
public void setPostId(int postId) {
	this.postId = postId;
}

}
