package com.UploadCsv.entities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {
	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;
	private List<Produit> datasProduit;
	public List<Produit> getDatasProduit() {
		return datasProduit;
	}

	public void setDatasProduit(List<Produit> datasProduit) {
		this.datasProduit = datasProduit;
	}

	private String info1;
	private String info2;
	private String info3;

	

	public Response(String fileName, String fileDownloadUri, String fileType, long size, List<Produit> datasProduit,
			String info1, String info2, String info3) {
		super();
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
		this.datasProduit = datasProduit;
		this.info1 = info1;
		this.info2 = info2;
		this.info3 = info3;
	}

	public Response() {
		// TODO Auto-generated constructor stub
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getInfo1() {
		return info1;
	}

	public void setInfo1(String info1) {
		this.info1 = info1;
	}

	public String getInfo2() {
		return info2;
	}

	public void setInfo2(String info2) {
		this.info2 = info2;
	}

	public String getInfo3() {
		return info3;
	}

	public void setInfo3(String info3) {
		this.info3 = info3;
	}

}













//
//
//@RequestMapping(value = "/import-excel", method = RequestMethod.POST)
//public Response importExcelFile(@RequestParam("file") MultipartFile files , Produit pr) throws IOException {
//	
//	Response response = new Response();
//    List<Produit> productList = new ArrayList<>();
//    Workbook workbook = getWorkbookk(files);
//    Sheet worksheet = workbook.getSheetAt(0);
//    
//   Iterator<Row> rows = worksheet.iterator();
//    
//    int rowNumber = 0;
//    while (rows.hasNext()) {
//      Row currentRow = rows.next();
//      
//      // skip header
//      if(rowNumber == 0) {
//        rowNumber++;
//        continue;
//      }
//      
//      Iterator<Cell> cellsInRow = currentRow.iterator();
//      
//      int cellIndex = 0;
//      while (cellsInRow.hasNext()) {
//    	  Cell currentCell = cellsInRow.next();
//    	  
//    	  if(pr != null 
//    	    		&& pr.getLibelle()!=null && !pr.getLibelle().isEmpty()
//    	    		&& pr.getCategorie()!=null &&  !pr.getCategorie().isEmpty()
//    	    		&& pr.getQuantite()>0 ) {
//    		  if(cellIndex==0) { // libelle
//                  pr.setLibelle(currentCell.getStringCellValue());
//                } else if(cellIndex==1) { // categorie
//                 pr.setCategorie(currentCell.getStringCellValue());
//                } else if(cellIndex==2) { // quantite
//                  pr.setQuantite((int) currentCell.getNumericCellValue());
//                }
//                
//                cellIndex++;
//          	
//    		  
//    	  }
//           
//  	    }  
//        productList.add(pr);
// 	    produitRepository.saveAll(productList);
// 	    
// 
//      }
//      
//    
//   response.setDatasProduit(productList);
//   return response ;
//}

