package web.unstop.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import web.unstop.util.connutil;

public class BoardDAO {
	private static BoardDAO instance = null;

	private BoardDAO() {

	}

	public static BoardDAO getInstance() { // �̱���
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	public List<boardVO> selectBoardAll() {
		// ��ü �˻�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boardVO tmp = null;
		ArrayList<boardVO> list = new ArrayList<boardVO>();
		try {

			conn = connutil.getConnection();
			String sql = "select * from blogboard order by num desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				tmp = new boardVO();
				tmp.setId(rs.getString(1));
				tmp.setNum(rs.getInt(2));
				tmp.setTitle(rs.getString(3));
				tmp.setContent(rs.getString(4));
				tmp.setCount(rs.getInt(5));
				list.add(tmp);
			}
			return list;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

		return list;
	}

	public int creBoard(boardVO info) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		try {
			result = -1;// ����
			conn = connutil.getConnection();
			String sql = "insert into blogboard values(?,blogboard_seq.nextval,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getId());
			pstmt.setString(2, info.getTitle());
			pstmt.setString(3, info.getContent());
			result = pstmt.executeUpdate();
			result = 1;// ����
			return result;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}
	public boardVO  selectBoard(int num) {//�Ѱ��˻�
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		boardVO info=new boardVO();
		try {
			
			conn = connutil.getConnection();
			String sql = "select * from blogboard where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				info.setId(rs.getString("id"));
				info.setTitle(rs.getString("title"));
				info.setContent(rs.getString("content"));
				info.setNum(rs.getInt("num"));
				info.setCount(rs.getInt("count"));
			}
			

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return info;
	}
	
	public int updateBoard(boardVO info) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result=0;//����
		
		
		try {
			
			conn = connutil.getConnection();
			String sql = "update blogboard set title=?,content=? where num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getTitle());
			pstmt.setString(2, info.getContent());
			pstmt.setInt(3, info.getNum());
			result=pstmt.executeUpdate();//����
		
			
			

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
		
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}
	public int deleteBoard(boardVO info) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result=0;//����
		
		
		try {
			
			conn = connutil.getConnection();
			boardVO che=selectBoard(info.getNum());
			if(che.getNum()==info.getNum()) {
				String sql = "delete from blogboard where num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, info.getNum());
				
				result=pstmt.executeUpdate();//����
			
			}
		
			
			

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
		
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return result;
	}

}
