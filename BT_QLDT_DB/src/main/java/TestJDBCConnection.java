import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCConnection {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost/trainingmanager", "root", "Abcd@1234");

			stmt = conn.createStatement();

			String sql = "Select * from classroom";

			rs = stmt.executeQuery(sql);
			System.out.printf("%-5s%-15s%-20s", "ID", "Class name", "Created by");
			while (rs.next()) {
				Long id = rs.getLong("id");
				String name = rs.getString("name");
				String createdBy = rs.getString("created_by");

				System.out.printf("\n%-5s%-15s%-20s", id, name, createdBy);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
