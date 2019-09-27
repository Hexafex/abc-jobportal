package org.jobportal.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jobportal.bean.UserBean;
import org.jobportal.dao.UserDao;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3533361234475911580L;
	UserDao dao = new UserDao();
	UserBean user;
	int ctr;
	private String msg;
	private Map<String, Object> sessionMap;
	List<UserBean> particulars = null;	
	ResultSet rs = null;
	public String execute() {
		try {
			ctr=UserDao.loginValidation(user);
			if (ctr>0) {
				UserBean userInfo= new UserBean();
			sessionMap.put("username",user.getUsername());
			particulars = new ArrayList<UserBean>();
			userInfo=(UserBean) dao.getEntityByUsername(user.getUsername());
			particulars.add(userInfo);
			msg="login success";
				
				return "profile";
			}else {
				msg="Login failed!";
				return LOGIN;
			}
		}catch(Exception  e){
			e.printStackTrace();
		
		}
		return LOGIN;
	}

	public String logout() throws Exception {
		try {
			sessionMap.clear();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return"logout";
	}
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap=arg0;
		
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	public List<UserBean> getParticulars() {
		return particulars;
	}

	public void setParticulars(List<UserBean> particulars) {
		this.particulars = particulars;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
