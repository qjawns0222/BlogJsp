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
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private ArrayList<boardVO> list ;// VO배열
	private boardVO tmp;// VO변수
	private int result;// 결과 기준점

	private BoardDAO() {
		list = new ArrayList<boardVO>();
		result = -1;
		tmp=new boardVO();
	}

	private String sql = null;

	public static BoardDAO getInstance() { // 싱글톤
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

	public List<boardVO> selectBoardAll() {
		// 전체 검색
		try {
			list = new ArrayList<boardVO>();
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
		try {
			result = -1;//실패
			conn = connutil.getConnection();
			String sql = "insert into blogboard values(?,blogboard_seq.nextval,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, info.getId());
			pstmt.setString(2, info.getTitle());
			pstmt.setString(3, info.getContent());
			result = pstmt.executeUpdate();
			result = 1;//성공
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

}
