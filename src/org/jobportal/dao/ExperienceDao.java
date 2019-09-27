package org.jobportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jobportal.bean.Entity;
import org.jobportal.bean.ExperienceBean;


public class ExperienceDao extends DBConnection implements DaoInterface {

	@Override
	public boolean insert(Entity e) throws SQLException {
		int ctr;
		boolean isAdded = false;
		
		ExperienceBean userExp=(ExperienceBean) e;
		
			try {
				String sql="INSERT INTO exp(username,years_of_exp,job_title,company_name) VALUES (?,?,?,?)";
				PreparedStatement ps=getConnection().prepareStatement(sql);
				ps.setString(1, userExp.getUsername());
				ps.setString(2, userExp.getYearsOfExp());
				ps.setString(3, userExp.getJobTitle());
				ps.setString(4, userExp.getCompanyName());

				ctr=ps.executeUpdate();
				
				if(ctr>0) {
					isAdded=true;
				}
				return isAdded;
			}
			catch(SQLException ex){
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
		ExperienceBean userExp=(ExperienceBean) e;
			try {
				String sql="UPDATE exp SET username =?,years_of_exp=?,job_title=?,company_name=? WHERE expid=?";
				PreparedStatement ps=getConnection().prepareStatement(sql);
				ps.setString(1, userExp.getUsername());
				ps.setString(2, userExp.getYearsOfExp());
				ps.setString(3, userExp.getJobTitle());
				ps.setString(4, userExp.getCompanyName());
				ps.setInt(5, userExp.getId());
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
		ExperienceBean userExp=(ExperienceBean) e;
		try{
			String sql="DELETE FROM exp WHERE expid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setInt(1,userExp.getId());
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
		// TODO Auto-generated method stub This method unused for this class
		return null;
	}

	@Override
	public Entity getEntityById(int id) throws SQLException {
		ResultSet rs = null;
		ExperienceBean exp = null;
		try{
			String sql="SELECT * FROM exp WHERE expid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next()) {
				exp = new ExperienceBean();
				exp.setId(rs.getInt("expid"));
				exp.setUsername(rs.getString("username"));
				exp.setCompanyName(rs.getString("company_name"));
				exp.setJobTitle(rs.getString("job_title"));
				exp.setYearsOfExp(rs.getString("years_of_exp"));	
			}
			return exp;
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
		ArrayList<Entity> expList = null;
		ExperienceBean exp = null;
		try {
			expList = new ArrayList<Entity>();
			
			String sql= "SELECT * FROM exp";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				exp = new ExperienceBean();
				i++;
				exp.setSrNo(i);
				exp.setId(rs.getInt("expid"));
				exp.setUsername(rs.getString("username"));
				exp.setYearsOfExp(rs.getString("years_of_exp"));
				exp.setJobTitle(rs.getString("job_title"));
				exp.setCompanyName(rs.getString("company_name"));
				expList.add(exp);
				
			}
			return expList;	
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
		ArrayList<Entity> expList = null;
		ExperienceBean exp = null;
		try {
			expList = new ArrayList<Entity>();
			
			String sql= "SELECT * FROM exp where username=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				exp = new ExperienceBean();
				i++;
				exp.setSrNo(i);
				exp.setId(rs.getInt("expid"));
				exp.setUsername(rs.getString("username"));
				exp.setYearsOfExp(rs.getString("years_of_exp"));
				exp.setJobTitle(rs.getString("job_title"));
				exp.setCompanyName(rs.getString("company_name"));
				expList.add(exp);
				
			}
			return expList;	
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
