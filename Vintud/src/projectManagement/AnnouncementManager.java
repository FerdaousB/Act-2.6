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
		 Scanner Sc1 = new Scanner(System.in);
		 System.out.println("Ajouter id :");
		 int id =Sc1.nextInt();

		 Scanner Sc2 = new Scanner(System.in);
		 System.out.println("Ajouter Prenom :");
		 String prenom =Sc2.nextLine();

		 Scanner Sc3 = new Scanner(System.in);
		 System.out.println("Ajouter Nom :");
		 String nom =Sc3.nextLine();

		 Scanner Sc4 = new Scanner(System.in);
		 System.out.println("Ajouter Pseudo :");
		 String pseudo = Sc4.nextLine();

		 Scanner Sc5 = new Scanner(System.in);
		 System.out.println("Ajouter mail :");
		 String mail=Sc5.nextLine();

		 Scanner Sc6 = new Scanner(System.in);
		 System.out.println("Ajouter mot de passe :");
		 String password=Sc6.nextLine();

		 Scanner Sc7 = new Scanner(System.in);
		 System.out.println("inserer numero de telephone :");
		 String numTel=Sc7.nextLine();

		 Scanner Sc8 = new Scanner(System.in);
		 System.out.println("inserer adresse :");
		 String adresse=Sc8.nextLine();

		 Scanner Sc9 = new Scanner(System.in);
		 System.out.println("inserer votre le numero de votre role :"+"\n"+"1- Client"+"\n");
		 int roleId=Sc9.nextInt();
	
		 requete= "INSERT INTO vintud.user VALUES ("+id+",'"+prenom+"','"+nom+"','"+pseudo+"','"+mail+"','"+password+"','"+numTel+"','"+adresse+"',"+roleId+" );";
		 try {
		 Statement stmt = con.createStatement();
		 stmt.executeUpdate(requete) ;
		 System.out.println("User ajouté avec succés");

		 } catch (SQLException e) {
	    	   e.printStackTrace();
		 }

		 System.exit(0);
	}	
	public void VerifCompte(String passeword1) throws SQLException {

		Scanner sc2 = new Scanner(System.in);
		System.out.println("Enter  password:");
		 passeword1= sc2.nextLine();

		String requete = "SELECT * FROM vintud.user;";
		
		 try {
			
			
			 Statement tmt = con.createStatement(); 
	         rs = tmt.executeQuery(requete);  
	         rs.getString(1);
	 
		       while (rs.next()) {
    	 
		        	if(rs.getString("u_password").equals(passeword1)){			   
	        	         System.out.println("Connexion réussie !");}
		        	else {
		        		 System.out.println("Connexion nn réussie !");
		        	}		        	
	           }	           
		           rs.close();
		       } 
		       catch (SQLException e) 
		       {
		    	   e.printStackTrace();
		       }   	
	}
	 public void ModifInfoPerso() throws SQLException {		
		 String  requete = "UPDATE vintud.user SET  firstname='ferdaous' where id =1;";
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
    public void afficherUser() throws SQLException {
		
		 String  requete = "select * from vintud.user";
		
          try {
      	 
      	         Statement tmt = con.createStatement();
                 rs = tmt.executeQuery(requete);             
           
                while(rs.next())
		       {
                 System.out.println(" ---------  Affichage des vendeurs  ------ "+ " \n");
	             System.out.println(rs.getString("firstname")+ " \n"+ rs.getString("name") + " \n" + rs.getString("pseudo") + "\n" + rs.getString("mail") + "\n" + rs.getString("phone" )+ " \n");

		       }
                rs.close();
    
	           } catch (SQLException e) {
	    	   
	    	   e.printStackTrace();
	           }      
    }
    
    public void CreerAnnonce() throws SQLException {
				
		 String  requete = "INSERT INTO vintud.announcement (id, title, description, category_id, price, picture, publication_date, is_available, view_number, localisation, user_id)" +  "VALUES  (3, 't-shirt bon état', 'Je vends mon magnifique t-shirt acheté lannée dernière en solde, taille M.',1,24.98,NULL,'2019-01-25 8:32:12', true, 2,'Paris 9ième',1);";
		
		 try {		 
				Statement tmt = con.createStatement(); 
	            int resultat = tmt.executeUpdate(requete);             
	 
		           if (resultat>0)
			   {
	        	   System.out.println("Inserted Annonce into the table..."); 
	           }
		           con.close();
		       } 
		       catch (SQLException e) 
		       {
		    	   e.printStackTrace();		       
		   }   	}
    public void DeleteAnnoce() throws SQLException {
		
		 String  requete = "DELETE FROM vintud.announcement WHERE title='t-shirt bon état'"; 
		 try {		 
				Statement tmt = con.createStatement();           
	            int resultat = tmt.executeUpdate(requete);             
	 
		           if (resultat>0)
			   {
	        	   System.out.println("  Row Deleted ...."); 
	           }
		           con.close();
		       } 
		       catch (SQLException e) 
		       {
		    	   e.printStackTrace();		       
		   }   	}
    public void ModifAnnonce() throws SQLException {	
    	
		 String  requete = "UPDATE vintud.announcement SET  title='basket stan smith etat neuf' where id =1;";
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




