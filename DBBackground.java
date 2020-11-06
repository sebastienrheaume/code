package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class DBBackground {
	private static final String JBDC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static Connection connection = null;
	private static final String connStr = "jdbc:mysql://lessonplus.com:3306/lessonpl_uniform?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

	// Opens a connection to the database
	public static void dbConnect() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(JBDC_DRIVER);
		} catch (ClassNotFoundException e) {
			throw e;
		}

		try {
			connection = DriverManager.getConnection(connStr, "lessonpl_pa", "Uniform123");
		} catch (SQLException e) {
			throw e;
		}
	}

	// Closes the connection if it is open
	public static void dbDisconnect() throws SQLException {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// To add, modify and delete from the database
	public static void dbExecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException {
		Statement stmt = null;

		try {
			dbConnect();
			stmt = connection.createStatement();
			stmt.executeUpdate(sqlStmt);
		} catch (SQLException e) {
			throw e;
		} finally {
			if (stmt != null)
				stmt.close();
		}
		dbDisconnect();
	}

	// Read and show information from the database
	public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		CachedRowSet crs = null;

		try {
			dbConnect();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlQuery);

			crs = new CachedRowSetImpl();
			crs.populate(rs);

		} catch (SQLException e) {
			throw e;
		} finally {
			if (rs != null) {
				rs.close();

			}
			if (stmt != null) {
				stmt.close();
			}

			dbDisconnect();
		}
		return crs;
	}
}
