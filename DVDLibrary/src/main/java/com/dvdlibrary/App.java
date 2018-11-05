/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dvdlibrary;

import DVD.controller.DVDController;
import DVD.dao.DVDDao;
import DVD.dao.DVDDaoFileImpl;
import DVD.ui.DVDView;
import DVD.ui.UserIO;
import DVD.ui.UserIOImpl;

/**
 *
 * @author sindhu
 */
public class App {
    
    public static void main(String[] args)
    {
        UserIO myIo=new UserIOImpl();
        DVDView myView=new DVDView(myIo);
        DVDDao myDao=new DVDDaoFileImpl() {};
        DVDController controller=new DVDController(myDao,myView);
        controller.run();
    }
}
