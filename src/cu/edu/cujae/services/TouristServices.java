package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.dto.TouristDTO;

public class TouristServices {
    public void insert_tourist(String iD, String name, String lastName1, String lastName2, int age, String sex,
				String contact, String country) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT insert_tourist(?,?,?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, iD);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, lastName1);
        preparedStatement.setString(4, lastName2);
        preparedStatement.setInt(5, age);
        preparedStatement.setString(6, sex);
        preparedStatement.setString(7, contact);
        preparedStatement.setString(8, country);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void delete_car(int seasonCode) throws SQLException, ClassNotFoundException{
		String query = "SELECT delete_car(?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, seasonCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void update_tourist(String iD, String name, String lastName1, String lastName2, int age, String sex,
				String contact, String country) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT update_tourist(?,?,?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, iD);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, lastName1);
        preparedStatement.setString(4, lastName2);
        preparedStatement.setInt(5, age);
        preparedStatement.setString(6, sex);
        preparedStatement.setString(7, contact);
        preparedStatement.setString(8, country);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	
	public ArrayList<TouristDTO> get_tourist_all() throws SQLException, ClassNotFoundException{
		ArrayList<TouristDTO> lodgings = new ArrayList<TouristDTO>();
		String function = "{?= call get_tourist_all()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			lodgings.add(new TouristDTO(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8) ));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return lodgings;
	}
}
