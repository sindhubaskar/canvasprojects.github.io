/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.ui;

import DVD.dto.DVD;
import java.util.List;

/**
 *
 * @author sindhu
 */
public class DVDView {

    private UserIO io;

    public DVDView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1.Add a DVD");
        io.print("2.List the DVD");
        io.print("3.Search by title");
        io.print("4.Remove a DVD");
        io.print("5.Edit the Information");
        io.print(".Exit");

        return io.readInt("Please select from the above choices.");

    }

    public DVD getNewDVDInfo() {

        String title = io.readString("Please enter the Title");
        String releaseDate = io.readString("Please enter the ReleaseDate");
        String mpaaRating = io.readString("Please enter the MPAA Rating");
        String directorsName = io.readString("Please enter the Director's Name");
        String studio = io.readString("Please enter the Studio");
        String userRating = io.readString("Please enter the UserRating");

        DVD currentDvd = new DVD(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);

        return currentDvd;

    }

   

    public int printEditMenuAndGetEditSelection(DVD dvd) {
        io.print("Edit Menu");
        io.print("1. Edit Title: " + dvd.getTitle());
        io.print("2. Edit Release Date: " + dvd.getReleaseDate());
        io.print("3. Edit MPAA Rating: " + dvd.getMpaaRating());
        io.print("4. Edit Director Name: " + dvd.getDirectorsName());
        io.print("5. Edit Studio: " + dvd.getStudio());
        io.print("6. Edit User Rating: " + dvd.getUserRating());
        io.print("7. Return To Main Menu");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public DVD editDVD(DVD dvd) {
        boolean keepGoing = true;
        int editMenuSelection = 0;
        while (keepGoing) {

            editMenuSelection = printEditMenuAndGetEditSelection(dvd);

            switch (editMenuSelection) {
                case 1:
                    
                    String title = io.readString("Please enter Title");
                    dvd.setTitle(title);
                    break;
                case 2:
                    String releaseDate = io.readString("Please enter Release Date");
                    dvd.setReleaseDate(releaseDate);
                    break;
                case 3:
                    String mpaaRating = io.readString("Please enter MPAA Rating");
                    dvd.setMpaaRating(mpaaRating);
                    break;
                case 4:
                    String directorName = io.readString("Please enter Director Name");
                    dvd.setDirectorsName(directorName);
                    break;
                case 5:
                    String studio = io.readString("Please enter the Studio");
                    dvd.setStudio(studio);
                    break;
                case 6:
                    String userRating = io.readString("Please enter your Rating");
                    dvd.setUserRating(userRating);
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }
        }
        return dvd;
    }

    public void displayCreateDVDBanner() {
        io.print("===Create DVD===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD Successfully created.Please hit enter to continue");

    }

    public void displayDvdList(List<DVD> DvdList) {
        for (DVD currentDvd : DvdList) {
            io.print(currentDvd.getTitle() + ":"
                    + currentDvd.getReleaseDate() + ":"
                    + currentDvd.getMpaaRating() + ":"
                    + currentDvd.getDirectorsName() + ":"
                    + currentDvd.getStudio() + ":"
                    + currentDvd.getUserRating());
        }
        io.readString("Please hit enter to continue");
    }

    public void displayDisplayAllBanner() {
        io.print("===Display All DVD's");
    }

    public void searchDVDBanner() {
        io.print("===Search DVD===");
    }

    public String getTitle() {
        return io.readString("Please enter the Title");
    }

    public void searchDVD(DVD dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");

        } else {
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner() {
        io.print("===Remove Student===");

    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD Successfully removed.Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayEditBanner() {
        io.print("===Edit UserRating===");
    }

    public void displayEditSuccessBanner() {
        io.print("===Edited Successfully===");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
