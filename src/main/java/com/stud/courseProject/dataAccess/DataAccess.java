package com.stud.courseProject.dataAccess;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DataAccess {

    public static Connection getNewConnection(){
        Connection connection=null;
        try {
            Properties properties = new Properties();
            properties.load(new FileReader("C:\\Users\\user\\Desktop\\веб\\курсач\\courseProject\\src\\main\\resources\\db.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(url,user,password);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            writeError(e);
        }
        return connection;
    }

    public static void writeError(Exception ex){
        try {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            String error = errors.toString();
            ex.printStackTrace();
            FileWriter writer = new FileWriter("C:\\Users\\user\\Desktop\\веб\\курсач\\courseProject\\src\\main\\resources\\log.txt", true);
            writer.append(error);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

