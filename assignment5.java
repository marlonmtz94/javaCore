package com.marlon.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List; 
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	int yearOfJoining;
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
		list.add(new Employee(8,"Leslie",26,"Female","Maintenance",2021, 65000)); 
		
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
		List<String> joined = list.stream().filter(e -> e.getYearOfJoining() > 2015).map(e->e.getName()).collect(Collectors.toList());
		System.out.println("Employees who joined after 2015 are: "+ joined);
		
		//part 5 
		// this will find the most senior in the employees, this will work if all the Years are UNIQUE ONLY 
		Employee senior = list.stream().min(Comparator.comparing(e -> e.getYearOfJoining())).get();
		System.out.println("The Senior is: " + senior.getName());	
		//I was trying to get multiple seniors if there were multiple people with the same year of joined but cant seem to get it to work  
		/*
		Map<String,Integer> mine = list.stream()
				.collect(Collectors.groupingBy(e->e.getName(), Collectors.minBy(e->e.getYearOfJoining()))); 
		
		list.stream().filter(e->e.getYearOfJoining() < 2015).map(e->e.getName()).collect(Collectors.toList()); 
		*/
	
		//part 6
		// will count the number of employees for each department
		Map<String, Long> departmentCount = list.stream()
				.collect(Collectors.groupingBy(Employee::getDep, TreeMap::new, Collectors.counting()));
		departmentCount.forEach((dep, count) -> System.out.println("Department: " + dep + "  Count: " + count));
		
		//part 7 
		// this will find all Maintenance employees 
		Map<String, Long> maintenceCount = list.stream()
				.filter(e -> e.getDep().equals("Maintenance"))
				.collect(Collectors.groupingBy(g -> g.getGender(), TreeMap::new, Collectors.counting()));
		maintenceCount.forEach((gender,count) -> System.out.println("Males and Females in Maintenance Department: " +gender+" : "+count));
		
		//part 8 
		// this will get the average of all employees salaries 
		Map<String, Double> averageSalary = list.stream().collect(
				Collectors.groupingBy(Employee::getGender, TreeMap::new, Collectors.averagingDouble(Employee::getSalary)));
		averageSalary.forEach((gender, avgSal) -> System.out.println("This is the average salary based on genders: " + gender + " : " + avgSal));
		
		//part 9
		// this will get employees under 30 and employees over 25
		List<Employee> under30 = list.stream().filter(e -> e.getAge() <= 30).collect(Collectors.toList());
		List<Employee> over25 = list.stream().filter(e -> e.getAge() >=25).collect(Collectors.toList());
		System.out.println("Employees under 30: " + under30);
		System.out.println("Employees over 25: " + over25);
		
		//part 10 
		// this will get the names of employees in each department
		Map<String, List<Employee>> namesofDep = list.stream().collect(Collectors.groupingBy(Employee::getDep));
		namesofDep.forEach((dep, names) -> System.out
				.println("" + dep + " : " + names.stream().map(Employee::getName).collect(Collectors.toList())));
	
	}

}
