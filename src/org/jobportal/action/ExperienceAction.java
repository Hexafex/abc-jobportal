package org.jobportal.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jobportal.bean.Entity;
import org.jobportal.bean.ExperienceBean;
import org.jobportal.bean.UserBean;
import org.jobportal.dao.ExperienceDao;


import com.opensymphony.xwork2.ActionSupport;

public class ExperienceAction extends ActionSupport implements SessionAware {

	
	private static final long serialVersionUID = 8128162210698895642L;
	private Map<String, Object> sessionMap;
	ExperienceDao expDao= new ExperienceDao();
	UserBean user;
	ExperienceBean exp =null;
	ArrayList<Entity> expList = null;
	String msg;
	String username;
	int expId;
	String submitType="";
	boolean isAdded=false;
	boolean isDeleted=false;
	boolean isUpdated=false;
	boolean noData=true;
	
	//get a list of experiences belonging to user
	/**
	 * this method calls a method from the DAO of the same name to get a list of experiences to display in the view
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String listExp() throws Exception{
		expList= new ArrayList<Entity>();
		try {
			
			expList=expDao.getListbyUsername(username);
			if(expList!=null) {
				noData=false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "listExp";
	}
	/**
	 * this method calls a method from the DAO of the same name to insert a new experience entry into the database.
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String addExp() throws Exception{		
		try {
			isAdded=expDao.insert(exp);
			if(isAdded==true) {
				noData=false;
				msg="Experience Added!";
				expList= expDao.getListbyUsername(exp.getUsername());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "addExp";
	}
	/**
	 *  this method calls a method from the DAO of the same name to delete the experience from the database
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String deleteExp() throws Exception{
		try {
			exp = new ExperienceBean();
			exp= (ExperienceBean) expDao.getEntityById(expId);
			isDeleted =expDao.delete(exp);
			if(isDeleted==true) {
				msg="Experience is deleted Successfully";
				expList= expDao.getListbyUsername(exp.getUsername());		
				if(expList!=null) {
					noData=false;
				}
			}else {
				msg="Experience not deleted";
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "deleteExp";
	}
	/**
	 * this method calls a method of the same name in the DAO of the same name to update the selected experience in the database
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String updateExp()throws Exception{
		
		try {
			if(submitType.equals("update")) {
				exp=(ExperienceBean) expDao.getEntityById(expId);
				return "editExp";
			}else {
				
				isUpdated=expDao.update(exp);
				if(isUpdated==true) {
					
					msg="Experience is Updated!";
					expList= expDao.getListbyUsername(exp.getUsername());
					noData=false;
					return "updateExp";
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "updateExp";
	}
	public ExperienceDao getExpDao() {
		return expDao;
	}

	public void setExpDao(ExperienceDao expDao) {
		this.expDao = expDao;
	}

	public ExperienceBean getExp() {
		return exp;
	}

	public void setExp(ExperienceBean exp) {
		this.exp = exp;
	}

	public ArrayList<Entity> getExpList() {
		return expList;
	}

	public void setExpList(ArrayList<Entity> expList) {
		this.expList = expList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public int getExpId() {
		return expId;
	}
	public void setExpId(int expId) {
		this.expId = expId;
	}
	public String getSubmitType() {
		return submitType;
	}
	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
		
	}
	
}
