package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import cu.edu.cujae.dto.CarDTO;

public class CarServices {
    public void insert_car(String plate, int brand, int model, int km, String color, int situation) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT insert_car(?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, plate);
        preparedStatement.setInt(2, brand);
        preparedStatement.setInt(3, model);
        preparedStatement.setInt(4, km);
        preparedStatement.setString(5, color);
        preparedStatement.setInt(6, situation);
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
	
	public void update_car(String plate, int brand, int model, int km, String color, int situation) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT update_car(?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, plate);
        preparedStatement.setInt(2, brand);
        preparedStatement.setInt(3, model);
        preparedStatement.setInt(4, km);
        preparedStatement.setString(5, color);
        preparedStatement.setInt(6, situation);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	
	public ArrayList<CarDTO> selectAllSeasons() throws SQLException, ClassNotFoundException{
		ArrayList<CarDTO> lodgings = new ArrayList<CarDTO>();
		String function = "{?= call select_all_season()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			lodgings.add(new CarDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return lodgings;
	}
}
