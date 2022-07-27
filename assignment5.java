package com.marlon.assignments;

import java.util.ArrayList; 
import java.util.Comparator;
import java.util.Iterator;
import java.util.List; 
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * create a class Employee and the properties of an Employee are id,name,age,gender,dept,yearofjoining,salary;

Based on the above context:
Based on the questions try to create hard coded data; User only java 8 features

i) How many male and female employees are there in this organization?

ii) Find out Average age of male and female emps?

iii) Find the highest paid employee in this org?

iv) List all the names of employee who has joined after 2015?

v) Find out the senior most employee in this org?

vi)Count the number of emps in each department?

vii)Find male and female employees are in Maintenance department?

viii) Find  the average salary of male and female employees?

ix) Differentiate the employees who are younger or equal to 30 yrs from those employees	who older than 25 years

x) List down the names of all employees in each department?
 * 
 * 
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee{
	
	int id;
	String name; 
	int age;
	String gender;
	String dep;
	int yearOfJoinging;
	double salary; 
	
	
}



public class assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> list = new ArrayList<>();
		
		//adding the new employees 
		list.add(new Employee(1,"Marlon",28,"Male","Software",2022, 60000)); 
		list.add(new Employee(2,"Chris",25,"Male","Software",2021, 60000)); 
		list.add(new Employee(3,"Rob",28,"Male","HR",2020, 75000)); 
		list.add(new Employee(4,"Sarah",38,"Female","HR",2019, 80000)); 
		list.add(new Employee(5,"Myra",28,"Female","Developer",2020, 78000)); 
		list.add(new Employee(6,"Josh",30,"Male","Security",2021, 75000)); 
		list.add(new Employee(7,"Jannet",26,"Female","IT",2022, 60000)); 
		list.add(new Employee(8,"Leslie",26,"Female","HR",2021, 65000)); 
		
		//part 1 
		// employees counting them all 
		Map<String, Long> employeeCount = list.stream()
				.collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
		System.out.println("Total # of Males and Female: " + employeeCount);
		
		//part 2 
		// this will get the average of males and females
		Map<String, Double> avrgGenderAge = list.stream().collect(Collectors.groupingBy(e->e.getGender(), Collectors.averagingDouble(e->e.getAge())));
		System.out.println("The Average Age of employees is: " + avrgGenderAge);
		
		//part 3 
		//this will find the highest salary member 
		Employee highestSalary = list.stream().max(Comparator.comparing(e->e.getSalary())).get(); 
		System.out.println(highestSalary);
		
		//part 4 
		// this will list all the employees who joined after 2015
		
		

	}

}
