package com.project.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.dbconnection.OpenConnection;
import com.project.dto.StudentData;
import com.project.interfaces.InsertData;

public class InsertStudentData implements InsertData {

	@Override
	public void insertStudentDetails() {
		FetchQuizQuestions fetchQuizQuestions = new FetchQuizQuestions();
		StudentData studentData = fetchQuizQuestions.getQuizQuestion();

		try {
			OpenConnection openConnection1 = new OpenConnection();
			Connection connection = openConnection1.getConnection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("insert into StudentData (Reg_id,FirstName,LastName,Score)values(?,?,?,?)");
			preparedStatement1.setString(1, studentData.getReg_id());
			preparedStatement1.setString(2, studentData.getFirstName());
			preparedStatement1.setString(3, studentData.getLastName());
			preparedStatement1.setInt(4, studentData.getScore());

			preparedStatement1.executeUpdate();

			PreparedStatement preparedStatement2 = connection
					.prepareStatement("update studentdata set Grade=?  where FirstName=? and LastName=?");
			System.out.println("*****************");
			if (studentData.getScore() >= 8) {

				System.out.println("Your grade is  A");

				preparedStatement2.setString(1, "A");

				preparedStatement2.setString(2, studentData.getFirstName());
				preparedStatement2.setString(3, studentData.getLastName());
				preparedStatement2.executeUpdate();

			} else if (studentData.getScore() >= 6 && studentData.getScore() <= 8) {

				System.out.println("Your grade is B");

				preparedStatement2.setString(1, "B");
				preparedStatement2.setString(2, studentData.getFirstName());
				preparedStatement2.setString(3, studentData.getLastName());
				preparedStatement2.executeUpdate();

			} else if (studentData.getScore() == 5) {
				System.out.println("Your grade is C");

				preparedStatement2.setString(1, "C");
				preparedStatement2.setString(2, studentData.getFirstName());
				preparedStatement2.setString(3, studentData.getLastName());
				preparedStatement2.executeUpdate();

			} else {
				System.out.println("Your grade is D");
				preparedStatement2.setString(1, "D");
				preparedStatement2.setString(2, studentData.getFirstName());
				preparedStatement2.setString(3, studentData.getLastName());
				preparedStatement2.executeUpdate();

			}
			System.out.println("*****************");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
