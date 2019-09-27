package org.jobportal.dao;


import java.sql.*;
import java.util.ArrayList;

import org.jobportal.bean.Entity;

public interface DaoInterface {
	public boolean insert(Entity e)throws SQLException;
	public boolean update(Entity e)throws SQLException;
	public boolean delete(Entity e)throws SQLException;
	public Entity getEntityByUsername(String  username)throws SQLException;
	public Entity getEntityById(int  id)throws SQLException;
	public ArrayList<Entity> getAll()throws SQLException;
	public ArrayList<Entity> getListbyUsername(String username) throws SQLException;

}
