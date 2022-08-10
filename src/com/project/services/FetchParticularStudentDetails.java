package com.project.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.project.dbconnection.OpenConnection;
import com.project.interfaces.ParticularData;

public class FetchParticularStudentDetails implements ParticularData {

	@Override
	public void getParticularStudentDetails() {
		try {
			
			OpenConnection openConnection1=new OpenConnection();
			Connection connection =openConnection1.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("Select * from studentdata where Reg_Id=?");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Please enter Student registration id :  ");
			String registrationId = scanner.nextLine();
			preparedStatement.setString(1, registrationId);

			ResultSet resultSet = preparedStatement.executeQuery();

			//System.out.println("\tName\t\t\t       Score\t\t\t Grade");
			System.out.printf("%30s %10s %10s","NAME","SCORE","GRADE"+"\n");
			System.out.println("------------------------------------------------------------------------------------");
			if (resultSet.next() == true) {
				//System.out.println("\t"+resultSet.getString(3) + " " + resultSet.getString(4) + "\t\t\t" + resultSet.getInt(5)
						//+ "\t\t\t   " + resultSet.getString(6));
						System.out.format("%30s %10s %10s", resultSet.getString(3) + " " + resultSet.getString(4),resultSet.getInt(5),resultSet.getString(6)+"\n");
			} else {
				System.out.println("Registration id is not valid");
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
