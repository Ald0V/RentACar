package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import cu.edu.cujae.dto.UserDTO;

public class UserServices {
    public void insert_user(String username, String email, String password, String rol) 
			throws SQLException, ClassNotFoundException{
		String query = "SELECT insert_user(?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConexion();
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
		java.sql.Connection connection = ServicesLocator.getConexion();
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
		java.sql.Connection connection = ServicesLocator.getConexion();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			lodgings.add(new UserDTO(rs.getInt(1), rs.getString(1),rs.getString(1),rs.getString(1),rs.getString(1)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return lodgings;
	}
	
	public UserDTO findUser(String name) throws SQLException{
		UserDTO u = null;
		String function = "{?=call get_user_by_username(?)}";
		java.sql.Connection connection = ServicesLocator.getConexion();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.setString(2, name);
		preparedFunction.execute();
		ResultSet result = (ResultSet) preparedFunction.getObject(1);
		if(result.next())
		u = getData(result);
		result.close();
		preparedFunction.close();
		connection.close();
		return u;
	}

	private UserDTO getData(ResultSet result) throws SQLException{
		int id = result.getInt(1);
		String name = result.getString(2);
		String email = result.getString(3);
        String password = result.getString(4);
		String rol = result.getString(5);
        return new UserDTO(id, name, email, password, rol);
    }

	public void delete_user(int id) throws SQLException, ClassNotFoundException{
		String query = "SELECT delete_user(?)";
		java.sql.Connection connection = ServicesLocator.getConexion();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}

	public  LinkedList<UserDTO> findTheUser(String username) throws SQLException{
		LinkedList<UserDTO> List = new LinkedList<UserDTO>();
        java.sql.Connection connection = ServicesLocator.getConexion();
        String sql = "SELECT user.*" +
        "FROM user" +
        "WHERE user.username = '?;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.execute();
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			UserDTO c = new UserDTO(resultSet.getInt("id"),
					              resultSet.getString("username"),
								  resultSet.getString("email"),
								  resultSet.getString("password"),
								  resultSet.getString("rol"));

			List.add(c);
		}
		resultSet.close();
		statement.close();
		
		return List;
	}

}