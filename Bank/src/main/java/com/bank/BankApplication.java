package com.bank;

import java.sql.*;
import java.io.*;

//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class BankApplication { 
//
//	public static void main(String[] args) {
//		SpringApplication.run(BankApplication.class, args);
//		System.out.println("Done ✅✔️✅");
//	}
//}
public class BankApplication {
	
	static void create() throws ClassNotFoundException ,IOException, SQLException  {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","1234");
		
		Statement ps=(Statement) con.createStatement();
		String q1 ="create database jdbc_demo ";
		ps.executeUpdate(q1);
		String q2="use jdbc_demo";
		System.out.println("created");
		ps.executeUpdate(q2);
		System.out.println("used");
		String q3="create table employee (id int primary key ,name varchar(50),city varchar(50))";
		ps.executeUpdate(q3);
		System.out.println("done");
	}
	static void insert() throws ClassNotFoundException ,IOException, SQLException {
		String query ="insert into employee (id , name , city , image) values (?,?,?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","1234");
		
		try {
			con.setAutoCommit(false);
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, 1);
		ps.setString(2, "adnan");
		ps.setString(3, "Up");
		// for image

FileInputStream fis = new FileInputStream("C:\\Users\\user\\Downloads\\Music\\img.jpg");
		 ps.setBinaryStream(4, fis, fis.available());
		
		int i=ps.executeUpdate();
		con.commit();
		System.out.println("INSERT SUCCESSFULL committed ");
		ps.close();
		con.close();
		}
			catch(SQLException e) {
				con.rollback();
				System.out.println("Error Rollback completed");
		        e.printStackTrace();
			}
		}
	static void update()throws ClassNotFoundException ,IOException, SQLException  {
		
		String query ="update employee set id=1 where name ='KK'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","1234");
		PreparedStatement ps=con.prepareStatement(query);
		String useDB="use jdbc_demo";
		ps.executeUpdate(useDB);
		ps.executeUpdate();
		System.out.println("done");
		ps.close();
		con.close();
	}
	
	static void delete()throws ClassNotFoundException ,IOException, SQLException  {
		
		String query ="delete from employee where id=1";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","1234");
		PreparedStatement ps=con.prepareStatement(query);
		String useDB="use jdbc_demo";
		ps.executeUpdate(useDB);
		ps.executeUpdate();
		System.out.println("done");
		ps.close();
		con.close();
		
	}
	
	static void fetch()throws ClassNotFoundException, IOException, SQLException {
		    String query = "SELECT id, name, city FROM employee";
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_demo","root","1234");
		    PreparedStatement ps = con.prepareStatement(query);
		    ResultSet rs = ps.executeQuery();
		    System.out.println("ID             NAME             CITY             IMAGE");
		    while (rs.next()) {
		        int id = rs.getInt("id");
		        String name = rs.getString("name");
		        String city = rs.getString("city");
		        Blob image = rs.getBlob("image");
		        System.out.println(id + "             " + name + "             " + city+ "             ");
		        
		    }
		    rs.close();
		    ps.close();
		    con.close();
		
	}
	
	
	
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 System.out.println(" 1.CREATE DB                2.INSERT \n");
  	   System.out.println(" 3.FETCH(READ)           4.UPDATE           \n");
  	   System.out.println(" 5.DELETE                6.Exit");
  		int choice=Integer.parseInt(br.readLine());
  		switch(choice) { 
  		
  		case 1: create();
  		    break;
  		case 2: insert();
  			break;
  		case 3: fetch();
  		    break;
  		case 4: update();
  		    break;
  		case 5: delete();
  		    break;
  		
  		}
           
    }
	}