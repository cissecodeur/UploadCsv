package com.UploadCsv.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.UploadCsv.entities.Produit;
import com.UploadCsv.repositories.ProduitRepository;

@RestController
public class ProduitController {

	
	 @Autowired
	 private ProduitRepository produitRepository;
	  
	 
	 
	 
	 
//	 //Methode a implementer
//   @PostMapping("/upload")  
//   public String traitementUpload(Produit produit,MultipartFile file) throws IOException {             
//		   
//		 try {
//			 Workbook workbook = getWorkbookk(file);
//		      Sheet sheet = workbook.getSheetAt(0);
//		     
//			      Iterator<Row> rows =  sheet.iterator();
//			      
//			      rows.next();
//			      while(rows.hasNext()) {
//			    	  
//			    	  Row row  = rows.next();
//
//			    	    if(row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
//			    	    	produit.setLibelle(row.getCell(1).getStringCellValue());
//			    	    }
//			    	    
//			    	    if(row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
//			    	    	produit.setDesignation(row.getCell(2).getStringCellValue());
//			    	    }
//			    	    
//			    	    if(row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {
//			    	    	String quantite = NumberToTextConverter.toText(row.getCell(3).getNumericCellValue());
//			    	    	produit.setQuantite(quantite);
//			    	    }
//			    	    
//			    	    else if(row.getCell(4).getCellType() == Cell.CELL_TYPE_STRING) {
//			    	    	produit.setQuantite(row.getCell(4).getStringCellValue());
//			    	    }
//			    		produitRepository.save(produit);
//			      }
//			       
//			     
//				return "Upload avec succes";
//			
//		} catch (Exception e) {
//			
//			 return "Echec de l'Upload";
//      }
//	   		
//	      
//	}
//	 
		 
	//Mehtode getWorkBook
	private Workbook getWorkbookk(MultipartFile file) {
			Workbook workbook = null;
			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			try {
				   if(extension.equalsIgnoreCase("xlsx")){
					   workbook = new XSSFWorkbook(file.getInputStream());
				   }
				   
				   else if(extension.equalsIgnoreCase("xls")){
					   workbook = new HSSFWorkbook(file.getInputStream());
				   }
				   		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}

	
	
	

	    
	   
	  

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	 
//	  @GetMapping(value = "/")
//	 public String home(Model model) {
//			model.addAttribute("produit", new Produit());
//			
//			//Retrouver tout les produits 
//			List<Produit> listProduits = produitService.findAll();
//			model.addAttribute("listProduits", listProduits);
//			
//			return "/views/listproduits";
//		}
//	  
//	  @PostMapping("/fileUpload")
//	  public String uploadFile(@ModelAttribute Produit produit , RedirectAttributes redirectAttributes) {
//		          boolean isFlag = produitService.saveDataFromUploadFile(produit.getFile());
//		               if(isFlag == true) {
//		            	   redirectAttributes.addFlashAttribute("Message de succes", "fichier uploade avec succes");
//		               }
//		               else {
//		            	   redirectAttributes.addFlashAttribute("Message Erreur", "fichier non uploade");
//
//		               }
//		          
//		         return "redirect :/";
//	  }

}
