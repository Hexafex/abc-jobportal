package org.jobportal.action;

import java.util.ArrayList;
import java.util.Map;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;

import org.jobportal.bean.Entity;
import org.jobportal.bean.UserBean;
import org.jobportal.dao.UserDao;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 6864158977165398761L;
	private UserBean user;
	private UserDao udao = new UserDao();
	private boolean isAdded,isUpdated,isDeleted;
	private String msg;
	private String submitType ="";
	private String username,firstName,lastName,country;
	private Map<String, Object> sessionMap;
	ArrayList<Entity> particulars=null;
	ArrayList<Entity> userList=null;
	boolean noData=true;
	public String execute() throws Exception{
		
		if(user.getFirstName().equals("")||user.getLastName().equals("")||
			user.getEmail().equals("")||user.getUsername().equals("")||
			user.getPassword().equals("")||user.getCountry().equals("")||
			user.getBirthDate().equals("")||user.getBirthMonth().equals("")||
			user.getPostalCode().equals("")) {
				msg="All fields are required!";
		}else if(user.getFirstName().length()<2) {
			msg="First Name must be at least 2 characters long.";
		}else if(user.getLastName().length()<2) {
			msg="Last Name must be at least 2 characters long.";
		}else if(user.getUsername().length()<4) {
			msg="Username length must be at least 4 character long.";
		}else if(UserDao.checkUser(user.getUsername())) {
			msg="User already exist";
		}else if(!user.getEmail().matches("[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")) {
			msg="Please use a valid email address.";
		}else if(user.getPassword().length()<8) {
			msg="Password length must be at least 8 characters long.";
		}else if(!user.getPostalCode().matches("^[0-9]{6,15}$")) {
			msg="Invalid postal code.";
		}else if(!user.getBirthDate().matches("^[0]{1}+[1-9]{1}|^[1-9]{1}|^[1-2]{1}+[0-9]{1}|^[3]{1}+[0-1]{1}")) {
			msg="Invalid date.";
		}else if(!user.getBirthMonth().matches("(?i)(?:Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May|"
				+ "Jun(?:e)?|Jul(?:y)?|Aug(?:ust)?|Sept(?:ember)?|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)?)")) {
			msg="Invalid month.";
		}else {
			return"confirm";
		}
		return "input";
}

	public String addUser() throws Exception {
		
		System.out.println("Sending email");
		
		try {
			isAdded=udao.insert(getUser());
			if(isAdded) {
				String emailSender="teethingtoothbrush@gmail.com";
				String emailSenderPassword="berusgigi";
				String emailReceiver=getUser().getEmail();
				System.out.println(emailReceiver);
				udao.send(emailSender, emailSenderPassword, emailReceiver);
				msg="Registration Success. An email will be sent to you shortly";
				return SUCCESS;	
			} else {
				msg="Error";
			}
			
		} catch (Exception ex) {
		ex.printStackTrace();
		
		}
		return INPUT;
	}
/**
 * This method changes the password value that is stored in the database
 * @return this returns a string that will be read by the struts filter to show the appropriate response
 * @throws Exception
 */

	public String changePass() throws Exception {
		int ctr = 0;
		try {
			
			ctr=udao.changePass(getUser().getPassword(),getUser().getEmail());
		
			if(ctr>0) {
				msg="Your Password Has Been Updated!";
			
			}else {
				msg="Password not Updated";
			}	
		} catch (Exception ex) {
			
			ex.printStackTrace();
			msg="Email does not exists";
			
			
		}
		return "changePass";
	}
	/**
	 * this method calls a method of the same name in the DAO of the same name to update the selected user in the database
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String updateUser() throws Exception {
		try {
			if(submitType.equals("update")) {
				user=(UserBean) udao.getEntityByUsername(username);
				return "editUser";
			}else {
				
				isUpdated=udao.update(user);
				if(isUpdated==true) {
					UserBean userInfo = new UserBean();
					msg="Particulars is Updated!";
					userInfo= (UserBean) udao.getEntityByUsername(user.getUsername());
					particulars= new ArrayList<Entity>();
					particulars.add(userInfo);
					//noData=false;
					return "updatedUser";
				}
				else {
					UserBean userInfo = new UserBean();
					msg="Particulars is not Updated!";
					userInfo= (UserBean) udao.getEntityByUsername(username);
					particulars= new ArrayList<Entity>();
					particulars.add(userInfo);
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "updatedUser";
	}
	/**
	 *  this method calls a method from the DAO of the same name to delete the user from the database
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String deleteUser() throws Exception {
		try {
			user = (UserBean) udao.getEntityByUsername(getUser().getUsername());
			isDeleted = udao.delete(user);
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "deleteUSer";
	}
	/**
	 * this method retrieves and display the information of the user
	 * @return this returns a string that will be read by the struts filter to show the appropriate response
	 * @throws Exception
	 */
	public String showUser() throws Exception{
		try {
			user= (UserBean) udao.getEntityByUsername(getUsername());
			particulars= new ArrayList<Entity>();
			particulars.add(user);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "profile";
	}
	/**
	 * this method calls a method from the DAO of the same name to get a users to display in the view
	 * @return
	 * @throws Exception
	 */
	public String searchUser() throws Exception{
		userList = new ArrayList<Entity>();
		try {
			userList =(ArrayList<Entity>) udao.listEntityByUsername(username);
			if(userList!=null) {
				noData=false;
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "search";
	}
	
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
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
	public UserDao getUdao() {
		return udao;
	}
	public void setUdao(UserDao udao) {
		this.udao = udao;
	}
	public boolean isAdded() {
		return isAdded;
	}
	public void setAdded(boolean isAdded) {
		this.isAdded = isAdded;
	}
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ArrayList<Entity> getParticulars() {
		return particulars;
	}
	public void setParticulars(ArrayList<Entity> particulars) {
		this.particulars = particulars;
	}
	public boolean isUpdated() {
		return isUpdated;
	}
	public void setUpdated(boolean isUpdated) {
		this.isUpdated = isUpdated;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isNoData() {
		return noData;
	}
	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCountry() {
		return country;
	}
	public ArrayList<Entity> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<Entity> userList) {
		this.userList = userList;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}