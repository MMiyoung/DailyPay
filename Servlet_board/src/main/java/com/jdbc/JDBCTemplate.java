package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	
	public static Connection getConnection() {
		try {
			// 드라이버 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost/boardtest?serverTimezone=Asia/Seoul";
		String user = "root";
		String passwd = "aldud9262!";

		Connection con = null;

		try {
			// 계정연결
			con = DriverManager.getConnection(url, user, passwd);
			//con.setAutoCommit(false);

		} catch (SQLException e) {
			// 계정연결 실패
			e.printStackTrace();
		}
		return con;

	}

	public static boolean isConnection(Connection con) {
		boolean valid = true;

		try {
			if (con == null || con.isClosed()) {
				valid = false;
			}
		} catch (SQLException e) {
			valid = true;
			e.printStackTrace();
		}
		return valid;
	}

	// 연결상태 여부 확인 후 close
	public static void close(Connection con) {
		if (isConnection(con)) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// stmt가 null이 아닐 때 close
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	// pstm가 null이 아닐 때 close
	public static void close(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// rs가 null이 아닐 때 close
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 연결상태면 commit
	public static void commit(Connection con) {
		if (isConnection(con)) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 연결상태면 rollback
	public static void rollback(Connection con) {
		if (isConnection(con)) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


}
