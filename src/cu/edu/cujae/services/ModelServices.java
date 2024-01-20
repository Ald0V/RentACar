package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cu.edu.cujae.dto.ModelDTO;

public class ModelServices {
    public void insert_model(int brand, String name) throws SQLException, ClassNotFoundException{
    String query = "SELECT insert_model(?, ?)";
    java.sql.Connection connection = ServicesLocator.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setInt(1, brand);
    preparedStatement.setString(2, name);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
}

public void delete_model(String name) throws SQLException, ClassNotFoundException{
    String query = "SELECT delete_model(?)";
    java.sql.Connection connection = ServicesLocator.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, name);
    preparedStatement.execute();
    preparedStatement.close();
    connection.close();
}

public ArrayList<ModelDTO> get_model_all() throws SQLException, ClassNotFoundException{
    ArrayList<ModelDTO> lodgings = new ArrayList<ModelDTO>();
    String function = "{?= call get_model_all()}";
    java.sql.Connection connection = ServicesLocator.getConnection();
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

    
}
