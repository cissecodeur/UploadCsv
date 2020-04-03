//package com.UploadCsv.services;
//
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.commons.io.FilenameUtils;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.util.NumberToTextConverter;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.UploadCsv.entities.Produit;
//import com.UploadCsv.repositories.ProduitRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.opencsv.CSVReader;
//import com.opencsv.CSVReaderBuilder;
//
//@Service
//@Transactional
//public class ProduitServiceImpl implements ProduitService{
//	
//	@Autowired
//	private ProduitRepository readfileRepository;
//
//	@Override
//	public List<Produit> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Boolean saveDataFromUploadFile(MultipartFile file) {
//		boolean isFlag = false;
//		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//		     if(extension.equalsIgnoreCase("json")){
//		    	 isFlag = readDataFromJson(file);
//		     }	
//		      
//		      else if(extension.equalsIgnoreCase("csv")) {
//		    	  isFlag = readDataFromCsv(file);
//		      }
//		     
//		      else if(extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx") ) {
//		    	  isFlag = readDataFromExcel(file);
//		      }
//		return isFlag;
//	}
//
//	
//	private boolean readDataFromExcel(MultipartFile file) {
//	      Workbook workbook = getWorkbookk(file);
//	      Sheet sheet = workbook.getSheetAt(0);
//	      Iterator<Row> rows =  sheet.iterator();
//	      
//	      rows.next();
//	      while(rows.hasNext()) {
//	    	  Row row  = rows.next();
//	    	  
//	    	  Produit produit = new Produit();
//	    	    if(row.getCell(0).getCellType() == Cell.CELL_TYPE_STRING) {
//	    	    	produit.setLibelle(row.getCell(0).getStringCellValue());
//	    	    }
//	    	    
//	    	    if(row.getCell(1).getCellType() == Cell.CELL_TYPE_STRING) {
//	    	    	produit.setDesignation(row.getCell(1).getStringCellValue());
//	    	    }
//	    	    
//	    	    if(row.getCell(2).getCellType() == Cell.CELL_TYPE_NUMERIC) {
//	    	    	String quantite = NumberToTextConverter.toText(row.getCell(2).getNumericCellValue());
//	    	    	produit.setQuantite(quantite);
//	    	    }
//	    	    
//	    	    else if(row.getCell(2).getCellType() == Cell.CELL_TYPE_STRING) {
//	    	    	produit.setQuantite(row.getCell(2).getStringCellValue());
//	    	    }
//	    	    
////	    	    produit.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
////	    	    readfileRepository.save(produit);
//	      }
//	      	      
//		return true;
//	}
//
//	//Mehtode getWorkBook
//	private Workbook getWorkbookk(MultipartFile file) {
//		Workbook workbook = null;
//		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//		try {
//			   if(extension.equalsIgnoreCase("xlsx")){
//				   workbook = new XSSFWorkbook(file.getInputStream());
//			   }
//			   
//			   else if(extension.equalsIgnoreCase("xls")){
//				   workbook = new HSSFWorkbook(file.getInputStream());
//			   }
//			   		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return null;
//	}
//
//	private boolean readDataFromCsv(MultipartFile file) {
//		 try {
//			
//			  InputStreamReader reader = new InputStreamReader(file.getInputStream()); 
//			 CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
//			  List<String[]> rows = csvReader.readAll();
//			      
//			  for(String[] row : rows) {				  
//		    	  readfileRepository.save(new Produit(row[0], row[1], row[2],FilenameUtils.getExtension(file.getOriginalFilename())));
//			  }
//			     
//			  return true;
//			 
//		} catch (Exception e) {
//			return false;
//		}
//	
//	}
//
//	private boolean readDataFromJson(MultipartFile file) {
//	     try {
//			    InputStream inputStream = file.getInputStream();
//			       ObjectMapper mapper = new ObjectMapper();
//			       List<Produit> listProduits = Arrays.asList(mapper.readValue(inputStream, Produit.class));
//			          if(listProduits.isEmpty() && listProduits != null && listProduits.size()>0) {
////			        	   
////			        	    listProduits.stream().forEach(produit->{
////			        	    	  produit.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
////			        	    	  readfileRepository.save(produit);
////			        	    });			        	  
//			          }
//			          
//			           return true;
//	    	  
//		} catch (Exception e) {
//			return false;
//		}
//		
//	}
//	
//	
//}
