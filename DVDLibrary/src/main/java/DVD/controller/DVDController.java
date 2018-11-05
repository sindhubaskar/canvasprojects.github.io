/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.controller;

import DVD.dao.DVDDao;
import DVD.dao.DVDDaoException;
import DVD.dto.DVD;
import DVD.ui.DVDView;
import DVD.ui.UserIO;
import DVD.ui.UserIOImpl;
import java.util.List;

/**
 *
 * @author sindhu
 */
public class DVDController {
    
    DVDView view;
    private UserIO io=new UserIOImpl();
    DVDDao dao;
    
    public DVDController(DVDDao dao,DVDView view)
    {
        this.dao=dao;
        this.view=view;
    }
    
    public void run()
     {
        
        boolean keepGoing=true;
        int menuSelection=0;
        try{
    
        while(keepGoing)
         {
            io.print("Main Menu");
            io.print("1.Add a DVD");
            io.print("2.List the DVD");
            io.print("3.Search by Title");
            io.print("4.Remove a DVD");
            io.print("5.Edit the Information");
            io.print("6.Exit");
            
            menuSelection=io.readInt("Please select from the above choices.");
            
            switch(menuSelection)
            {
                case 1:createDVD();
                       break;
                case 2:listDVDs();
                       break;
                case 3:searchDVD();
                       break;
                case 4:removeDVD();
                       break;
                case 5:editDVD();
                       break;
                case 6:keepGoing=false;
                       break;
                default:unknownCommand();
                
             }
            
         }   
            
        exitMessage();
        
     }catch (DVDDaoException e) 
       {
	        view.displayErrorMessage(e.getMessage());
       }
     }

    
    private int getMenuSelection()
     {
        return view.printMenuAndGetSelection();
     }
    
    private void createDVD()throws DVDDaoException 
     {
        view.displayCreateDVDBanner();
        DVD newDvd=view.getNewDVDInfo();
        dao.addDVD(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
        
     }
    
    private void listDVDs()throws DVDDaoException
     {
        view.displayDisplayAllBanner();
        List<DVD> DvdList=dao.getAllDVDs();
        view.displayDvdList(DvdList);
        
     }
        
     private void searchDVD()throws DVDDaoException
    {
        view.searchDVDBanner();
        String title=view.getTitle();
        DVD dvd=dao.getDVD(title);
        view.searchDVD(dvd);
    }
     
     private void removeDVD()throws DVDDaoException
      {
         view.displayRemoveDVDBanner();
         String title=view.getTitle();
         dao.removeDVD(title);
         view.displayRemoveSuccessBanner();
      }
    private void editDVD()throws DVDDaoException
    {
      view.displayEditBanner();
      
      String title=view.getTitle();
      DVD dvd=dao.getDVD(title);
      view.editDVD(dvd);
      dao.editDVD(dvd.getTitle(), dvd);
      view.displayEditSuccessBanner();
    }  

     private void unknownCommand()
      {
         view.displayUnknownCommandBanner();
      }
     
     private void exitMessage()
      {
         view.displayExitBanner();
      }
}
