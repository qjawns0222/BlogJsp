package web.unstop.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class connutil {
	private static DataSource ds;
	static {
		InitialContext in;
		try {
			in = new InitialContext();
			ds=(DataSource) in.lookup("java:comp/env/jdbc/myOracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

}
