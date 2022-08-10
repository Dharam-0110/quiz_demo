package com.project.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import com.project.dbconnection.OpenConnection;
import com.project.dto.StudentData;
import com.project.interfaces.FetchData;

public class FetchStudentData implements FetchData {

	@Override
	public void getStudentDetails() {
		
		try {
			
			OpenConnection openConnection1=new OpenConnection();
			Connection connection =openConnection1.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select * from studentdata " );
			
			ResultSet resultSet=preparedStatement.executeQuery();
			//System.out.println("Reg_id\t\t Name\t\t\t\t\t\t Score\t\t ");
			System.out.printf("%10s %20s %10s","REG ID","NAME","SCORE"+"\n");
			System.out.println("-------------------------------------------------------------------------");
			ArrayList<StudentData> arrayList = new ArrayList<StudentData>();
			while(resultSet.next()) {
			
			arrayList.add(new StudentData(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
			
			
			}
			
			Collections.sort(arrayList, new ScoreComparator());
			
			for(StudentData sd : arrayList) {
				
				//System.out.print(sd.getReg_id()+"\t\t"+sd.getFirstName()+" " + sd.getLastName() +"\t\t\t\t\t" + sd.getScore()+"\t"); 
				System.out.format("%10s %20s %10s",sd.getReg_id(),sd.getFirstName()+" "+sd.getLastName(),sd.getScore()+"\n");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
