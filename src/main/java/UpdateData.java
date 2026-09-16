import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysqldb",
                    "root",
                    "manager"
            );

            String sql = "UPDATE student SET name = ?, email = ? WHERE id = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Amit");
            ps.setString(2, "amit@gmail.com");
            ps.setInt(3, 101);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data updated");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}