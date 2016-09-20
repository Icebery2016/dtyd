package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.entity.Project;
import com.entity.User;
import com.util.ConnectionUtils;


public class ProjectDao {
	
	public int getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count=0;
		String sql="select count(*) from t_user";
		try {
			con = ConnectionUtils.openConnection();
//			stmt = con.prepareStatement(findAll);
//			rs = stmt.executeQuery();
			pstmt = con.prepareStatement(sql);
		    rs = pstmt.executeQuery();
			while (rs.next()) {
				count=rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			ConnectionUtils.closeAllConnection(con, pstmt, rs);
		}
	}
	
	
	public List<User> findAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql="select * from t_user";
		try {
			con = ConnectionUtils.openConnection();
//			stmt = con.prepareStatement(findAll);
//			rs = stmt.executeQuery();
			pstmt = con.prepareStatement(sql);
		    rs = pstmt.executeQuery();
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setT_id(rs.getInt("t_id"));
				user.setT_name(rs.getString("t_name"));
				user.setT_email(rs.getString("t_email"));
				user.setT_inip(rs.getString("t_inip"));
				user.setT_outip(rs.getString("t_outip"));
				user.setT_mac(rs.getString("t_mac"));
				user.setT_dept(rs.getString("t_dept"));
				user.setT_team(rs.getString("t_team"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			ConnectionUtils.closeAllConnection(con, pstmt, rs);
		}
	}
	public List<Map<String, Object>> findByPage1(int start,int number) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int end =start+number;
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		String sql=" select f.* from (select t.*,rownum num from t_user t) f  where num between "+start+" and "+end;
		try {
			con = ConnectionUtils.openConnection();
//			stmt = con.prepareStatement(findAll);
//			rs = stmt.executeQuery();
			pstmt = con.prepareStatement(sql);
		    rs = pstmt.executeQuery();
		    ResultSetMetaData md = rs.getMetaData(); // 获得结果集结构信息,元数据
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));	
				}
				resultList.add(rowData);
			}
			
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			ConnectionUtils.closeAllConnection(con, pstmt, rs);
		}

	}
	
	public List<User> findByPage(int start,int number) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int end =start+number;
		String sql=" select f.* from (select t.*,rownum num from t_user t) f  where num between "+start+" and "+end;
		try {
			con = ConnectionUtils.openConnection();
//			stmt = con.prepareStatement(findAll);
//			rs = stmt.executeQuery();
			pstmt = con.prepareStatement(sql);
		    rs = pstmt.executeQuery();
			List<User> list = new ArrayList<User>();
			while (rs.next()) {
				User user = new User();
				user.setT_id(rs.getInt("t_id"));
				user.setT_name(rs.getString("t_name"));
				user.setT_email(rs.getString("t_email"));
				user.setT_inip(rs.getString("t_inip"));
				user.setT_outip(rs.getString("t_outip"));
				user.setT_mac(rs.getString("t_mac"));
				user.setT_dept(rs.getString("t_dept"));
				user.setT_team(rs.getString("t_team"));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			ConnectionUtils.closeAllConnection(con, pstmt, rs);
		}

	}

	public void addUser(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		String sql="insert into t_user(t_id,t_name,t_email,t_inip,t_outip,t_mac,t_dept,t_team)" +
			" values(?,?,?,?,?,?,?,?)";
		try {
			con = ConnectionUtils.openConnection();
//			stmt = con.prepareStatement(findAll);
//			rs = stmt.executeQuery();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,user.getT_id());
			pstmt.setString(2,user.getT_name());
			pstmt.setString(3,user.getT_email());
			pstmt.setString(4,user.getT_inip());
			pstmt.setString(5,user.getT_outip());
			pstmt.setString(6,user.getT_mac());
			pstmt.setString(7,user.getT_dept());
			pstmt.setString(8,user.getT_team());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			ConnectionUtils.closeAllConnection(con, pstmt);
		}

	}
	
	public void editUser(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		String sql="update t_user set t_name=?,t_email=?,t_inip=?,t_outip=?,t_mac=?,t_dept=?,t_team=? " +
			" where t_id=?";
		try {
			con = ConnectionUtils.openConnection();
//			stmt = con.prepareStatement(findAll);
//			rs = stmt.executeQuery();
			pstmt = con.prepareStatement(sql);			
			pstmt.setString(1,user.getT_name());
			pstmt.setString(2,user.getT_email());
			pstmt.setString(3,user.getT_inip());
			pstmt.setString(4,user.getT_outip());
			pstmt.setString(5,user.getT_mac());
			pstmt.setString(6,user.getT_dept());
			pstmt.setString(7,user.getT_team());
			pstmt.setInt(8,user.getT_id());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			ConnectionUtils.closeAllConnection(con, pstmt);
		}

	}


	public void removeUser(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtils.openConnection();
			pstmt = con
					.prepareStatement("delete from t_user where t_id=?");
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			ConnectionUtils.closeAllConnection(con, pstmt);
		}
	}
}
