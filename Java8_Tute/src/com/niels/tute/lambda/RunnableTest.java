package com.niels.tute.lambda;

public class RunnableTest
{
	 public static void main(String[] args) {
	      
	      System.out.println("=== RunnableTest ===");
	     
	     // Anonymous Runnable
	     Runnable r1 = new Runnable(){
	       
	       @Override
	       public void run(){
	         System.out.println("Hello world one!");
	       }
	     };
	     
	    // Lambda Runnable
	     Runnable r2 = () -> System.out.println("Hello world two! ");
	
	    	 				     					 
	     Runnable r3 = () -> {
	    	 int ctr = 0;
	    	 for (ctr = 0; ctr < 10; ctr++) {
	    		 
	    	 }
	    	 
	    	 System.out.println("Hello world three! " + ctr);
	     };	     // Note the Semi colon
	     
	     // Run em!
	     r1.run();
	     r2.run();
	     r3.run();
	     
	   }
}
