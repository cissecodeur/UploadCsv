package com.UploadCsv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.UploadCsv.entities.Produit;
import com.UploadCsv.repositories.ProduitRepository;

@SpringBootApplication
public class UploadCsvApplication implements CommandLineRunner{

	
	 @Autowired
	 private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(UploadCsvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		produitRepository.save(new Produit(null,"P1","P1",10));
		produitRepository.save(new Produit(null,"P3","P1",11));
		
		
		
	}

}
