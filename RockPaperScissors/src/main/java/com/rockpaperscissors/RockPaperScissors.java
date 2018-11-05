/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rockpaperscissors;

/**
 *
 * @author sindhu
 */import java.util.Scanner;
   import java.util.Random;
public class RockPaperScissors {
    public static void main(String[] args)
    {
         String RockPaperScissors =  rcp();
       
         while(("Yes").equalsIgnoreCase(RockPaperScissors))
         {
             RockPaperScissors = rcp();
             if(!("Yes").equalsIgnoreCase(RockPaperScissors))
             {
                 System.out.println("Thanks for playing!");
                 break;
             }
         }
        
    }
         
      public static String rcp()
      {
        
        int ties=0;
        int userwins=0;
        int computerwins=0;
        Scanner myscanner=new Scanner(System.in);
        System.out.println("How many rounds you want to play?");
        int user=myscanner.nextInt();
        
        if(user<=10 && user>0)
        {

          for(int i=1;i<=user;i++)
           {
            
            System.out.println("Enter ur choice:1)Rock 2)Paper 3)Scissors");
            int choice=myscanner.nextInt();
        
            Random r=new Random();
            int computer=r.nextInt(3)+1;
        
                if(computer==choice)
                {
                 System.out.println("Oh!,Its a tie");
                 ties++;
                 continue;
                }
        
                switch(choice)
                {
                   case 1:
                          if(computer==2)
                          {
                             System.out.println("Computer beats User");
                             computerwins++;
                             break;
                          }else if(computer==3){
                             System.out.println("User beats Computer");
                             userwins++;
                             break;
                          }
                   case 2:       
                         if(computer==1)
                         {
                            System.out.println("User beats Computer");
                            userwins++;
                            break;
                         }else if(computer==3){
                            System.out.println("Computer beats User");
                            computerwins++;
                            break;
                         }
                   case 3:
                         if(computer==1)
                         {
                            System.out.println("Computer beats User");
                            computerwins++;
                            break;
                         }else if(computer==2){
                            System.out.println("User beats Computer");
                            userwins++;
                            break;
                         }
                } 
        }
 
        System.out.println("Number of UserWins:"+userwins);
        System.out.println("Number of ComputerWins:"+computerwins);
        System.out.println("Number of Ties:"+ties);
        
       
                   if(userwins>computerwins)
                    {
                       System.out.println("User wins the game !");
                       }else if (userwins<computerwins)
                       {
                        System.out.println("Computer wins the game !");
                       }else
                       {
                        System.out.println("Its a Tie !");
                       }
        }else
           {
              System.out.println("Out of range");
           }
        
        Scanner ss=new Scanner(System.in);
        System.out.print("Do you want to play again?Say Yes or No: ");
        String nextplay=ss.nextLine();
            
        return nextplay;    
       
    }
      
      
     
}
       
       
               
    

        
                 
                 
            
        
        
        
       
        
        
       
        
    
    

