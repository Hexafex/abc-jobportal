package org.jobportal.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jobportal.bean.CommentBean;
import org.jobportal.bean.Entity;
import org.jobportal.bean.JobPostBean;
import org.jobportal.dao.CommentDao;
import org.jobportal.dao.JobPostDao;

import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport implements SessionAware {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 996835078006761478L;
	private Map<String, Object> sessionMap;
	CommentBean comment = null;
	JobPostBean jp = null;
	CommentDao CDao= new CommentDao();
	JobPostDao JPDao = new JobPostDao();
	ArrayList<Entity> commentList=null;
	String msg;
	int postId;
	String submitType="";
	boolean isAdded=false;
	boolean isDeleted=false;
	boolean isUpdated=false;
	boolean noData=true;

	public String listComment() throws Exception {
		try {
			commentList= CDao.getAllByPostId(postId);
			noData=false;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "listComment";
	}
	public String addComment() throws Exception{
		try {
			comment.setPostId(postId);
			isAdded= CDao.insert(comment);
			if(isAdded==true) {
				msg="Comment Added!";
				jp = new JobPostBean();
				jp= (JobPostBean) JPDao.getEntityById(postId);
				commentList= new ArrayList<Entity>();
				commentList= CDao.getAllByPostId(postId);
				noData=false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "addComment";
	}
	public String updateComment() throws Exception{
		try {
			if(submitType.equals("update")) {
				comment = (CommentBean) CDao.getEntityById(postId);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "updateComment";
	}
	public String deleteComment() throws Exception{
		try {
			comment= new CommentBean();
			comment = (CommentBean) CDao.getEntityById(postId);
			isDeleted = CDao.delete(comment);
			if(isDeleted==true) {
				msg="Comment deleted!";
				commentList= CDao.getAll();
				noData=false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "deleteComment";
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap=arg0;
		
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public CommentBean getComment() {
		return comment;
	}

	public void setComment(CommentBean comment) {
		this.comment = comment;
	}

	public CommentDao getCDao() {
		return CDao;
	}

	public void setCDao(CommentDao cDao) {
		CDao = cDao;
	}

	public ArrayList<Entity> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<Entity> commentList) {
		this.commentList = commentList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public boolean isAdded() {
		return isAdded;
	}

	public void setAdded(boolean isAdded) {
		this.isAdded = isAdded;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean isUpdated() {
		return isUpdated;
	}

	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}


}
