package web.unstop.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web.unstop.util.connutil;

public class loginDAO {
	private static loginDAO instance = null;

	private loginDAO() {
	}

	public static loginDAO getinstance() {
		if (instance == null) {
			synchronized (loginDAO.class) {
				instance = new loginDAO();
			}
		}
		return instance;
	}

	public int login(loginVO info) {

		ResultSet rs = null;
		int result = -1;
		try {
			loginVO che= selectpass(info.getId());
			if (che!=null) {
				if (che.getPass().equals(info.getPass())) {
					//로그인성공
					result = 2;
				} else {
					//비밀번호 틀림
					result = 1;
				}
			} else {
				//아이디가 없음
				result = 0;
			}
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
		}
		return result;

	}

	public int creuser(loginVO info) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = connutil.getConnection();
			String sql = "insert into bloglogin values(?,?)";
			int check = login(info);
			if (check == 0) {
				//생성성공
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, info.getId());
				pstmt.setString(1, "zzz2");
				pstmt.setString(2, info.getPass());
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, info.getId());
				pstmt.setString(1, "zzz1");
				pstmt.setString(2, info.getPass());
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, info.getId());
				pstmt.setString(1, "zzz3");
				pstmt.setString(2, info.getPass());
				pstmt.executeUpdate();
				result = 1;
			} else {
				//아이디 중복
				result = 2;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return result;

	}

	public loginVO selectpass(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = connutil.getConnection();
			pstmt = conn.prepareStatement("select pass from bloglogin where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				//존재함
				loginVO info=new loginVO();
				info.setPass(rs.getString(1));
				
				return info;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return null;
	}

	public int deleteUser(String id, String pass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		try {
			loginVO che = selectpass(id);
			if (che!=null) {
				if (che.getPass().equals(pass)) {
					//비번 일치
					conn = connutil.getConnection();
					pstmt = conn.prepareStatement("delete from bloglogin where id=?");
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					result = 1;
				}else{
					//비번틀림
					result=0;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return result;

	}

	public int updateUser(loginVO info,String newpass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			loginVO che=selectpass(info.getId());
			if (che!=null) {
				if (che.getPass().equals(info.getPass())) {
						conn = connutil.getConnection();
						pstmt = conn.prepareStatement("update bloglogin set pass=? where id=?");
						pstmt.setString(1, newpass);
						pstmt.setString(2, info.getId());
						pstmt.executeUpdate();
						result = 1;
					}else {
						result = 2;
						// 비번 틀림
					}
				} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
				}
		}
		return result;
	}

}
