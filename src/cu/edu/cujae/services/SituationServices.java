package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.dto.AuxiliaryDTO;

public class SituationServices {
    public void insert_situation(String name) throws SQLException, ClassNotFoundException{
    String query = "SELECT insert_situation(?)";
    java.sql.Connection connection = ServicesLocator.getConexion();
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, name);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
}

public void delete_situation(String name) throws SQLException, ClassNotFoundException{
    String query = "SELECT delete_situation(?)";
    java.sql.Connection connection = ServicesLocator.getConexion();
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, name);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
}

public ArrayList<AuxiliaryDTO> get_situation_all() throws SQLException, ClassNotFoundException{
    ArrayList<AuxiliaryDTO> lodgings = new ArrayList<AuxiliaryDTO>();
    String function = "{?= call get_situation_all()}";
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

public String get_situation_by_id (int id)throws SQLException, ClassNotFoundException{
	String situation = null;

	String function = "{?= call get_situation_by_id(?)}";
	java.sql.Connection connection = ServicesLocator.getConexion();
	connection.setAutoCommit(false);
	CallableStatement preparedFunction = connection.prepareCall(function);
	preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
	preparedFunction.setInt(2,id);
	preparedFunction.execute();
	ResultSet rs = (ResultSet) preparedFunction.getObject(1);
	while (rs.next()){
		situation = rs.getString(1);
	}
	rs.close();
	preparedFunction.close();
	connection.close();

	return situation;
}
    
}
