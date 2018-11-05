/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.healthyhearts;

/**
 *
 * @author sindhu
 */import java.util.Scanner;
public class HealthyHearts {
     public static void main(String[] args)
    {
        int age;
        Scanner myscanner=new Scanner(System.in);
        
        System.out.println("Whats your age?");
        age=myscanner.nextInt();
        
        int max=220-age;
        
        System.out.println("Your maximum heart rate should be "+max+ " beats per minute.");
        
        int target=(50*max/100);
        int target1=(85*max/100);
        System.out.println("Your target HR zone is "+target+ "-"+target1+" beats per minute");
        
    }
    
    
}
