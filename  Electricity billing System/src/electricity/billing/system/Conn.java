package electricity.billing.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load the JDBC driver (this is optional for recent JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish the database connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebss", "root", "123456");
            
            // Create a Statement object
            s = c.createStatement();
            
        } catch (ClassNotFoundException | SQLException e) {
            // Handle exceptions more gracefully
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Method to close resources
    public void close() {
        try {
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error closing resources: " + e.getMessage());
        }
    }
}
