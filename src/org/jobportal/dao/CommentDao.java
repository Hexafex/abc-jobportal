package org.jobportal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.jobportal.bean.CommentBean;
import org.jobportal.bean.Entity;

public class CommentDao extends DBConnection implements DaoInterface {

	@Override
	public boolean insert(Entity e) throws SQLException {
		int ctr;
		boolean isAdded=false;
		CommentBean comment= (CommentBean) e;
		try {
			String sql="INSERT INTO comments(username,commentmsg,postid) VALUES (?,?,?)";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, comment.getUsername());
			ps.setString(2, comment.getMsgContent());
			ps.setInt(3, comment.getPostId());
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
		CommentBean comment= (CommentBean) e;
		try {
			String sql="UPDATE comments SET commentmsg=? WHERE commentid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, comment.getMsgContent());
			ps.setInt(2, comment.getId());
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
	} return false;
}

	@Override
	public boolean delete(Entity e) throws SQLException {
		int ctr;
		boolean isDeleted = false;
		CommentBean comment= (CommentBean) e;
		try{
			String sql="DELETE FROM comments WHERE commentid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setInt(1,comment.getId());
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
		CommentBean comment =null;
		try {
			String sql= "SELECT * FROM comments";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				comment = new CommentBean();
				comment.setId(rs.getInt("commentid"));
				comment.setPostId(rs.getInt("postid"));
				comment.setUsername(rs.getString("username"));
				comment.setMsgContent(rs.getString("commentmsg"));
			}
			return comment;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Entity> getAll() throws SQLException {
		ArrayList<Entity> commentList= null;
		CommentBean comment= null;
		try {
			commentList = new ArrayList<Entity>();
			String sql= "SELECT * FROM comments";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				comment = new CommentBean();
				comment.setPostId(rs.getInt("postid"));
				comment.setId(rs.getInt("commentid"));
				comment.setUsername(rs.getString("username"));
				comment.setMsgContent(rs.getString("commentmsg"));
				commentList.add(comment);
			}
			return commentList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if(getConnection()!=null) {
				getConnection().close();
			}
		}
		return null;
	}

	public ArrayList<Entity> getAllByPostId(int postId) throws SQLException {
		ArrayList<Entity> commentList= null;
		CommentBean comment= null;
		try {
			commentList = new ArrayList<Entity>();
			String sql= "SELECT * FROM comments WHERE postid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setInt(1, postId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				comment = new CommentBean();
				comment.setPostId(rs.getInt("postid"));
				comment.setId(rs.getInt("commentid"));
				comment.setUsername(rs.getString("username"));
				comment.setMsgContent(rs.getString("commentmsg"));
				commentList.add(comment);
			}
			return commentList;
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
		ArrayList<Entity> commentList= null;
		CommentBean comment= null;
		try {
			commentList = new ArrayList<Entity>();
			String sql= "SELECT * FROM comments WHERE postid=?";
			PreparedStatement ps=getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				comment = new CommentBean();
				comment.setPostId(rs.getInt("postid"));
				comment.setId(rs.getInt("commentid"));
				comment.setUsername(rs.getString("username"));
				comment.setMsgContent(rs.getString("commentmsg"));
				commentList.add(comment);
			}
			return commentList;
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
