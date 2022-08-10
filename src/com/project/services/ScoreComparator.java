package com.project.services;

import java.util.Comparator;

import com.project.dto.StudentData;

public class ScoreComparator implements Comparator<StudentData> {

	@Override
	public int compare(StudentData s1, StudentData s2) {
		if(s1.getScore() == s2.getScore()) 
			return 0;
		else if(s1.getScore() < s2.getScore())
			return 1;
		else 
			return -1;
	}

}
