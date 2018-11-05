/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dao;

import DVD.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sindhu
 */
public  class DVDDaoFileImpl implements DVDDao {
    
    public static final String DVD_FILE = "dvd .txt";
    public static final String DELIMITER = "::";
    
    
    private HashMap<String,DVD> dvds=new HashMap<>();

    @Override
    public DVD addDVD(String title, DVD dvd)throws DVDDaoException  
     {
         DVD newDvd=dvds.put(title, dvd);
         writeDVD();
         return newDvd;
     }

    @Override
    public List<DVD> getAllDVDs()throws DVDDaoException
     {
         loadDVD();
         return new ArrayList<DVD>(dvds.values());
         
     }

    @Override
    public DVD getDVD(String title)throws DVDDaoException 
     { 
         
          loadDVD();
         return dvds.get(title);
     }

    @Override
    public DVD removeDVD(String title)throws DVDDaoException 
     {
         DVD removedDVD=dvds.remove(title);
          writeDVD();
         return removedDVD;
     }
    
    
    
    private void loadDVD() throws DVDDaoException {
	    Scanner scanner;
	    
	    try {
	       
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(DVD_FILE)));
	    } catch (FileNotFoundException e) {
	        throw new DVDDaoException(
	                "-_- Could not load DVD data into memory.", e);
            }

                String currentLine;
                String[] currentTokens;
                while (scanner.hasNextLine()) {
	        
	        currentLine = scanner.nextLine();
	        
	        currentTokens = currentLine.split(DELIMITER);
                 DVD currentDVD = new DVD(currentTokens[0]);
                        
	        currentDVD.setReleaseDate(currentTokens[1]);
	        currentDVD.setMpaaRating(currentTokens[2]);
                currentDVD.setDirectorsName(currentTokens[3]);
                currentDVD.setStudio(currentTokens[4]);
                currentDVD.setUserRating(currentTokens[5]);
	        
	        dvds.put(currentDVD.getTitle(), currentDVD);
               

	    }
	    scanner.close();
	}
            
   
    private void writeDVD() throws DVDDaoException 
     {
	    
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(DVD_FILE));
	    } catch (IOException e) {
	        throw new DVDDaoException(
	                "Could not save DVD data.", e);
	    }
	   
	    List<DVD> dvdList = this.getAllDVDs();
	    for (DVD currentDVD : dvdList) {
	        out.println(currentDVD.getTitle() + DELIMITER
	                + currentDVD.getReleaseDate() + DELIMITER 
	                + currentDVD.getMpaaRating() + DELIMITER
	                + currentDVD.getDirectorsName() + DELIMITER
                         + currentDVD.getStudio() + DELIMITER
                        + currentDVD.getUserRating());
	        out.flush();
	    }
	   
	    out.close();
     }

    @Override
    public DVD editDVD(String oldTitle, DVD dvd) throws DVDDaoException {
         //DVD newDvd=dvds.put(title, dvd);
         
         dvds.remove(oldTitle);
         
         dvds.put(dvd.getTitle(),dvd);
         
         writeDVD();
         return dvd;
    }

   
   

   
	       
	
                

   
    

    

   
    
    
}
