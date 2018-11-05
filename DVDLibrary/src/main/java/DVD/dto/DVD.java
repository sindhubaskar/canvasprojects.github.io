/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.dto;

/**
 *
 * @author sindhu
 */
public class DVD {
    
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorsName;
    private String Studio;
    private String userRating;
    
    public DVD(String title)
     {
        this.title=title;
       
        
     }

    public void setTitle(String title) {
        this.title = title;
    }
    

    public String getTitle() 
     {
        return title;
     }

    public String getReleaseDate() 
     {
        return releaseDate;
     }

    public void setReleaseDate(String releaseDate)
     {
        this.releaseDate = releaseDate;
     }

    public String getMpaaRating() 
     {
        return mpaaRating;
     }

    public void setMpaaRating(String mpaaRating) 
     {
        this.mpaaRating = mpaaRating;
     }

    public String getDirectorsName()
     {
        return directorsName;
     }

    public void setDirectorsName(String directorsName) 
     {
        this.directorsName = directorsName;
     }

    public String getStudio() 
     {
        return Studio;
     }

    public void setStudio(String Studio) 
     {
        this.Studio = Studio;
     }

    public String getUserRating()
     {
        return userRating;
     }

    public void setUserRating(String userRating)
     {
        this.userRating = userRating;
     }
    
   
}
