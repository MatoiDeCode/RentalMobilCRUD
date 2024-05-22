package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Database connection utility class
 *
 * Provides a method to establish a connection to the MySQL database.
 */
public class koneksi {

    public static Connection Koneksi() {
        Connection koneksi = null;
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/rental_mobil", "root", "");
        } catch (ClassNotFoundException e) {
            // Handle the error where the JDBC driver class is not found
            JOptionPane.showMessageDialog(null, "Database Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            // Handle SQL errors
            JOptionPane.showMessageDialog(null, "Failed to connect to database: " + e.getMessage());
        }
        return koneksi;
    }
}
