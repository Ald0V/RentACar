package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.dto.DriverDTO;
import cu.edu.cujae.dto.TouristDTO;

public class DriverServices {
    public void insert_driver(String iD, String name, String lastName1, String lastName2, int category, String address) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT insert_driver(?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, iD);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, lastName1);
        preparedStatement.setString(4, lastName2);
        preparedStatement.setInt(5, category);
        preparedStatement.setString(6, address);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void delete_driver(int seasonCode) throws SQLException, ClassNotFoundException{
		String query = "SELECT delete_driver(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, seasonCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void update_driver(String iD, String name, String lastName1, String lastName2, int category, String address) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT update_driver(?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, iD);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, lastName1);
        preparedStatement.setString(4, lastName2);
        preparedStatement.setInt(5, category);
        preparedStatement.setString(6, address);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	
	public ArrayList<DriverDTO> get_driver_all() throws SQLException, ClassNotFoundException{
		ArrayList<DriverDTO> lodgings = new ArrayList<DriverDTO>();
		String function = "{?= call get_driver_all()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			lodgings.add(new DriverDTO(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return lodgings;
	}
	
}
