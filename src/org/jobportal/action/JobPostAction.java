package org.jobportal.action;

import java.util.ArrayList;

import org.jobportal.bean.Entity;
import org.jobportal.bean.JobPostBean;
import org.jobportal.dao.CommentDao;
import org.jobportal.dao.JobPostDao;

import com.opensymphony.xwork2.ActionSupport;
/**
 * this is a controller class that contains all the actions this class can do that pertains to the jobPostBean and its views.
 * @author Izzul
 *
 */
public class JobPostAction extends ActionSupport {

	private static final long serialVersionUID = 692742455036642258L;
	CommentDao CDao= new CommentDao();
	JobPostDao JPDao= new JobPostDao();
	JobPostBean jp= null;
	ArrayList<Entity> jobList = null;
	ArrayList<Entity> commentList = null;
	String msg;
	String submitType= "";
	private int postId;
	boolean isAdded=false;
	boolean isDeleted=false;
	boolean isUpdated=false;
	boolean noData;
	
	//list all the post available

	public String execute() throws Exception {
		jobList= new ArrayList<Entity>();
		try {
			jobList=JPDao.getAll();
			if(jobList!=null) {
				noData=false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "jobList";
	}
	// add a new job post
	/**
	 * this method calls a method from the DAO of the same name to insert a new job post entry into the database.
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String addPost() throws Exception {
		try {			
			isAdded=JPDao.insert(getJp());
			if(isAdded==true) {
				msg="Post added!";
				jobList= JPDao.getAll();
				noData=false;
				return "addPost";
			}else {
				msg="Post failed to add";
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "input";
	}

	//show selected post content
	/**
	 * this method calls a method from the DAO of the same name to get a list of job posts objects to display in the view
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String showPost() throws Exception {
		try {
			jp= new JobPostBean();
			jp= (JobPostBean) JPDao.getEntityById(postId);
			commentList =new ArrayList<Entity>();
			commentList= CDao.getAllByPostId(postId);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "showPost";
	}
	//delete post
	/**
	 *  this method calls a method from the DAO of the same name to delete the selected post from the database
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String deletePost() throws Exception{
		try {
			jp= new JobPostBean();
			jp = (JobPostBean) JPDao.getEntityById(postId);
			isDeleted=JPDao.delete(jp);
			if(isDeleted==true) {
				msg="Post Deleted!";
				
			}else {
				msg="Post Failed to Delete";
			}
			jobList= JPDao.getAll();
			noData=false;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "deletePost";
	}
	/**
	 * this method calls a method of the same name in the DAO of the same name to update the selected job post in the database
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String updatePost() throws Exception{
		try {
			if(submitType.equals("update")) {
				
				jp=(JobPostBean) JPDao.getEntityById(postId);
				return "editPost";
			}else {
				
				isUpdated=JPDao.update(jp);
				if(isUpdated==true) {
					
					msg="Post is Updated!";
					jobList= JPDao.getAll();
					noData=false;
					return "updatePost";
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "updatePost";
	}
	public JobPostDao getJPDao() {
		return JPDao;
	}

	public void setJPDao(JobPostDao jPDao) {
		JPDao = jPDao;
	}

	public JobPostBean getJp() {
		return jp;
	}

	public void setJp(JobPostBean jp) {
		this.jp = jp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isAdded() {
		return isAdded;
	}

	public void setAdded(boolean isAdded) {
		this.isAdded = isAdded;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<Entity> getJobList() {
		return jobList;
	}
	public void setJobList(ArrayList<Entity> jobList) {
		this.jobList = jobList;
	}
	public boolean isNoData() {
		return noData;
	}
	public void setNoData(boolean noData) {
		this.noData = noData;
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
	
}
