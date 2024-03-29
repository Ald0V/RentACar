package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.dto.AuxiliaryDTO;

public class BrandServices {
    public void insert_brand(String name) throws SQLException, ClassNotFoundException{
    String query = "SELECT insert_brand(?)";
    java.sql.Connection connection = ServicesLocator.getConexion();
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, name);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
}

public void delete_brand(String name) throws SQLException, ClassNotFoundException{
    String query = "SELECT delete_brand(?)";
    java.sql.Connection connection = ServicesLocator.getConexion();
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, name);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
}

public ArrayList<AuxiliaryDTO> get_brand_all() throws SQLException, ClassNotFoundException{
    ArrayList<AuxiliaryDTO> lodgings = new ArrayList<AuxiliaryDTO>();
    String function = "{?= call get_brand_all()}";
    java.sql.Connection connection = ServicesLocator.getConexion();
    connection.setAutoCommit(false);
    CallableStatement preparedFunction = connection.prepareCall(function);
    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
    preparedFunction.execute();
    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
    while (rs.next()){
        lodgings.add(new AuxiliaryDTO(rs.getInt(1), rs.getString(2)));
    }
    rs.close();
    preparedFunction.close();
    connection.close();
    return lodgings;
}

public String get_brand_by_id (int id)throws SQLException, ClassNotFoundException{
    String brand = null;
    
    String function = "{?= call get_brand_by_id(?)}";
    java.sql.Connection connection = ServicesLocator.getConexion();
    connection.setAutoCommit(false);
    CallableStatement preparedFunction = connection.prepareCall(function);
    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
    preparedFunction.setInt(2,id);
    preparedFunction.execute();
    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
    while (rs.next()){
        brand = rs.getString(1);
    }
    rs.close();
    preparedFunction.close();
    connection.close();
    
    return brand;
    
}

public int get_brand_by_name(String name) throws SQLException, ClassNotFoundException {
    int id = 0;

    String function = "{?= call get_brand_by_name(?)}";
    java.sql.Connection connection = ServicesLocator.getConexion();
    connection.setAutoCommit(false);
    CallableStatement preparedFunction = connection.prepareCall(function);
    preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
    preparedFunction.setString(2, name);
    preparedFunction.execute();
    ResultSet rs = (ResultSet) preparedFunction.getObject(1);
    while (rs.next()){
        id = rs.getInt(1);
    }
    rs.close();
    preparedFunction.close();
    connection.close();

    return id;
}


public void update_brand(int id, String name) 
	      throws SQLException, ClassNotFoundException{
	    String query = "SELECT update_brand(?, ?)";
	    java.sql.Connection connection = ServicesLocator.getConexion();
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setInt(1, id);
	    preparedStatement.setString(2, name);
	    preparedStatement.execute();
	    preparedStatement.close();
	    connection.close();
	  }

    
}
