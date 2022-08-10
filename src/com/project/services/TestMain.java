package com.project.services;

import java.io.IOException;
import java.sql.SQLException;

import com.project.dbconnection.OpenConnection;

public class TestMain {
public static void main(String[] args) throws SQLException, IOException {
	UserLogin userLogin=new UserLogin();
	userLogin.getUserLogin();
	

}

}
