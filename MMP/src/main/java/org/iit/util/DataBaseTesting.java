package org.iit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataBaseTesting {
    //Command Line Command to create table and test databse
	
	//show databases;  --This query will show all the datbases available
	//use mysql ; --This query is used to select mysql database
	//create database testdb; --This will create new database testdb
	//use testdb;  -- Will point to testDb database 
	//create table MMPLogin (pUname varchar(20),pPwd varchar(20),text varchar(20); --Will create new table in testdb database with 3 columns (pUname & pPwd & textand these 3 fields will take String of 20 charcters)(since we did "use testDb" , this datbase is pointed )
	//describe MMOLogin;  - will show all the columns(field) , datatype of the fields)
	//insert into MMPLogin values("ria1","Ria12345","ria1"); this will insert values in the columns
	//insert into MMPLogin(text,pUname,pPwd) values("ria1","ria1","Ria12345"); this will insert value int he respective columns
	//select * from MMPLogin;  -- will show you all the data in this table
	
	// Calling getDBValue method and passing database url ,username,pwd, database name ,table name 
	//and this method will return 2 dimension array, which will be passed to test via dataProvider
	
	public String[][] feedDP() throws Exception {
		String data[][] = getDBValues("jdbc:mysql://localhost:3306/testdb", "root", "admin", "testDataBase", "MMPLogin");
		return data;

	}

	
	
	// Method to get data from any database and this method will return data in
	// two dimensional array

	// String url = "jdbc:mysql://localhost:3306/testdb";
	// String username = "root";
	// String pwd = "admin";
	public String[][] getDBValues(String url, String username, String pwd, String dbName, String tableName)
			throws Exception {
        
		Class.forName("com.mysql.cj.jdbc.Driver");

		// getConnection method of DriverManager is used to extablish connection
		// with data base.Data base url will be of format
		// "jdbc:subprotocol:subname" and for extablishing connection you will
		// need username and password of database
		//This will give connection Object - con
		Connection con = DriverManager.getConnection(url, username, pwd);
		
		//Using this connection Object we create statmenet object to execute query and decide 
		//result set which is result of execution
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		// Below 2 statement are used to Insert data in table which can be done
		// manually via command line
		
		// int value = stmt.executeUpdate("INSERT INTO `testdb`.`login` VALUES
		// ('java','java123#');");
		// System.out.println("The rows are upated "+ value);

		//commandFinal will be a query slect * from dbName.tableName
		String query1 = "Select * from %dbName%.%tableName%";
		String query2 = query1.replace("%dbName%", dbName);
		String sqlQuery = query2.replace("%tableName%", tableName);
		
		//We are executing  SQL query
		//stmt.executeQuery(select *from dbName.table) will execute this query and results will be stored in Resultset object
		ResultSet rs = stmt.executeQuery(sqlQuery);

		//pointing to the last row .By default it points to first row.
		rs.last();
		//now getting row number of last row , which will be same as total number of rows as row starts from 1.
		int rows = rs.getRow();
		System.out.println("Number of rows " + rows);
        
		//getMetaData() method will have all the properties of result set columns
		ResultSetMetaData rsmd = rs.getMetaData();
		//Total column number in result set
		int cols = rsmd.getColumnCount();
		System.out.println("Number of cols: " + cols);
       
		//Declaring 2 dimensional array
		String data[][] = new String[rows][cols];
         
		//Row Number and Column number of Result set will atrt from 1 . But in data[][] we will be storing data from index 0 i.e data[0][0]
		int i = 0;
		//pointing resultset cursor before first row
		rs.beforeFirst();
		
		while (rs.next()) {
			for (int j = 0; j < cols; j++) {
				data[i][j] = rs.getString(j + 1);
				System.out.println(data[i][j]);
			}
			i++;
		}
		return data;
	}
}

	