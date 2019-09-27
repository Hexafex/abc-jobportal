package org.jobportal.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jobportal.bean.Entity;
import org.jobportal.bean.QualificationBean;
import org.jobportal.dao.QualificationDao;

import com.opensymphony.xwork2.ActionSupport;

public class QualificationAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2643567604612190767L;
	private Map<String, Object> sessionMap;
	QualificationBean qual= null;
	QualificationDao qualDao = new QualificationDao();
	ArrayList<Entity> qualList = null;
	String msg;
	String submitType="";
	String username;
	int qualId;
	boolean isAdded=false;
	boolean isDeleted=false;
	boolean isUpdated=false;
	boolean noData=true;
	//show user's list of qualification
	public String listQual() {
		qualList = new ArrayList<Entity>();
		try {
			qualList = qualDao.getListbyUsername(username);
			if(qualList!=null) {
				noData=false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "listQual";
	}

	public String addQual() throws Exception{
		try {
			isAdded = qualDao.insert(qual);
			if(isAdded==true) {
				noData=false;
				msg="Qualification Added!";
				qualList= qualDao.getListbyUsername(qual.getUsername());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "addQual";
	}
	
	public String deleteQual() throws Exception {
		try {
			qual= new QualificationBean();
			qual= (QualificationBean) qualDao.getEntityById(qualId);
			isDeleted = qualDao.delete(qual);
			if(isDeleted==true) {
				msg="Qualification is deleted Succesfully";
				qualList= qualDao.getListbyUsername(qual.getUsername());
				if(qualList!= null) {
					noData=false;
				}
			}else {
				msg="Qualification not deleted";
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "deleteQual";
	}
	public String updateQual() throws Exception{
		
		try {
			if(submitType.equals("update")) {
				qual = (QualificationBean) qualDao.getEntityById(qualId);
				return "editQual";
			}else {
				isUpdated= qualDao.update(qual);
				if(isUpdated==true) {
					msg="Qualification has been updated";
					qualList= qualDao.getListbyUsername(qual.getUsername());
					noData=false;
					return "updateQual";
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "updateQual";
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;		
	}

	public QualificationBean getQual() {
		return qual;
	}

	public void setQual(QualificationBean qual) {
		this.qual = qual;
	}

	public QualificationDao getQualDao() {
		return qualDao;
	}

	public void setQualDao(QualificationDao qualDao) {
		this.qualDao = qualDao;
	}

	public ArrayList<Entity> getQualList() {
		return qualList;
	}

	public void setQualList(ArrayList<Entity> qualList) {
		this.qualList = qualList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public int getQualId() {
		return qualId;
	}

	public void setQualId(int qualId) {
		this.qualId = qualId;
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

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
}
