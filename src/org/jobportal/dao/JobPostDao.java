package org.jobportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jobportal.bean.Entity;
import org.jobportal.bean.JobPostBean;

public class JobPostDao extends DBConnection implements DaoInterface{

	@Override
	public boolean insert(Entity e) throws SQLException {
		JobPostBean jp= (JobPostBean) e;
		boolean isAdded= false;
		getConnection().setAutoCommit(false);
		int i =0;
		try {
			String sql= "INSERT INTO jobpost (username,postTitle,postContent) VALUES (?,?,?)";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, jp.getUsername());
			ps.setString(2, jp.getPostTitle());
			ps.setString(3, jp.getPostContent());
			i=ps.executeUpdate();
			if(i>0) {
				isAdded=true;
				System.out.println("post is added");
				return isAdded;
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			getConnection().rollback();
			return false;
		} finally {
			if(getConnection()!= null) {
				getConnection().close();
			}
		}
		return false;
	}

	@Override
	public boolean update(Entity e) throws SQLException {
		int ctr;
		boolean isUpdated = false;
		JobPostBean jp= (JobPostBean) e;
	
		try {
		String sql="UPDATE jobpost SET username =?,postTitle=?,postContent=? WHERE postid=?";
		PreparedStatement ps=getConnection().prepareStatement(sql);
		ps.setString(1, jp.getUsername());
		ps.setString(2, jp.getPostTitle());
		ps.setString(3, jp.getPostContent());
		ps.setInt(4, jp.getId());
		ctr= ps.executeUpdate();
		if(ctr>0) {
			isUpdated=true;
		}
		return isUpdated;
		}catch(SQLException ex){
		ex.printStackTrace();
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
		}
		return isUpdated;
	}

	@Override
	public boolean delete(Entity e) throws SQLException {
		int ctr = 0;
		boolean isDeleted = false;
		JobPostBean jp=(JobPostBean) e;
		try{
			String sql="DELETE FROM jobpost WHERE postid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setInt(1,jp.getId());
			ctr=ps.executeUpdate();
			if(ctr>0) {
				isDeleted=true;
			}
			return isDeleted;
		}catch(SQLException ex){
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
		// TODO Auto-generated method stub Does not apply to this class
		return null;
	}

	@Override
	public ArrayList<Entity> getAll() throws SQLException {
		JobPostBean jp= null;
		ArrayList<Entity> jobList= null;
		try {
			jobList= new ArrayList<Entity>();
			String sql="SELECT * FROM jobpost";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				jp= new JobPostBean();
				jp.setId(rs.getInt("postId"));
				jp.setUsername(rs.getString("username"));
				jp.setPostTitle(rs.getString("postTitle"));
				jp.setPostContent(rs.getString("postContent"));
				jobList.add((Entity)jp);
			}
			return jobList;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
		}
		return null;
	}

	@Override
	public Entity getEntityById(int id) throws SQLException {
		ResultSet rs = null;
		JobPostBean jp = null;
		try{
			String sql="SELECT * FROM jobpost WHERE postid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()) {
				jp = new JobPostBean();
				jp.setId(rs.getInt("postid"));
				jp.setUsername(rs.getString("username"));
				jp.setPostTitle(rs.getString("postTitle"));
				jp.setPostContent(rs.getString("postContent"));
			}
			return jp;
		}catch(SQLException ex){
			ex.printStackTrace();
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
		}
	}
		return null;
	}

	@Override
	public ArrayList<Entity> getListbyUsername(String username) throws SQLException {
		JobPostBean jp= null;
		ArrayList<Entity> jobList= null;
		try {
			jobList= new ArrayList<Entity>();
			String sql="SELECT * FROM jobpost where username=?";
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				jp= new JobPostBean();
				jp.setId(rs.getInt("postId"));
				jp.setUsername(rs.getString("username"));
				jp.setPostTitle(rs.getString("postTitle"));
				jp.setPostContent(rs.getString("postContent"));
				jobList.add((Entity)jp);
			}
			return jobList;
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
		}
		return null;
	}

}
