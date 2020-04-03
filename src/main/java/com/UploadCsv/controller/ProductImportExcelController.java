package com.UploadCsv.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.UploadCsv.entities.Produit;
import com.UploadCsv.entities.Response;
import com.UploadCsv.repositories.ProduitRepository;


@RestController
@RequestMapping("/produit")
public class ProductImportExcelController {
	
	 @Autowired
	 private ProduitRepository produitRepository;
	  	 


@RequestMapping(value = "/import-excel", method = RequestMethod.POST)
public Response importExcelFile(@RequestParam("file") MultipartFile files ) throws IOException {
	
	Response response = new Response();
    List<Produit> productList = new ArrayList<>();
    Workbook workbook = getWorkbookk(files);
    Sheet worksheet = workbook.getSheetAt(0);
    
    
    Iterator<Row> rows = worksheet.iterator();
      
    int rowNumber = 0;
    while (rows.hasNext()) {
      Row currentRow = rows.next();
      
      // skip header
      if(rowNumber == 0) {
        rowNumber++;
        continue;
      }
      
      Produit pr = new Produit();
      Iterator<Cell> cellsInRow = currentRow.iterator();
      
      int cellIndex = 0;
      while (cellsInRow.hasNext()) {
    	  Cell currentCell = cellsInRow.next();
    	  
    	  if(pr != null) {
    		  if(cellIndex==0) { // libelle
                  pr.setLibelle(currentCell.getStringCellValue());
                } else if(cellIndex==1) { // categories
                 pr.setCategorie(currentCell.getStringCellValue());
                } else if(cellIndex==2) { // quantite
                  pr.setQuantite((int) currentCell.getNumericCellValue());
                }
                
                cellIndex++;
                produitRepository.save(pr);
               
    	  }
    	 
  	    }  
        productList.add(pr);
 	   	    
 
    }
      
   response.setSize(productList.size());
   response.setDatasProduit(productList);
   return response ;
}
  
//Mehtode getWorkBook
	private Workbook getWorkbookk(MultipartFile files) {
			Workbook workbook = null;						
			try {
				if(files != null && !files.isEmpty()) {
					String extension = FilenameUtils.getExtension(files.getOriginalFilename());
					   if(extension.equalsIgnoreCase("xlsx")){
						   workbook = new XSSFWorkbook(files.getInputStream());
					       }
					   
					   else if(extension.equalsIgnoreCase("xls")){
						   workbook = new HSSFWorkbook(files.getInputStream());
					       }
				}else {
				      System.out.println("Veuillez ajouter un fichier");
			               }      
												   		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return workbook;
		}

	
}