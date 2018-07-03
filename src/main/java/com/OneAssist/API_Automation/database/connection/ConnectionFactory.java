package com.OneAssist.API_Automation.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.OneAssist.API_Automation.helperClasses.URLProvider;


public class ConnectionFactory {
    private String URL;
    private String USER;
    private String PASSWORD;
    private String DRIVER_CLASS;
    
    public ConnectionFactory() {
    	
    	if("QA4".equals(URLProvider.projectEnv)) {
    		URL = URLProvider.getDBURL();
            USER = URLProvider.getDBUserName("");
            PASSWORD = URLProvider.getDBPassword("");
            DRIVER_CLASS = "com.mysql.jdbc.Driver";
    		
        }
    }

    
    public Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            System.out.println("-----Driver Class not found---------");
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if(connection==null)
                System.out.println("Connection failed!");
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }
    
    public Connection getConnection(String dbName) {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            System.out.println("-----Driver Class not found---------");
            e.printStackTrace();
        }
        Connection connection = null;
        try {
        	URL = URL+"/" + dbName;
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if(connection==null)
                System.out.println("Connection failed!");
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }
}
