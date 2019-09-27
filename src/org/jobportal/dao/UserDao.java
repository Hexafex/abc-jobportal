package org.jobportal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jobportal.bean.Entity;
import org.jobportal.bean.UserBean;

public class UserDao extends DBConnection implements DaoInterface  {
	
	@Override
	public boolean insert(Entity e) throws SQLException {
		int ctr;
		boolean isAdded = false;
		
		UserBean user=(UserBean) e;
		
		try {
			String sql="INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPassword());
			ps.setString(6, user.getCountry());
			ps.setString(7, user.getState());
			ps.setString(8, user.getCity());
			ps.setString(9, user.getPostalCode());
			ps.setString(10, user.getBirthDate());
			ps.setString(11, user.getBirthMonth());
			ctr=ps.executeUpdate();
			if(ctr>0) {
				isAdded=true;
			}
			return isAdded;
		}
		catch(SQLException ex){
			ex.printStackTrace();
			return isAdded;
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
		}
	}
}

	@Override
	public boolean update(Entity e) throws SQLException {
		int i =0;
		UserBean user= (UserBean) e;
		try {
			String sql= "UPDATE user SET username= ?, password=?, firstname=?, lastname=?, email=?, password=?, country=?, state=?, city=?, postalcode=?, birthdate=?, birthmonth=? WHERE username=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPassword());
			ps.setString(7, user.getCountry());
			ps.setString(8, user.getState());
			ps.setString(9, user.getCity());
			ps.setString(10, user.getPostalCode());
			ps.setString(11, user.getBirthDate());
			ps.setString(12, user.getBirthMonth());
			ps.setString(13, user.getUsername());
			i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
		}
		return false;
	}

	@Override
	public boolean delete(Entity e) throws SQLException {
		int i=0;
		UserBean user = (UserBean) e;
		try {
			String sql="DELETE FROM user WHERE username =?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			i=ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
		}
		return false;
	}

	@Override
	public Entity getEntityByUsername(String username) throws SQLException {
		Entity e=null;
		try {
			String sql="SELECT * FROM user WHERE username=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserBean user= new UserBean();
				user.setUsername(rs.getString(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setCountry(rs.getString(6));
				user.setState(rs.getString(7));
				user.setCity(rs.getString(8));
				user.setPostalCode(rs.getString(9));
				user.setBirthDate(rs.getString(10));
				user.setBirthMonth(rs.getString(11));
				e=user;
			}
			return e;	
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
		}
		}
		return null;
	}
	public ArrayList<Entity> listEntityByUsername(String username) throws SQLException {
		ArrayList<Entity> userList = new ArrayList<Entity>();
		try {
			String sql="SELECT * FROM user WHERE username LIKE ? OR firstname LIKE ? OR lastname LIKE ? OR country LIKE ? ";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, "%"+username+"%");
			ps.setString(2, "%"+username+"%");
			ps.setString(3, "%"+username+"%");
			ps.setString(4, "%"+username+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				UserBean user= new UserBean();
				user.setUsername(rs.getString(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setCountry(rs.getString(6));
				user.setState(rs.getString(7));
				user.setCity(rs.getString(8));
				user.setPostalCode(rs.getString(9));
				user.setBirthDate(rs.getString(10));
				user.setBirthMonth(rs.getString(11));
				userList.add(user);
			}
			return userList;	
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
		}
		}
		return null;
	}

	@Override
	public ArrayList<Entity> getAll() throws SQLException {
		ArrayList<Entity> eList = null;
		UserBean user = null;
		try {
			eList = new ArrayList<Entity>();
			user = new UserBean();
			String sql="SELECT * FROM user";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				user= new UserBean();
				user.setUsername(rs.getString(1));
				user.setFirstName(rs.getString(2));
				user.setLastName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setCountry(rs.getString(6));
				user.setState(rs.getString(7));
				user.setCity(rs.getString(8));
				user.setPostalCode(rs.getString(9));
				user.setBirthDate(rs.getString(10));
				user.setBirthMonth(rs.getString(11));
				eList.add((Entity)user);
			}
			return eList;	
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
		}
		}
		return null;
	}

//checking if userName exist
	public static boolean checkUser(String username) throws Exception{
		Boolean userExist =false;
		try {
			String sql="SELECT username FROM user WHERE username=?";
			PreparedStatement ps =getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userExist=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
	}
		return userExist;
}
	//login validation
	public static int loginValidation(UserBean user) throws Exception {
		int ctr= 0;
		
		try {
			String sql="SELECT username,password FROM user WHERE username=? and password=?";
			PreparedStatement ps =getConnection().prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2,user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					if(rs.getString("username").equals(user.getUsername()) && 
							rs.getString("password").equals(user.getPassword())) {
						ctr=1;
					}else {
					ctr=0;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
	}
		return ctr;
	}
	//change password
	public int changePass(String password, String email) throws Exception{
		int i =0;
		try {
			String sql="UPDATE user SET password=? where email=?";
			PreparedStatement ps =getConnection().prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			i=ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
		}
		return i;
	}
	//check if new password is same as current password
	public boolean checkPass(UserBean user) throws SQLException {
		int i;
		boolean isSame = false;
		try {
			String sql="SELECT password FROM user WHERE password=?";
			PreparedStatement ps =getConnection().prepareStatement(sql);
			ps.setString(1,user.getPassword());
			i=ps.executeUpdate();
			if(i>0) {
				isSame=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
		}
		return isSame;
	}

	@Override
	public Entity getEntityById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Entity> getListbyUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public void send(String emailSender, String emailSenderPassword, String emailReceiver) {   
System.out.println("email sent.");
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailSender, emailSenderPassword);//userName, password
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailSender));//my email
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailReceiver)//your email
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear " + emailReceiver
                    + "\n\n Thank you for registering with ABC job portal.!"
            		+ "\n We are delighted to have you with us and hope to provide the services"
                    + "\n needed in the website."
            		+ "\n\n Regards"
                    + "\n ABC job portal team");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
