package com.marlon.assignments;


import java.util.ListIterator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;


/*
 * 1) Write a java program to reverse elements in a array list?
 * 2) ... of swap 2 elements in an array list?
 * 3) ... to iterate through all elements in a linked list starting at a specific position?
 * 4) ... to replace an element in a linked list?
 * 5) ... to convert a hash set to an array? 
 * 
 * */
class arrayList{
	//part 1 of questions 
	public void part1(int numbers[]) {
		int temp =0; 
		int size = numbers.length; 
		System.out.println("The numbers are: " + Arrays.toString(numbers));		
		System.out.println(" Now we will swap them: ");
				
			// we know array is even number size so find a middle to stop swaps
			if(size % 2 == 0) {
				for( int i= 0; i <= (size/2); i++) {
					temp =numbers[i]; 
					numbers[i] = numbers[size-1]; 
					numbers[size-1] = temp; 			
					size = size -1;
				}
			}
			//else we know its an odd numbered size so we need to find a middle 
			else {
				for(int i=0; i<= Math.floor(size/2); i ++ ) {
					temp =numbers[i]; 
					numbers[i] = numbers[size-1]; 
					numbers[size-1] = temp; 					
					size = size -1; 				
				}					
			}
		System.out.println("The numbers are: " + Arrays.toString(numbers) + "\n");
	}
	
	
	// part 2 of question
	// swap 2 elements in an array 
	public void part2(int numbers[], int element1, int element2 ) {
		
		int temp; 
		System.out.println("Swapping array elements given 2 elements: ");
		System.out.println("Current Array: " + Arrays.toString(numbers));
		temp = numbers[element1]; 
		numbers[element1] = numbers [element2]; 
		numbers[element2] = temp; 
		
		System.out.println("After Swapping 2 elements: " + Arrays.toString(numbers) + "\n");
		
		
	}
	
	
	// iterate though linked list given a starting position 
	public void part3(int position ) {
		LinkedList<Integer> numlist = new LinkedList<Integer>(); 
		
		for(int i =0; i <= 10; i++) {
			numlist.add(i); 
		
		}
		
		System.out.println("Current Linked List is: " + numlist);
		
		System.out.println("Now we will start at the given position and we get: ");
		
		ListIterator<Integer> iter = numlist.listIterator(position);
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
			
		}
		
	}
	
	
	public void part4(String replacement, int position) {
		
		LinkedList<Object> numlist = new LinkedList<Object>(); 
		
		for(int i =0; i <= 10; i++) {
			numlist.add(i); 
		
		}
		
		System.out.println("Current Linked List is: " + numlist);
		
		System.out.println("Will now replace position: " + position + " with: " + replacement);
		
		numlist.set(position, replacement); 
		
		System.out.println("linked list is now: " + numlist);
		
		
	}
	
	public void part5 () {
		
		HashSet<String> set = new HashSet<String>();
		
		for(int i = 0; i < 10; i ++) {
			
			set.add(Integer.toString(i)); 
		}
		
		System.out.println( "Currently a: " + set.getClass().getSimpleName()); 
		
		String[] arr = set.stream().toArray(String [] ::new);
		
		System.out.println("Now it is a: " + arr.getClass().getSimpleName() + "  " + Arrays.toString(arr));
		
	}
	
	
}




public class assignment4 {
	
	
	public static void main(String[] args) {
		
		//part1
		System.out.println("Assignment 4 part 1: ");
		int[] numbers = {1,2,3,4,5,6,7}; 
		int[] numbers1 = {1,2,3,4,5}; 
		int[] numbers2 = {1,2,3,4,5,6,7,8,9}; 
			
		arrayList arr = new arrayList();
		
		arr.part1(numbers);
		arr.part1(numbers1);
		arr.part1(numbers2); 
		
		//part 2
		System.out.println("Assignment 4 part2: ");
		int[] numberswap = {1,2,3,4,5,6,7,8};
		
		arrayList arr2 = new arrayList(); 
		arr2.part2(numberswap, 3, 6);
		arr2.part2(numberswap, 1, 4);
		arr2.part2(numberswap, 7, 2);
		
		
		// part 3 
		
		arrayList arr3 = new arrayList(); 
		int position = 4; 
		System.out.println("Current given position is: " + position); 
		arr3.part3(position);
		
		
		
		// part 4 
		// replace an element in a linked list 
		
		arrayList arr4 = new arrayList();
		String replace = "HELLO"; 
		int pos = 5; 
		
		arr4.part4(replace, pos); 
		
		
		//part 5 
		// create the object and just called the method 
		arrayList arr5 = new arrayList();
		
		arr5.part5(); 
				
		
	}

}
