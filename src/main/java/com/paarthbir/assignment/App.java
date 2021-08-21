package com.paarthbir.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int in, userId;
        String firstName, lastName, email;
        UserDAO user = new UserDAO();
    	System.out.println("!!!!! Welcome to User CRUD Services !!!!!");
    	System.out.println("Enter the operation that you want to perform");
    	System.out.println("1. Registration");
    	System.out.println("2. Update");
    	System.out.println("3. Display data");
    	System.out.println("4. Delete");
    	System.out.println("0. Exit");
        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root", "9871856190");
        	Statement stmt = connection.createStatement();
        	do {
            	Scanner input = new Scanner(System.in);
            	in = input.nextInt();
            	switch(in) {
            	
            	case 1: 
            		System.out.println("For Registration enter ");
            		Scanner registerInput = new Scanner(System.in);
            		System.out.print("userId: ");
            		userId = registerInput.nextInt();
            		registerInput.nextLine();
            		System.out.print("firstName: ");
            		firstName = registerInput.nextLine();
            		System.out.print("lastName: ");
            		lastName = registerInput.nextLine();
            		System.out.print("email: ");
            		email = registerInput.nextLine();
            		user.saveData(connection, userId, firstName, lastName, email);
            		break;
            		
            	case 2: 
            		System.out.println("For updation enter userId, firstName, lastName, email");
            		Scanner updateInput = new Scanner(System.in);
            		userId = updateInput.nextInt();
            		updateInput.nextLine();
            		firstName = updateInput.nextLine();
            		lastName = updateInput.nextLine();
            		email = updateInput.nextLine();
            		user.updateUser(connection, stmt, userId, firstName, lastName, email);
            		break;
            	case 3: user.getAllUsers(stmt);
            		break;
            	case 4: 
            		System.out.println("For deletion enter userId");
            		Scanner deleteInput = new Scanner(System.in);
            		userId = deleteInput.nextInt();
            		deleteInput.nextLine();
            		user.deleteUser(connection, stmt, userId);
            		break;
            	}
            }while(in>0);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
        
    }
}
