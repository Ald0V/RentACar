package utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	private static java.sql.Connection connection;

	public Connection(String serveraddres, String database, String user,String pass) throws ClassNotFoundException, SQLException {

			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://" + "localhost" + ":5433/"+ "JDBC";
			connection = DriverManager.getConnection(url, "postgres", "postgres");
	}

	 public java.sql.Connection getConnection() {
		return connection;
	}


}
