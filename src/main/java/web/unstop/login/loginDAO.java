package web.unstop.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.unstop.util.connutil;

public class loginDAO {
	private static loginDAO instance=null;
	private loginDAO() {}
	public static loginDAO getinstance() {
		if(instance==null) {
			synchronized(loginDAO.class) {
			instance=new loginDAO();
			}
		}
		return instance;
	}
	public int login(loginVO info) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=-1;
		try {
			conn=connutil.getConnection();
			String sql="select pass from bloglogin where id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, info.getId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pass").equals(info.getPass())) {
					result=2;
				}else {
					result=1;
				}
			}else {
				result=0;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return result;
		
	}
	
	public int creuser(loginVO info) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			conn=connutil.getConnection();
			String sql="insert into bloglogin values(?,?)";
			int check=login(info);
			if(check!=2) {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, info.getId());
				pstmt.setString(2, info.getPass());
				pstmt.executeUpdate();
				result=1;
			}else{
				result=2;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try {rs.close();}catch(SQLException e) {}
			if(pstmt!=null)try {pstmt.close();}catch(SQLException e) {}
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return result;
		
	}

}
