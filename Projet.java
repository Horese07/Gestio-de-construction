package models;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.ParseException;


import javax.swing.table.DefaultTableModel;

public class Projet extends  JDBC {
	  private int id;
	    private String nom;
	    private String adresse;
	    private String chefProjet;
	    private Date dateDebut;
	    private Date dateFin;
	    private int budget;
	    private String type;
	    private String taches;
	    private String image;
	    private int etat;

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getAdresse() {
	        return adresse;
	    }

	    public void setAdresse(String adresse) {
	        this.adresse = adresse;
	    }

	    public String getChefProjet() {
	        return chefProjet;
	    }

	    public void setChefProjet(String chefProjet) {
	        this.chefProjet = chefProjet;
	    }

	    public Date getDateDebut() {
	        return dateDebut;
	    }

	    public void setDateDebut(Date dateDebut) {
	        this.dateDebut = dateDebut;
	    }

	    public Date getDateFin() {
	        return dateFin;
	    }

	    public void setDateFin(Date dateFin) {
	        this.dateFin = dateFin;
	    }

	    public int getBudget() {
	        return budget;
	    }

	    public void setBudget(int budget) {
	        this.budget = budget;
	    }

	    public String getType() {
	        return type;
	    }

	    public void setType(String type) {
	        this.type = type;
	    }

	    public String getTaches() {
	        return taches;
	    }

	    public void setTaches(String taches) {
	        this.taches = taches;
	    }

	    public String getImage() {
	        return image;
	    }

	    public void setImage(String image) {
	        this.image = image;
	    }

	    public int getEtat() {
	        return etat;
	    }

	    public void setEtat(int etat) {
	        this.etat = etat;
	    }

	public Projet() throws SQLException, ClassNotFoundException {
		super();
		super.selectData(getConnection(), "SELECT * FROM projets");
	}
	
	 public  DefaultTableModel selectProjet(String option) throws SQLException, ClassNotFoundException {
	        PreparedStatement preparedStatement = null;
	        String query = "SELECT * FROM projets WHERE echancier = ? ";
	        
	        try {
	            preparedStatement = getConnection().prepareStatement(query);
	            preparedStatement.setString(1, option);
	            
	            resultSet = preparedStatement.executeQuery();
	            java.sql.ResultSetMetaData resultData = resultSet.getMetaData();

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
	 public Boolean InsertData(Object[] model) throws SQLException, ParseException, ClassNotFoundException {
		  
		    String query = "INSERT INTO projets (nomProjet, adresseProjet, client, chefProjet, dateDebut, dateFin, budget, echancier, typeProjet,etatavacement) " +
		                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		    PreparedStatement preparedStatement = null;
		    System.out.println("Je suis en train d'insérer");

		    try {
		        preparedStatement = getConnection().prepareStatement(query);
		        preparedStatement.setString(1, (String) model[0]);
		        preparedStatement.setString(2, (String) model[1]);
		        preparedStatement.setString(3, (String) model[2]);
		        preparedStatement.setString(4, (String) model[3]);     
		        preparedStatement.setDate(5, (Date) model[4]);  	       
		        preparedStatement.setDate(6,  (Date) model[5]);
		        preparedStatement.setBigDecimal(7, (BigDecimal) model[6]);
		        preparedStatement.setString(8, (String) model[7]);
		        preparedStatement.setString(9, (String) model[8]);
		      //  preparedStatement.setInt(10, (Integer) model[9]);

		        preparedStatement.executeUpdate();
		        System.out.println("Projet enregistré avec succès !");
		        return true;
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (preparedStatement != null) {
		            preparedStatement.close();
		            System.out.println("Je n'ai pas réussi");
		        }
		    }
		    return false;
		}
	 
	 public boolean updatePro(Object[] model) throws SQLException, ParseException, ClassNotFoundException { //
		    String query = "UPDATE projets SET adresseProjet = ?, client = ?, chefProjet = ?, dateDebut = ?, dateFin = ?, budget = ?, echancier = ?, typeProjet = ?, etatavacement = ? WHERE nomProjet = ?";
		    PreparedStatement preparedStatement = null;
		    System.out.println("Je suis en train de mettre à jour");

		    try {
		        preparedStatement = getConnection().prepareStatement(query);
		        preparedStatement.setString(1, (String) model[1]);
		        preparedStatement.setString(2, (String) model[2]);
		        preparedStatement.setString(3, (String) model[3]);     
		        preparedStatement.setDate(4, (Date) model[4]);  	       
		        preparedStatement.setDate(5,  (Date) model[5]);
		        preparedStatement.setBigDecimal(6, (BigDecimal) model[6]);
		        preparedStatement.setString(7, (String) model[7]);
		        preparedStatement.setString(8, (String) model[8]);
		        //preparedStatement.setInt(9, (Integer) model[9]);
		        preparedStatement.setString(9, (String) model[0]); // le nom du projet pour la clause WHERE

		        int rowsUpdated = preparedStatement.executeUpdate();
		        
		        if (rowsUpdated > 0) {
		            System.out.println("Projet mis à jour avec succès !");
		            return true;
		        } else {
		            System.out.println("Aucun projet mis à jour !");
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (preparedStatement != null) {
		            preparedStatement.close();
		            System.out.println("Je n'ai pas réussi");
		        }
		    }
		    return false;
		}


	 public void deleteData(int id) throws SQLException, ClassNotFoundException {
		    String query = "DELETE FROM projets WHERE idProjet = ?";
		    PreparedStatement preparedStatement = null;
		    System.out.println("Je suis ici !");
		    try {
		        preparedStatement = getConnection().prepareStatement(query);
		        System.out.println("Je suis ici 1 !");
		        preparedStatement.setInt(1, id);
		        System.out.println("Je suis ici 2 !");
		        preparedStatement.executeUpdate(); // Supprimer les données sans spécifier la requête à nouveau
		        System.out.println("Je suis ici 3 !");
		        System.out.println("Projet supprimé avec succès !");
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        if (preparedStatement != null) {
		            preparedStatement.close();
		        }
		    }
		}

	    
	 public Boolean modifierProjet(DefaultTableModel model,int row) throws SQLException, ClassNotFoundException {
		 deleteData(row);
		// InsertData();
		
		 return false;
		 
	 }


	  
 
}
