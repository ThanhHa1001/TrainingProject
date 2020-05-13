package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	public static void main(String[] args) {
		// JDBC driver name and database URL
//		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String DB_URL = "jdbc:mysql://localhost/company";

		// Database credentials
		String USER = "root";
		String PASS = "Abcd@1234";
		Connection conn = null;
		Statement stmt = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			stmt = conn.createStatement();

//			String sql = "CREATE SCHEMA company DEFAULT CHARACTER SET utf8 COLLATE utf8_bin";
			String sql = "SELECT Employees.id, Employees.name, sum(Salary.amount) " + 
					"From Employees, Salary " + 
					"Where Employees.id = Salary.employee_id " + 
					"Group By Salary.employee_id ";
			
			ResultSet resultSet = stmt.executeQuery(sql);
			System.out.println(String.format("%-15s%-30s%-35s", "ID", "Name", "Salary"));
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				float salary = resultSet.getFloat(3);
				String info = String.format("%-15s%-30s%.0f", id, name, salary );
				System.out.println(info);
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();

				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}
}
