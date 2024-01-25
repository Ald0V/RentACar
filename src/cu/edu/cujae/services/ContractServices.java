package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import cu.edu.cujae.dto.ContractDTO;

public class ContractServices {
    public String convertIfNull(String value){
        
        if(value == null)
            value = "0";
        
        return value;
    }
    
    public String ConvertIfCero(int number){
        String  value = "";
        
        if(number == 0)
        return value;
        
        return String.valueOf(number);
            
    }

    public String ConvertIfCero(String number){
        String value = "";

        if (number.equals("0")) {
            return value;
        } else {
            return number;
        }
            
    }

    public void DeleteContract(int contract_code){
        try {
        java.sql.Connection connection = ServicesLocator.getConexion();
        String proCall = "{call delete_contract(?)}";
        CallableStatement statement = connection.prepareCall(proCall);
        statement.setInt(1, contract_code);
        statement.execute();
        statement.close();
	connection.close();
        }catch (SQLException e){
            e.printStackTrace();
	}
    }

    public void contract_open(String plate, LocalDate start_date, String passport,LocalDate end_date, int pay_method, String dni) throws SQLException, ClassNotFoundException{
        String query = "SELECT business_contract_open(?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConexion();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, plate);
        preparedStatement.setDate(2, (java.sql.Date) new Date(start_date.toEpochDay()));
        preparedStatement.setString(3, passport);
        preparedStatement.setDate(4, (java.sql.Date) new Date(end_date.toEpochDay()));
        preparedStatement.setInt(5, pay_method);
        preparedStatement.setString(6, dni);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
    }

    public void contract_close(String plate, LocalDate start_date, LocalDate delivery_date, int end_km) throws SQLException, ClassNotFoundException{
        String query = "SELECT business_contract_open(?,?,?,?,?,?)";
		java.sql.Connection connection = ServicesLocator.getConexion();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, plate);
        preparedStatement.setDate(2, (java.sql.Date) new Date(start_date.toEpochDay()));
        preparedStatement.setDate(3, (java.sql.Date) new Date(delivery_date.toEpochDay()));
        preparedStatement.setInt(4, end_km);
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
    }

    public ArrayList<ContractDTO> selectAllContract() throws SQLException, ClassNotFoundException{
		ArrayList<ContractDTO> lodgings = new ArrayList<ContractDTO>();
		String function = "{?= call get_contract_all()}";
		java.sql.Connection connection = ServicesLocator.getConexion();
		connection.setAutoCommit(false);
		CallableStatement preparedFunction = connection.prepareCall(function);
		preparedFunction.registerOutParameter(1, java.sql.Types.OTHER);
		preparedFunction.execute();
		ResultSet rs = (ResultSet) preparedFunction.getObject(1);
		while (rs.next()){
			//lodgings.add(new ContractDTO(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6)));
		}
		rs.close();
		preparedFunction.close();
		connection.close();
		return lodgings;
	}

	
}