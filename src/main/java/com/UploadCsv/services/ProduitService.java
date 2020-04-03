package com.UploadCsv.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.UploadCsv.entities.Produit;

public interface ProduitService {

	List<Produit> findAll();

	Boolean saveDataFromUploadFile(MultipartFile file);

}
