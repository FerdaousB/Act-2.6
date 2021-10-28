package tests;

import java.sql.SQLException;

import projectManagement.AnnouncementManager;

public class main {

	public static void main(String[] args) throws SQLException {

		
		AnnouncementManager A1 = new AnnouncementManager();
		
		//A1.CreerCompte();
		//A1.afficherAnnonce();
		A1.VerifCompte("talan");
		 // A1.CreerAnnonce();
		// A1.afficherUser();
		//A1.ModifInfoPerso();
       // A1.DeleteAnnoce();
		//A1.ModifAnnonce();
	}

}
