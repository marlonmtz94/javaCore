package com.marlon.assignments;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*assignment 6 employee management system: 
// jdbc use prepared statement and callable statement a
// Java console -> front end 
// my sql database -> backend 
// getting the value from the users: 
// you have to apply CRUD operations (create, read, update, delete) 
// 1) get the list of employees
// 2) update the existing employee based in his/her id
// 3) delete an employee based on the employee id
// 4) get the employee by id 
*/


public class assignment6 {
	static int stopper; 
	
	//method that will check if the users input was valid in order to continue
	// with the entering of the program 
	public static int checker(Scanner stop) {
		if(stop.hasNextInt()) {
			stopper = stop.nextInt(); 
			System.out.println("STOPPER: "+stopper);
		}
		else {
			while(!stop.hasNextInt()) {
				System.out.println("Does Not Contain A valid input try again. ");
				System.out.println("Continue Enter Any Number, Stop Enter 1: ");
				stop = new Scanner(System.in);
			}
			
			stopper = stop.nextInt(); 
			System.out.println("STOPPER ELSE: " + stopper);
			
		}
		stop.close();
		return stopper; 
		
		
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver"); // this is where the mysql driver is located 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/julyfsd", "root", "root"); // jdbc:mysql... is the default code to connect to database 
		
		/*
		int stopper = 1 ; 
	
		while(stopper !=0) {
			Scanner newid = new Scanner(System.in);
			System.out.println("Enter your ID: ");
			int id = newid.nextInt();
			
			Scanner userName = new Scanner(System.in);
			System.out.println("Enter a name: ");
			String username = userName.next();
			
			Scanner age = new Scanner(System.in);
			System.out.println("Enter age: ");
			int userAge = age.nextInt();
			
			Scanner stop = new Scanner(System.in);
			System.out.println("Continue Enter Any Number, Stop Enter 0: ");
			
			//created a function to keep looping until valid entry is accepted
			stopper = checker(stop);
			
			System.out.println("\nEntered Info was: ");
			System.out.println("Name: " + username);
			System.out.println("Age: " + userAge + "\n");		
			
			//trying to get the current count of rows so i can just update id automatically 
			//ResultSet rs= st.executeQuery("select count(*) from emp");
			//System.out.println("--------------------" + rs.getInt(1));		
			 //ResultSetMetaData rsmeta = rs.getMetaData(); Syst
			 //em.out.println(rsmeta);
			//st.execute("insert into emp values (1,"username"," userAge")"); 
			
			// will add 1 new record to the database julyfsd on table of emp 
			PreparedStatement pst = con.prepareStatement("insert into emp values(?,?,?) "); 	
			pst.setInt(1, id); // 1 refers to the first parameter
			pst.setString(2, username); // name 
			pst.setInt(3, userAge); // age
			
			int x = pst.executeUpdate(); 
			System.out.println(x + " records(s) inserted ");
			
			//closing out the system ins 
			newid.close();
			userName.close(); 
			age.close(); 
			stop.close(); 
			pst.close();
		}
		
		*/
		//part 1 display list of employees
		Statement st = con.createStatement(); 
		ResultSet rs= st.executeQuery("select name from emp");
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
		st.close();
		rs.close();
		
		//part 2 update employees based on his/her id
		Scanner change = new Scanner(System.in);
		System.out.println("Enter your ID to update: ");
		int updateC = change.nextInt();
		System.out.println("Enter your new name: ");
		String newname = change.next(); 
		CallableStatement cst = con.prepareCall(" update emp set name =?  where id =? "); 
		cst.setString(1, newname);
		cst.setInt(2, updateC);  
		cst.execute(); 
		System.out.println("callables statement record insert ");
		cst.close();

		
		//part 3 delete an employee based on employee id
		Scanner del = new Scanner(System.in);
		System.out.println("Enter your ID to delete user: ");
		int delid = del.nextInt();
		PreparedStatement pst = con.prepareStatement("delete from emp where id = ? "); 	
		pst.setInt(1, delid); // 1 is the 1st wildcard so its id and will delete that column 
		int x = pst.executeUpdate(); 
		System.out.println(x + "records(s) deleted" );
		pst.close();
		
		// part 4 get the employee by id  
		Scanner getname = new Scanner(System.in);
		System.out.println("Enter your ID to get info: ");
		int nameget = getname.nextInt();
		PreparedStatement pst1 = con.prepareStatement("select * from emp where id = ? ;"); 	
		pst1.setInt(1, nameget); // 1 is the 1st wildcard so its id and will delete that column 
		ResultSet rs1 = pst1.executeQuery(); 
		System.out.println( "records(s) " );
		while(rs1.next()) {
			
			System.out.println("ID: " + rs1.getInt(1));
			System.out.println("Name: " +rs1.getString(2));
			System.out.println("Age: " +rs1.getInt(3));
		
			
		}
		
		System.out.println("GOODBYE NOW ");
		
		
		change.close();
		del.close();
		getname.close();
		pst.close();
		pst1.close();
		rs1.close();
		


	}

}
