/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.doggenetics2;

/**
 *
 * @author sindhu
 */import java.util.Scanner;
import java.util.Random;
public class DogGenetics2 {
    
           public static void main(String[] args) 
        {
                int[] randomNumber=new int[5];
                
                String[] dog={"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur"};
                int sum=0;
                int i;
                Scanner input = new Scanner(System.in);
                System.out.println("What is your dog's name?");
                String name = input.next();
                System.out.println("Well then, I have highly reliable report on Sir "+dog+"'s prestigious background right here");

                
                for(i=0;i<4;i++) {
                    randomNumber[i]= getRandomNumberInRange(0, 100-sum);
                    sum+=randomNumber[i];
                    System.out.println(randomNumber[i]+"%"+dog[i]);
                }
                randomNumber[i]=100-sum;
                System.out.println(randomNumber[i]+"% King Doberman");
        }

        public static int getRandomNumberInRange(int min, int max) 
        {
             Random r = new Random();
             return r.nextInt((max - min) + 1) + min;
      
        }
                
        

}
    

