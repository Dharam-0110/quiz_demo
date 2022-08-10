package com.project.dto;

public class QuestionBank {
	

	int QuestionNumber;
	String Questions;
	String A;
	String B;
	String C;
	String D;
	String CorrectAnswer;
	
	public QuestionBank(int questionNumber, String questions, String a, String b, String c, String d,
			String correctAnswer) {
		super();
		QuestionNumber = questionNumber;
		Questions = questions;
		A = a;
		B = b;
		C = c;
		D = d;
		CorrectAnswer = correctAnswer;
	}

	public int getQuestionNumber() {
		return QuestionNumber;
	}

	public String getQuestions() {
		return Questions;
	}

	public String getA() {
		return A;
	}

	public String getB() {
		return B;
	}

	public String getC() {
		return C;
	}

	public String getD() {
		return D;
	}

	public String getCorrectAnswer() {
		return CorrectAnswer;
	}

	@Override
	public String toString() {
		return "QuestionBank [QuestionNumber=" + QuestionNumber + ", Questions=" + Questions + ", A=" + A + ", B=" + B
				+ ", C=" + C + ", D=" + D + ", CorrectAnswer=" + CorrectAnswer + "]";
	}
	
	
	
	
	
	
	
	

}
