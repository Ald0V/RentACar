package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import cu.edu.cujae.dto.ModelDTO;

public class ModelServices {
    public void insert_model(String name, int brand) throws SQLException, ClassNotFoundException{
    String query = "SELECT insert_model(?, ?)";
    java.sql.Connection connection = ServicesLocator.getConexion();
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, name);
    preparedStatement.setInt(2, brand);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
}

public void delete_model(String name) throws SQLException, ClassNotFoundException{
    String query = "SELECT delete_model(?)";
    java.sql.Connection connection = ServicesLocator.getConexion();
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, name);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
}

public ArrayList<ModelDTO> get_model_all() throws SQLException, ClassNotFoundException{
    ArrayList<ModelDTO> lodgings = new ArrayList<ModelDTO>();
    String function = "{?= call get_model_all()}";
    java.sql.Connection connection = ServicesLocator.getConexion();
    connection.setAutoCommit(false);
    CallableStatement preparedFunction = connection.prepareCall(function);
    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
    preparedFunction.execute();
    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
    while (rs.next()){
        lodgings.add(new ModelDTO(rs.getInt(1), rs.getInt(2), rs.getString(3)));
    }
    rs.close();
    preparedFunction.close();
    connection.close();
    return lodgings;
}

public LinkedList<ModelDTO> select_model_by_brand(String brand) throws SQLException {
    LinkedList<ModelDTO> List = new LinkedList<ModelDTO>();
    java.sql.Connection connection = ServicesLocator.getConexion();
    String sql = "SELECT model.*, brand.id " +
    		"FROM model INNER JOIN brand ON model.brand_id = brand.id " +
    		"WHERE brand.name = ?;";

    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, brand);
    statement.execute();
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
    	  ModelDTO c = new ModelDTO(resultSet.getInt("id"),
    	                    resultSet.getInt("id"),
    	                    resultSet.getString("name"));

    	  List.add(c);
    	}

    resultSet.close();
    statement.close();

    return List;
}

public String get_model_by_id (int id)throws SQLException, ClassNotFoundException{
    String model = null;
    
    String function = "{?= call get_model_by_id(?)}";
    java.sql.Connection connection = ServicesLocator.getConexion();
    connection.setAutoCommit(false);
    CallableStatement preparedFunction = connection.prepareCall(function);
    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
    preparedFunction.setInt(2,id);
    preparedFunction.execute();
    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
    while (rs.next()){
        model = rs.getString(1);
    }
    rs.close();
    preparedFunction.close();
    connection.close();
    
    return model;
    
}

public void update_model(int brand, int id, String name) 
	      throws SQLException, ClassNotFoundException{
	    String query = "SELECT update_model(?, ?, ?)";
	    java.sql.Connection connection = ServicesLocator.getConexion();
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setInt(1, brand);
	    preparedStatement.setInt(2, id);
	    preparedStatement.setString(3, name);
	    preparedStatement.execute();
	    preparedStatement.close();
	    connection.close();
	  }
    
}
