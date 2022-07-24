package com.marlon.assignments;

import java.util.*; 


/*
 * 1)Print fib series by getting the value from the user 
 * 2) print the prime number by getting the value from the user
 * 3) write a program to swap 2 variables 
 * 4) to calculate the sum of 2 integers and return true if the sum is equal to a third integer
 * 5) write a program to reverse a word 
 * 
 * */

public class assignment2 {
	
	// question 1 will get the fib sequence based on the users input number N number of times recursively
	public static int fib(int usernum) {
	
		if (usernum <=1) {
			return usernum; 
		}
		return fib(usernum-1) + fib(usernum-2);
	}
	
	
	// question 2 print prime numbers based on users input 
	public static void prime( int number){
		
		int flag=0; 
		System.out.println(number);
		
		if(number == 0 || number==1) {
			System.out.println("Not a prime number. ");
		}
		else {
			for(int i =2; i <=number/2; i++) {
				if(number%i ==0) {
					System.out.println("is not a prime number");
					flag =1; 
					break; 
				}				
			}	
			if(flag==0) {
				System.out.println("Your number is a prime number. ");		
			}
		}
	}
	
	// question 3 swapping 2 variables 
	public static void change() {
		int temp;
		int num1=10;
		int num2 = 25;
		
		System.out.println(" Current number 1 is: " + num1);
		System.out.println(" Current number 2 is: "+ num2);
		
		temp = num1; 
		num1 = num2; 
		num2 = temp; 
		
		System.out.println(" Now number 1 is: " + num1);
		System.out.println(" Now number 2 is: " + num2);
		
		
	}
	
	//part 4 calculate the sum of 2 numbers and return true if its equal to the 3rd num 
	
	public static void sumschecker(int num1,int num2,int num3) {
		int sum = num1+num2; 
		if(num1+num2 == num3) {
			System.out.println("Sum of number1 + number2 = " + sum +" equals number3: " + num3 );
			
		}
		else System.out.println("the sum of number1 + number2 = " + sum + " do not equal number3 "+ num3);
		
	}
	
	
	//part 5 reverse a given word
	public static void wordreverse( String word) {
		
		System.out.println("Your word is: " + word);
		System.out.println("Will now reverse this word. ");
		
		 String words[]=word.split("\\s");  
		    String reverseWord="";  
		    for(String w:words){  
		        StringBuilder sb=new StringBuilder(w);  
		        sb.reverse();  
		        reverseWord+=sb.toString()+" ";  
		    }  
		    System.out.println( reverseWord.trim());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// using scanner to get the users input 
		
	
		//part1 
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number: ");
		String num = in.nextLine();
		int number = Integer.parseInt(num); 
		System.out.println("Based on your number fib sequence is: " );
		
		for(int i=0; i < number; i++) {
			System.out.println(fib(i) + " ");			
		}
	
	
		//part 2 
		Scanner primeuser = new Scanner(System.in);
		System.out.println("Enter a word to check if its a prime number: ");
		int usrnum = primeuser.nextInt(); 
		prime(usrnum);
		
		
		// part 3 swapping variables 
		change(); 
		
		//part 4 
		sumschecker(1,1, 2); 
		
		//part 5 word reverse
		Scanner word = new Scanner(System.in);
		System.out.println("Enter a word to reverse: ");
		String usersword = word.nextLine();
		wordreverse(usersword);
		
		System.out.println("That is the end of assignment 2, thank you");
		
		in.close();
		primeuser.close();
		word.close();
		
	}

}
