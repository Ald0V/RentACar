package cu.edu.cujae.services;

import java.sql.CallableStatement;
import java.sql.SQLException;

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

    
	
}
