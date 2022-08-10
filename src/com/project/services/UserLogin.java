package com.project.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.project.dbconnection.OpenConnection;
import com.project.interfaces.Login;

public class UserLogin implements Login{

	@Override
	public void getUserLogin() {
		try {
			OpenConnection openConnection1=new OpenConnection();
			Connection connection =openConnection1.getConnection();
			Scanner scanner = new Scanner(System.in);
			System.out.println("-------------------------");
			System.out.println("Enter your username : ");
			String userName = scanner.nextLine();
			System.out.println("-------------------------");
			System.out.println("Enter your password :");
			String password1 = scanner.nextLine();
			System.out.println("-------------------------");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from studentlogindetails where Username=? and password=?");
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password1);
			ResultSet resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next() == true) {
				System.out.println("********************************");
				 System.out.println("*****  Login Successfully  *****");
				 System.out.println("********************************"+"\n");
				 FetchQuizQuestions fetchQuizClass=new FetchQuizQuestions();
				// fetchQuizClass.getQuizQuestion();
				 InsertStudentData insertStudentData=new InsertStudentData();
				 insertStudentData.insertStudentDetails();
				 
				 FetchStudentData fetchStudentData=new FetchStudentData();
				 fetchStudentData.getStudentDetails();
				 
				 FetchParticularStudentDetails fetchParticularStudentDetails=new FetchParticularStudentDetails();
				 fetchParticularStudentDetails.getParticularStudentDetails();
				
			}else {
				System.out.println("User id and password is not valid");
			}

			
			

			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

}
