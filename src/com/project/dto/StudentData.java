package com.project.dto;

public class StudentData {
	private int StudId;
	private String Reg_id;
	private String FirstName;
	private String LastName;
	private int Score;
	
	public StudentData( String reg_id, String firstName, String lastName, int score) {
		super();
		Reg_id = reg_id;
		FirstName = firstName;
		LastName = lastName;
		Score = score;
	}
	public void setStudId(int studId) {
		StudId = studId;
	}

	

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public void setScore(int score) {
		Score = score;
	}

	public int getStudId() {
		return StudId;
	}

	public String getReg_id() {
		return Reg_id;
	}
	public void setReg_id(String reg_id) {
		Reg_id = reg_id;
	}
	public String getFirstName() {
		return FirstName;
	}

	public String getLastName() {
		return LastName;
	}

	public int getScore() {
		return Score;
	}

	@Override
	public String toString() {
		return "StudentData [StudId=" + StudId + ", Reg_id=" + Reg_id + ", FirstName=" + FirstName + ", LastName="
				+ LastName + ", Score=" + Score + "]";
	}
	
	

}
