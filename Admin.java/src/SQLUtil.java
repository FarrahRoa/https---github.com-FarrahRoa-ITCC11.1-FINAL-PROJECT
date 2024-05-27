import java.sql.*;

public class SQLUtil {
    public static Connection connect() {
        Connection connection = null;
        try {
            // Modify the URL, username, and password as per your database configuration
            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "Naruto12-";
            
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

	public static Connection connect(String username, String password) {
        Connection connection = null;
        try {
            // Modify the URL as per your database configuration
            String url = "jdbc:mysql://localhost:3306/library";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
	public static void displayTable(Connection connection,String tableName) {
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from "+tableName);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " , " + rs.getString(2) + " , " + rs.getString(3));
			}
			statement.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}

	}

	public static void resetAutoIncrement(Connection connection, String query) {
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("Max id = " + resultSet.getInt(1));
			}
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	public static void insertToTable(Connection connection, String query) {
		try {
			Statement statement = connection.createStatement();
			int n = statement.executeUpdate(query);
			System.out.println("Query OK," + n + " rows affected");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void DeleteTable(Connection connection, String query) {
		try {
			Statement statement = connection.createStatement();
			int n = statement.executeUpdate(query);
			System.out.println("Query OK," + n + " rows affected");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void DDLQuery(Connection connection, String query) {
		try {
			Statement statement = connection.createStatement();
			statement.execute(query);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}
	public static void DMLQuery(Connection connection, String query) {
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	
}
