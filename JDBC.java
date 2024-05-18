package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/gestionconst";
    private static final String USERNAME = "houcine";
    private static final String PASSWORD = "1234";
    protected ResultSetMetaData resultData;
    protected ResultSet resultSet;
    protected DefaultTableModel model;
 
    public JDBC() throws SQLException {
    	
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    
    
    public DefaultTableModel selectData(Connection connection, String query) throws SQLException {
        
       
        try (Statement statement = connection.createStatement()) {
            // Exécuter la requête SQL pour récupérer les données de la table
        	
            resultSet = statement.executeQuery(query);
            java.sql.ResultSetMetaData resultData = resultSet.getMetaData(); // Retrieve metadata while ResultSet is still open

            model = new DefaultTableModel();
            // Ajouter les colonnes au modèle de tableau
            int columnCount = resultData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(resultData.getColumnName(i));
            }

            // Ajouter les lignes au modèle de tableau
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return model;
    }


    
    public void insertData(Connection connection, String query) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
    
    public void closeResources(PreparedStatement preparedStatement, Object object) {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
    public static List<Projet> selectAllProjets(String nom) {
        List<Projet> projets = new ArrayList<>();
        String query = "SELECT * FROM projets WHERE client = ?";
        PreparedStatement preparedStatement = null;
     
      
	    try {
	        preparedStatement = getConnection().prepareStatement(query);
	        preparedStatement.setString(1, (String) nom);
             ResultSet resultSet = preparedStatement.executeQuery();
           
            while (resultSet.next()) {
               Projet projet = new Projet();
              
                projet.setNom(resultSet.getString("nomProjet"));
                projet.setAdresse(resultSet.getString("adresseProjet"));
                projet.setChefProjet(resultSet.getString("chefProjet"));
                projet.setDateDebut(resultSet.getDate("dateDebut"));
                projet.setDateFin(resultSet.getDate("dateFin"));
                projet.setBudget(resultSet.getInt("budget"));
                projet.setType(resultSet.getString("typeProjet"));
                projet.setTaches(resultSet.getString("taches"));
                projet.setImage(resultSet.getString("imagePlan"));
                projet.setEtat(resultSet.getInt("etatavacement"));
               
                
                projets.add(projet);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return projets;
	    }    
    
    public static String selectNomEmpl(int idtache,int idprojet) throws ClassNotFoundException, SQLException {
        String nom = null;
        String query = "SELECT nom FROM employeur WHERE idProjet = ? AND idtache = ? AND post = ?";
        
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
        	 preparedStatement.setInt(1, idprojet);
             preparedStatement.setInt(2, idtache);
             preparedStatement.setString(3, "chefProjet");
           
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
            	            
                     if (resultSet.next()) {
                     
                  nom = resultSet.getString("nom");
                  return nom;
                     }
         
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
        return nom;
    }
    public static List<Taches> selectTachesByProjetId(String nomProjet) throws ClassNotFoundException {
        List<Taches> taches = new ArrayList<>();
        String query = "SELECT * FROM taches WHERE idProjet = (SELECT idProjet FROM projets WHERE nomProjet = ?)";
        
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {
            preparedStatement.setString(1, nomProjet);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Taches tache = new Taches();
                    // Remplir les propriétés de la tâche à partir des résultats de la requête
                    tache.setNomTache(resultSet.getString("nomTache"));
                    tache.setNomRespo(selectNomEmpl(resultSet.getInt("id"),resultSet.getInt("idProjet")));
                    tache.setDateDebut(resultSet.getDate("dateDebut"));
                    tache.setDateFin(resultSet.getDate("dateFin"));
                    tache.setEtat(resultSet.getInt("etatdavanc"));
                    tache.setCharge(resultSet.getInt("charges"));
                    tache.setRemarque(resultSet.getString("remarque"));
                    tache.setStructure(resultSet.getString("structure"));

                    taches.add(tache);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taches;
    }
    
    public static List<Service> selectAllServices() throws ClassNotFoundException, SQLException {
        List<Service> services = new ArrayList<>();
        String query = "SELECT * FROM services";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Service service = new Service();
                service.setIdService(resultSet.getInt("idService"));
                service.setNomService(resultSet.getString("nomService"));
                service.setDescription(resultSet.getString("description"));
                service.setImageService(resultSet.getString("imageService"));

                services.add(service);
                for (Service projet : services) {
                    System.out.println(projet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return services;
    }


    
    public ResultSetMetaData getResultData() {
        return resultData;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
    
    public DefaultTableModel getModel() {
    	return model;
    }
}
