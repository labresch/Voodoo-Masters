package database;

import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class project{

	private Connection con;

   // public static void main(String[] args) {
  //  	project p = new project();
//    }

    public project(){
    	
    }
    
	public void makeConnection(){
    	// Establish connection
    	connect();

    	// Script running sequence
    	try{
    		System.out.println("\nUpdating tables...");
    		execute_sql();
    		System.out.println("\nTables successfully updated!");

    		test_input();
    	}catch (IOException ex){
    		System.out.println("Message: " + ex.getMessage());
    	}catch (SQLException ex){
    		System.out.println("Message: " + ex.getMessage());
    	}
    }
    
    public List<String> getauthors(List<String> input) throws SQLException{
    	List<String> output = new ArrayList<String>();
    	
    	String s = "";
    	for (int j=0; j< input.size(); j+=2){
    		if (input.get(j).equals("name")){
    			s = "select name from author where name = '" + input.get(j+1) + "'";
    			System.out.println(s);
    		}
    		else if (input.get(j).equals("studyField")){
    			s = "SELECT name FROM author A education E WHERE E.studyField = '" + input.get(j+1) + "'";
    		}
    		else if (input.get(j).equals("institution")){
    			
    		}
    		else{
    			continue;
    		}
    		Statement st = con.createStatement();
        	ResultSet rs = st.executeQuery(s);
        	System.out.println(rs.getRow());
        	//rs.last();
        	//System.out.println(rs.getRow());
        	rs.first();
        	System.out.println(rs.getRow());
        	while (!rs.isAfterLast()){
        		System.out.println(rs.getObject(0).toString().trim());
        		System.out.println(rs.getObject(0).toString());
        		System.out.println(rs.getObject(1).toString());
        		output.add(rs.getObject(0).toString().trim());
        		output.add(rs.getObject(1).toString().trim());
        		rs.next();
        	}
    	}
    	return output;
    }

    private void test_input() throws IOException, SQLException{
    	String s = "select name from author where authorID = 12";
    	System.out.println("\n" + s.toUpperCase() + ":");
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(s);

    	rs.next();
    	System.out.println(rs.getObject(1).toString().trim());
    }

    private void execute_sql() throws IOException, SQLException{
    	ScriptRunner s = new ScriptRunner(con);
    	s.run(new FileReader(new File("db.sql")));
    }

    private void connect(){
    	// Load the Oracle JDBC driver
    	try{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		}catch (SQLException ex){
			System.out.println("Message: " + ex.getMessage());
		}

    	// connect to Oracle database
    	String con_URL = "jdbc:oracle:thin:@localhost:1521:ug";
    	String con_ID = "ora_j5u6";
    	String con_Pass = "a18257089";

    	try{
    		System.out.println("\nEstablishing connection...");
    		con = DriverManager.getConnection(con_URL, con_ID, con_Pass);
    		System.out.println("\nConnected to Oracle!");
    	}catch (SQLException ex){
    		System.out.println("Message: " + ex.getMessage());
    	}
    }
}
