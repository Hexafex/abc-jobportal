package org.jobportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jobportal.bean.Entity;
import org.jobportal.bean.QualificationBean;

public class QualificationDao extends DBConnection implements DaoInterface{

	@Override
	public boolean insert(Entity e) throws SQLException {
		int ctr;
		boolean isAdded = false;
		QualificationBean qual = (QualificationBean) e;
		try {
			String sql="INSERT INTO qual (username,specialization,grad_year,school_name) VALUES (?,?,?,?)";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, qual.getUsername());
			ps.setString(2, qual.getSpecialization());
			ps.setString(3, qual.getGradYear());
			ps.setString(4, qual.getSchoolName());
			ctr=ps.executeUpdate();
			if(ctr>0) {
				isAdded=true;
			}
			return isAdded;
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
	public boolean update(Entity e) throws SQLException {
		int ctr;
		boolean isUpdated=false;
		QualificationBean qual=(QualificationBean) e;
		try {
			String sql="UPDATE qual SET username =?,specialization=?,grad_year=?,school_name=? WHERE qualid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, qual.getUsername());
			ps.setString(2, qual.getSpecialization());
			ps.setString(3, qual.getGradYear());
			ps.setString(4, qual.getSchoolName());
			ps.setInt(5, qual.getId());
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
		return false;
	}

	@Override
	public boolean delete(Entity e) throws SQLException {
		int ctr = 0;
		boolean isDeleted = false;
		QualificationBean qual=(QualificationBean) e;
		try{
			String sql="DELETE FROM qual WHERE qualid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setInt(1,qual.getId());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity getEntityById(int id) throws SQLException {
		ResultSet rs = null;
		QualificationBean qual = null;
		try{
			String sql="SELECT * FROM qual WHERE qualid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()) {
				qual = new QualificationBean();
				qual.setId(rs.getInt("qualid"));
				qual.setUsername(rs.getString("username"));
				qual.setSpecialization(rs.getString("specialization"));
				qual.setGradYear(rs.getString("grad_year"));
				qual.setSchoolName(rs.getString("school_name"));	
			}
			return qual;
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
	public ArrayList<Entity> getAll() throws SQLException {
		ArrayList<Entity> qualList = null;
		QualificationBean qual = null;
		try {
			qualList = new ArrayList<Entity>();
			
			String sql= "SELECT * FROM qual";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				qual = new QualificationBean();
				i++;
				qual.setSrNo(i);
				qual.setId(rs.getInt("qualid"));
				qual.setUsername(rs.getString("username"));
				qual.setSpecialization(rs.getString("specialization"));
				qual.setGradYear(rs.getString("grad_year"));
				qual.setSchoolName(rs.getString("school_name"));
				qualList.add(qual);
				
			}
			return qualList;	
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
	public ArrayList<Entity> getListbyUsername(String username) throws SQLException {
		ArrayList<Entity> qualList = null;
		QualificationBean qual = null;
		try {
			qualList = new ArrayList<Entity>();
			
			String sql= "SELECT * FROM qual where username=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				qual = new QualificationBean();
				i++;
				qual.setSrNo(i);
				qual.setId(rs.getInt("qualid"));
				qual.setUsername(rs.getString("username"));
				qual.setSpecialization(rs.getString("specialization"));
				qual.setGradYear(rs.getString("grad_year"));
				qual.setSchoolName(rs.getString("school_name"));
				qualList.add(qual);
				
			}
			return qualList;	
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
		}
		return null;
	}

}
