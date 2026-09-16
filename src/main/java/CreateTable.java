import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateTable {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysqldb",
                    "root",
                    "manager"
            );

            String sql = "CREATE TABLE student (id INT PRIMARY KEY, name VARCHAR(60), email VARCHAR(100))";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();

            System.out.println("Table created");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}