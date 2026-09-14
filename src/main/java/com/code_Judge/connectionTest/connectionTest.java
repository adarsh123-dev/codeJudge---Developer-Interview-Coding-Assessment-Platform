package com.code_Judge.connectionTest;

import java.sql.Connection;

import com.code_Judge.connection.MyJdbcConnection;

public class connectionTest {
	
	 public static void main(String[] args) {

	        try {

	            Connection connection =
	                    MyJdbcConnection.getConnection();

	            System.out.println("Database connected successfully!");

	            connection.close();

	        } catch (Exception e) {

	            e.printStackTrace();
	        }
	    }



}



