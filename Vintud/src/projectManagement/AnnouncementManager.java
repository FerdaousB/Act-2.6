package projectManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;

public class AnnouncementManager {

	
	Connection  con = ConnectionManager.getConnection();
    ResultSet rs = null;
    String requete = "";
	
	public void CreerCompte() throws SQLException {
		
		
		 String  requete = "INSERT INTO vintud.user (id, firstname, name, pseudo, mail, u_password, phone, address, role_id)" +  "VALUES  ( '11', 'ferdaous', 'boussema', 'doussa', 'ferdaous@gmail.com', 'talan','123456789','monastir','1');";
		
		 try {
			 
			 
				Statement tmt = con.createStatement(); 
	            int resultat = tmt.executeUpdate(requete);             
	 
		           if (resultat>0)
			   {
	        	   System.out.println("Inserted user into the table..."); 
	           }
		           
		           con.close();

		       } 
		       catch (SQLException e) 
		       {
		    	   e.printStackTrace();
		       }   	
	}
	
	public void VerifCompte() throws SQLException {
		
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter  password:");
		String passeword1= sc2.nextLine();

		
		String requete = "SELECT u_password FROM vintud.user WHERE u_password ='"+passeword1+"'";
		
		 try {
			 
			 

				Statement tmt = con.createStatement(); 
	            int resultat = tmt.executeUpdate(requete);             
	 
		           if (resultat>0) {
		        	  
		        	 
		        	if(rs.getString("u_password").equals(passeword1)){
			   
	        	         System.out.println("Connexion réussie !");}
		        	else {
		        		 System.out.println("Connexion nn réussie !");
		        	}
	        	         
		        	

	           }
		           
		           con.close();

		       } 
		       catch (SQLException e) 
		       {
		    	   e.printStackTrace();
		       }   
	
	
	
	
	
	
	}
    
	
	
	
	
	
    public void afficherAnnonce() throws SQLException {
		
		 String  requete = "select * from vintud.announcement";
		
           try {
       	 
       	          Statement tmt = con.createStatement();
                  rs = tmt.executeQuery(requete);             
                  System.out.println(" ---------  Affichage des Annonces  ------ "+ " \n");
            
                 while(rs.next())
		       {
	             System.out.println(rs.getString("title")+ " \n"+ rs.getString("description") + " \n" + rs.getInt("category_id") + "\n" + rs.getBoolean("is_available") + "\n" + rs.getInt("view_number" )+ " \n");

		       }
                 rs.close();
          
        
	           } catch (SQLException e) {
	    	   
	    	   e.printStackTrace();
	           }   
	}
    
    public void ModifInfoPerso() throws SQLException {
		
		
		 String  requete = "UPDATE vintud.user SET  id=6 where id =4;";
		 try {
			 
			 
				Statement tmt = con.createStatement(); 
	            int resultat = tmt.executeUpdate(requete);             
	 
		           if (resultat>0)
			   {
	        	   System.out.println("updated user into the table..."); 
	           }
		           
		           con.close();

		       } 
		       catch (SQLException e) 
		       {
		    	   e.printStackTrace();
		       }   	
	}
    
    
}
