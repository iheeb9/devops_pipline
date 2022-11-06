package com.esprit.examen.mytest;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.services.FournisseurServiceImpl;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
public class FournisseurServiceImplTest   {
	

	@Autowired
	FournisseurServiceImpl fserv;
	
	@Autowired
	FournisseurRepository frepo;

	@Test
	public void testRetrieveAllFournisseurs() {
				
		List<Fournisseur> fournisseurs = fserv.retrieveAllFournisseurs();
		int expected = fournisseurs.size();
		Fournisseur fa=new Fournisseur("test", "test"); 
		Fournisseur f = fserv.addFournisseur(fa);
		System.out.println(f.getCode());
		assertEquals(expected + 1, fserv.retrieveAllFournisseurs().size());
		fserv.deleteFournisseur(f.getIdFournisseur());;
	}
	
	
}
