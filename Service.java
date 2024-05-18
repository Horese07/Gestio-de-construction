package models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

public class Service extends JDBC{
    public Service() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	private int idService;
    private String nomService;
    private String description;
    private String imageService;

    // Getters and setters
    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageService() {
        return imageService;
    }

    public void setImageService(String imageService) {
        this.imageService = imageService;
    }
    
    public Boolean InserService(String name , String email , String service , String message ) throws SQLException, ParseException, ClassNotFoundException {
		  
	    String query = "INSERT INTO demandes (nomclient, email, message, service) " +
	                   "VALUES (?, ?, ?, ?)";
	  
	    System.out.println("Je suis en train d'insérer");

	    try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, message); 
            preparedStatement.setString(4, service);
           

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Nombre de lignes affectées : " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
