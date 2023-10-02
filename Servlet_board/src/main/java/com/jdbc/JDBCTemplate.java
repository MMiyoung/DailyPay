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
			// ����̹� ����
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost/boardtest?serverTimezone=Asia/Seoul";
		String user = "root";
		String passwd = "aldud9262!";

		Connection con = null;

		try {
			// ��������
			con = DriverManager.getConnection(url, user, passwd);
			//con.setAutoCommit(false);

		} catch (SQLException e) {
			// �������� ����
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

	// ������� ���� Ȯ�� �� close
	public static void close(Connection con) {
		if (isConnection(con)) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// stmt�� null�� �ƴ� �� close
	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	// pstm�� null�� �ƴ� �� close
	public static void close(PreparedStatement pstm) {
		if (pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// rs�� null�� �ƴ� �� close
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// ������¸� commit
	public static void commit(Connection con) {
		if (isConnection(con)) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// ������¸� rollback
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
