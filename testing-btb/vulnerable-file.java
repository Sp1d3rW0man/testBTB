import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableClass {
    public static void main(String[] args) {
        String userInput = "some_user_input"; // this should come from user input
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM users WHERE username = '" + userInput + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
