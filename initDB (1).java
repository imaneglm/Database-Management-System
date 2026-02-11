
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class initDB {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:src/products.db"; 
        String sql = """
            CREATE TABLE IF NOT EXISTS product (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL UNIQUE,
                quantity INTEGER NOT NULL,
                category TEXT NOT NULL,
                price REAL NOT NULL,
                description TEXT NOT NULL,
                company_name TEXT NOT NULL
            );
        """;

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("✅ Table 'product' created successfully.");
        } catch (Exception e) {
            System.out.println("❌ Error creating table: " + e.getMessage());
        }
    }
}
