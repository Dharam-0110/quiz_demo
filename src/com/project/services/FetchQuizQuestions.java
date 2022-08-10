package com.project.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.project.dbconnection.OpenConnection;
import com.project.dto.QuestionBank;
import com.project.dto.StudentData;
import com.project.interfaces.QuestionBanks;

public class FetchQuizQuestions implements QuestionBanks {

	@Override
	public StudentData getQuizQuestion() {
		int correctAnswer = 0;
		
		StudentData studentData = null;
		try {
			OpenConnection openConnection1 = new OpenConnection();
			Connection connection = openConnection1.getConnection();
			Scanner scanner = new Scanner(System.in);
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			 
			System.out.println("***Welcome to Registration form***");
			System.out.println("Enter your Registration id :");
			 
			String reg_id = scanner.nextLine();
			
			System.out.println("Enter your name : ");
			String FirstName = scanner.nextLine();

			System.out.println("Enter your lastname :");
			String LastName = scanner.nextLine();
			System.out.println("***  Successfully Registered  ***"+"\n");
			preparedStatement = connection.prepareStatement("select * from mcq \n" + "order by rand()\n" + "limit 10");

			resultSet = preparedStatement.executeQuery();

			
		
			while (resultSet.next()) {

				ArrayList<QuestionBank> arrayList = new ArrayList<QuestionBank>();
				arrayList.add(new QuestionBank(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7)));

				for (QuestionBank qb : arrayList) {
					System.out.println("----------------------------------------------------------------------------------------------"+"\n");

					System.out.println("Qno : " + qb.getQuestionNumber());
					System.out.println("Question : " + qb.getQuestions());
					System.out.println("A : " + qb.getA());
					System.out.println("B : " + qb.getB());
					System.out.println("C : " + qb.getC());
					System.out.println("D : " + qb.getD());

				}

				System.out.println("Enter your answer : ");
				String answer = scanner.next();
				if (answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || answer.equalsIgnoreCase("C")
						|| answer.equalsIgnoreCase("D")) {
					String ans = resultSet.getString("CorrectAnswer");
					if (answer.equalsIgnoreCase(ans)) {
						correctAnswer++;
						System.out.println("Correct Answer");
						System.out.println("----------------------------------------------------------------------------------------------"+"\n");
					} else {
						System.out.println("Incorrect Answer");
					}
				} else {

					System.out.println("Please choose valid option : ");
					for (QuestionBank qb : arrayList) {
						System.out.println("----------------------------------------------------------------------------------------------"+"\n");

						System.out.println("Qno : " + qb.getQuestionNumber());
						System.out.println("Question : " + qb.getQuestions());
						System.out.println("A : " + qb.getA());
						System.out.println("B : " + qb.getB());
						System.out.println("C : " + qb.getC());
						System.out.println("D : " + qb.getD());
						System.out.println("Enter your answer : ");
						String answer1 = scanner.next();
						if (answer1.equalsIgnoreCase("A") || answer1.equalsIgnoreCase("B")
								|| answer1.equalsIgnoreCase("C") || answer1.equalsIgnoreCase("D")) {
							String ans1 = resultSet.getString("CorrectAnswer");
							if (answer1.equalsIgnoreCase(ans1)) {
								correctAnswer++;
								System.out.println("Correct Answer");
								
							} else {
								System.out.println("Incorrect Answer");
								System.out.println("----------------------------------------------------------------------------------------------"+"\n");
							}
						} else {
							System.out.println("Incorrect Answer");
							System.out.println("----------------------------------------------------------------------------------------------"+"\n");
						}
					}

				}

			}
			
			System.out.println("---------Your score count is : " + correctAnswer+"---------");
			
			studentData = new StudentData( reg_id, FirstName, LastName, correctAnswer);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return studentData;
		

	}

}
