import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ SQLite JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        try {
                String url = "jdbc:sqlite:src/products.db"; 
        System.out.println("🔄 Trying to connect to: " + url); // DEBUG
        Connection conn = DriverManager.getConnection(url);
        System.out.println("✅ Connection success.");
        return conn;
        } catch (SQLException e) {
            System.out.println("❌ Error in database connection: " + e.getMessage());
            return null;
        }
    }
}


