package cu.edu.cujae.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connec {
	private static java.sql.Connection connection;

	  public Connec(String serveraddres, String database, String user,String pass) throws ClassNotFoundException, SQLException {

	      Class.forName("org.postgresql.Driver");
	      String url = "jdbc:postgresql://" + serveraddres + ":5433/"+ database;
	      connection = DriverManager.getConnection(url, user, pass);
	  }

	   public java.sql.Connection getConnection() {
	    return connection;
	  }


}
