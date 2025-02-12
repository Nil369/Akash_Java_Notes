package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {
    public Connection connection;
    public Statement statement;

    public DBConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                        .getConnection("jdbc:mysql://localhost:3306/employee_management","root","root");
            statement = connection.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
