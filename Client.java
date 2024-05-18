package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Client extends JDBC {

	public Client() throws SQLException {
		super();
		
	}
	 public Boolean selectClient(String username, String password) throws SQLException, ClassNotFoundException {
	        PreparedStatement preparedStatement = null;
	        String query = "SELECT * FROM clients WHERE nom = ? AND password = ?";

	        try {
	            preparedStatement = getConnection().prepareStatement(query);
	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	            resultSet = preparedStatement.executeQuery();
	            
	            while (resultSet.next()) {
	               
	                return true;
	            }

	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (resultSet != null) {
	                resultSet.close();
	            }
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        }

	        return false;
	    }

	 public static boolean insertClient(String username, String password,String email,String tele , String adresse) {
	        boolean userInserted = false;
	        PreparedStatement preparedStatement = null;
	        String query = "INSERT INTO clients (nom, password,email,telephone,adresse) VALUES (?, ? , ? , ? , ?)";

	        try {
	            preparedStatement = getConnection().prepareStatement(query);
	              

	            preparedStatement.setString(1, username);
	            preparedStatement.setString(2, password);
	            preparedStatement.setString(3, email);
	            preparedStatement.setString(4, tele);
	            preparedStatement.setString(5, adresse);
	           
	            int rowsAffected = preparedStatement.executeUpdate();
	            userInserted = rowsAffected > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return userInserted;
	    }
}
