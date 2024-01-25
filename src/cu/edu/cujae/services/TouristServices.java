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
				String contact, int country) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT insert_tourist(?,?,?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConexion();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, iD);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, lastName1);
        preparedStatement.setString(4, lastName2);
        preparedStatement.setInt(5, age);
        preparedStatement.setString(6, sex);
        preparedStatement.setString(7, contact);
        preparedStatement.setInt(8, country);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void delete_car(String seasonCode) throws SQLException, ClassNotFoundException{
		String query = "SELECT delete_car(?)";
		java.sql.Connection connection = ServicesLocator.getConexion();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, seasonCode);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	public void update_tourist(String iD, String name, String lastName1, String lastName2, int age, String sex,
				String contact, int country) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT update_tourist(?,?,?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConexion();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, iD);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, lastName1);
        preparedStatement.setString(4, lastName2);
        preparedStatement.setInt(5, age);
        preparedStatement.setString(6, sex);
        preparedStatement.setString(7, contact);
        preparedStatement.setInt(8, country);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	
	public ArrayList<TouristDTO> get_tourist_all() throws SQLException, ClassNotFoundException{
		ArrayList<TouristDTO> lodgings = new ArrayList<TouristDTO>();
		String function = "{?= call get_tourist_all()}";
		java.sql.Connection connection = ServicesLocator.getConexion();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			lodgings.add(new TouristDTO(rs.getString(1), rs.getString(2),rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8) ));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return lodgings;
	}
	
	public TouristDTO findTourist(String passport) throws SQLException{
		TouristDTO t = null;
		String function = "{?=call get_tourist_by_passport(?)}";
		java.sql.Connection connection = ServicesLocator.getConexion();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.setString(2, passport);
		preparedFunction.execute();
		ResultSet result = (ResultSet) preparedFunction.getObject(1);
		if(result.next())
		t = getData(result);
		result.close();
		preparedFunction.close();
		connection.close();
		return t;
	}

	private TouristDTO getData(ResultSet result) throws SQLException{
		String id = result.getString(1);
		String name= result.getString(2);
		String lastName1 = result.getString(3);
		String lastName2 = result.getString(4);
		int age = result.getInt(5);
		String sex = result.getString(6);
		String contact = result.getString(7);
		int country = result.getInt(8) ;
        return new TouristDTO(id, name, lastName1, lastName2, age, sex, contact, country);
    }
	
}
