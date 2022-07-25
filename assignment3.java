package com.marlon.assignments;


/*
 * 1) create a washing machine class with methods as switch0, acceptClothes, acceptDetergent, switchOff
 * 2) Create a class Student which has following methods, Average: which would accept marks of 3 examinations and return
 * whether the student passed or failed depending on whether he has scored an average above 50 or not?
 * Input: which would accept the name of the student and returns the name
 * 3) Create a Bank Class with the methods deposit and withdraw. The deposit method would accept attributes amount and balance: returns
 * the new balance which the sum of amount and balance. Similarly the withdraw method would accept the attributes amount and balance 
 * and returns the new balance if (balance >= amount or return 0 otherwise)
 * 4) create a vehicle having the following attributes: vehicle num, model manufac, and color. create a truck which has the following
 * additional attributes: 
 * loadingCapaicty(100 tons). add a behavior to change the color and loading capacity. display the updated truck details 
 * 5) the bookstore applications: The bookstore sells books, music cd's, and software's. Typically a customer first logs on to the
 * system, entering a customer id and pass. The customer can then browse for titles or search by keyword. The customer puts some 
 * of the titles into a shopping cart which keeps track of the desired titles. When the customer is done shopping and he/she confirms
 * the order, shipping and billing address. The bookstore system then issues a shipping order, bills the customer and issues
 * an electronic receipt. At the end of the transaction of the customer logs off. 
 * OO Design: with reference to the above create, a scenario system diagram, classes and attributes and relationship as well. 
 *
 * 
 */

//part 1
class washingMachine{
	
	boolean turned; 
	boolean accepts, deterg; 
	public void switch0n(){
		turned = true; 
		acceptClothes();
		detergent(); 
	}
	public void acceptClothes(){ accepts = true; }
	public void detergent() { deterg = true; }
	public void switchOff() { turned = false; 
		accepts = false; 
		deterg = false; 
	}
	
	
}

//part 2 
class Student{
	
	boolean passed; 
	double avrg; 
	String name; 
	
	public void average(double grade1, double grade2, double grade3) {
		this.avrg = (grade1 + grade2 + grade3) /3;
		
		grade(); 
	}
	
	public void input(String name) {
		System.out.println(this.name = name); 
	}
	
	public void grade() {
		
		if(avrg>= 50) {
			passed = true;
			System.out.println("Passed: ");
			
		}
		else { passed= false; 
		System.out.println("Failed. "); 
		}	
	}
}


//part 3
class Bank{
	
	double balance; 
	
	public double deposit(double amount) {
		
		this.balance += amount; 
		
		return 0; 
	}
	
	public void withdraw(double with) {
		
		if(balance >= with) {
			this.balance = balance - with;
		}
		else {
			System.out.println("withdraw is greater than balance. ");
		}
	}
	
	public double checkbalance() {
		
		return balance; 
	}
	
}

//part4
class Vehicle{
	
	public int vehiclenum;
	public String model;
	public String color; 
	
	//constructor to make the cars 
	public void car(int vehiclenum, String model, String color) {
		
		this.vehiclenum = vehiclenum;
		this.model = model; 
		this.color = color; 
		
	}
	
	public int getVehiclenum() {
		return vehiclenum;
	}

	public void setVehiclenum(int vehiclenum) {
		this.vehiclenum = vehiclenum;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
	public void stats() {
		
		System.out.println("Hello the car is: " + vehiclenum +" " + model+ " " + color);
	}
	
	
}

class truck extends Vehicle {
	
	int loadingCap; 
	
	public void trk (int loadCap, String color) {
		
		this.loadingCap = loadCap;
		this.color = color; 
		
	}
	
	public  void newStats() {
		Vehicle car = new Vehicle();
		
		System.out.println("MODEL: " + car.model);
		
		System.out.println("Truck stats are: " + loadingCap + color + car.vehiclenum + car.model);
		
	}
	
}



public class assignment3 {
	
	public static void main(String[] args) {
		
		//part 1 
		washingMachine wm = new washingMachine(); 
		wm.switch0n();
			
		// part 2 
		Student stu= new Student();
		stu.average(35.5,78.9,88.6);
		stu.input("Marlon"); 
		
		//part 3 
		Bank acc = new Bank(); 
		acc.deposit(105.99); 
		acc.deposit(101.01); 
		acc.deposit(53); 
		System.out.println("Your Balance: " + acc.checkbalance()); 
		acc.withdraw(60); 
		System.out.println("Your Balance: " + acc.checkbalance());
		
		//part 4 
		Vehicle car = new Vehicle() ; 
		truck trk = new truck();
		car.car(123, "Dodge", "Silver");
		car.stats(); 
		
		trk.trk(1200, "red");
		trk.newStats();
		
	}
	
	

}
