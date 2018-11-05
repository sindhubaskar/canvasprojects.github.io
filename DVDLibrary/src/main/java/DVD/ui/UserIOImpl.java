/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVD.ui;

import java.util.Scanner;

/**
 *
 * @author sindhu
 */
public class UserIOImpl implements UserIO{
    
     Scanner reader = new Scanner( System.in );
    
    @Override
    public void print(String message) 
    {
      System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        double toReturn = Double.NaN;
        System.out.println( prompt );
        
      
        boolean validInput = false;
        while( !validInput )
        {
            try
            {
                String toCheck = reader.nextLine();
                toReturn = Double.parseDouble( toCheck );              
                validInput = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Please enter a valid number.");
            }
                
        }

        
        return toReturn;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        
        double toReturn = Double.NaN;
        
        boolean isValid = false;
        while( !isValid )
        {
            toReturn = readDouble( prompt );
            
            if( toReturn < min || toReturn > max)
            {
                System.out.println( "Please enter a number between " + min + " and " + max + ".");
            }
            else
            {
                isValid = true;
            }
        }
        
        return toReturn;
       
    }

    @Override
    public float readFloat(String prompt) {
        
        float toReturn=Float.NaN;
        
        System.out.println(prompt);
        
        boolean validInput=false;
        while(!validInput)
        {
            try
            {
                String toCheck=reader.nextLine();
                toReturn=Float.parseFloat(toCheck);
                validInput=true;
            }
        
        catch(NumberFormatException e)
                {
                  System.out.println("Please enter a valid number.");
                }
        
        }
        return toReturn;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
             
        float toReturn=Float.NaN;
        
        boolean isValid=false;
        while(!isValid)
        {
            toReturn=readFloat(prompt);
            
            if(toReturn<min||toReturn>max)
            {
                System.out.println("Please enter a number between "+min+ " and "+max+" . ");
            }
            else
            {
                isValid=true;
            }
        }
       return toReturn;
    }

    @Override
    public int readInt(String prompt) {
        int toReturn=Integer.MIN_VALUE;
        System.out.println(prompt);
        
        boolean isValid=false;
        while(!isValid)
        {
            try
            {
            String toCheck=reader.nextLine();
            toReturn=Integer.parseInt(toCheck);
            
             isValid=true;
            }
        catch(NumberFormatException e)
                {
                  System.out.println("please enter a valid number");
                
                }
        }
        return toReturn;
    }


    @Override
    public int readInt(String prompt, int min, int max) {
        
        int toReturn=Integer.MIN_VALUE;
        
        boolean isValid=false;
        while(!isValid)
        {
            toReturn=readInt(prompt);
            
            if(toReturn<min||toReturn>max)
            {
                System.out.println("please enter a number between "+min+ " and "+max+" . ");
                
            }
            else
            {
                isValid=true;
            }
        }
        return toReturn;
    }

    @Override
    public long readLong(String prompt) {
        
        long toReturn=Long.MIN_VALUE;
        
        System.out.println(prompt);
        
        boolean isValid=false;
        while(!isValid)
        {
            try
            {
                String toCheck=reader.nextLine();
                toReturn=Long.parseLong(prompt);
                isValid=true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("please enter a valid number");
            }
             
        }
        return toReturn;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        
        Long toReturn=Long.MIN_VALUE;
        
        boolean isValid=false;
        while(!isValid)
        {
            toReturn=readLong(prompt);
            if(toReturn<min||toReturn>max)
            {
                System.out.println("please enter a number between "+min+ " and "+max+" . ");
                
            }else
            {
                isValid=true;
            }
        }
        return toReturn;
    }

    @Override
    public String readString(String prompt) {
        
        System.out.println(prompt);
        
        String toReturn=reader.nextLine();
        
       
        
      return toReturn;  
    }
    
    
    
    
}
