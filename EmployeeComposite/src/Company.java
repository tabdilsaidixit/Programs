// A Java program to demonstrate working of 
// Composite Design Pattern with example 
// of a company with different 
// employee details 

import java.util.ArrayList; 
import java.util.List; 

public class Company 
{ 
	public static void main (String[] args) 
	{ 
		Developer dev1 = new Developer(100, "Lokesh Sharma", "Pro Developer"); 
		Developer dev2 = new Developer(101, "Vinay Sharma", "Developer"); 
		CompanyDirectory engDirectory = new CompanyDirectory(); 
		engDirectory.addEmployee(dev1); 
		engDirectory.addEmployee(dev2); 
		
		Manager man1 = new Manager(200, "Kushagra Garg", "SEO Manager"); 
		Manager man2 = new Manager(201, "Vikram Sharma ", "Kushagra's Manager"); 
		
		CompanyDirectory accDirectory = new CompanyDirectory(); 
		accDirectory.addEmployee(man1); 
		accDirectory.addEmployee(man2); 
	
		CompanyDirectory directory = new CompanyDirectory(); 
		directory.addEmployee(engDirectory); 
		directory.addEmployee(accDirectory); 
		directory.showEmployeeDetails(); 
	} 
} 
