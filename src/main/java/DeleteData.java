import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysqldb",
                    "root",
                    "manager"
            );

            String sql = "DELETE FROM student WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, 101);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data deleted");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}