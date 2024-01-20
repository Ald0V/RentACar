package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.dto.UserDTO;

public class UserServices {
    public void insert_user(String username, String email, String password, String rol) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT insert_user(?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, username);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, rol);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	
	public void update_user(String username, String email, String password, String rol) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT update_user(?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, username);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, rol);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}
	
	
	public ArrayList<UserDTO> get_user_all() throws SQLException, ClassNotFoundException{
		ArrayList<UserDTO> lodgings = new ArrayList<UserDTO>();
		String function = "{?= call get_user_all()}";
		java.sql.Connection connection = ServicesLocator.getConnection();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			lodgings.add(new UserDTO(rs.getString(1), rs.getString(1),rs.getString(1),rs.getString(1),rs.getString(1)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return lodgings;
	}

}

