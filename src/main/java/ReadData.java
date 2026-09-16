import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReadData {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mysqldb",
                    "root",
                    "manager"
            );

            String insertSql = "INSERT INTO student (id, name, email) VALUES (?, ?, ?)";

            PreparedStatement ps1 = con.prepareStatement(insertSql);

            ps1.setInt(1, 101);
            ps1.setString(2, "Rahul");
            ps1.setString(3, "rahul@gmail.com");

            ps1.executeUpdate();

            System.out.println("Data inserted");

            String selectSql = "SELECT * FROM student";

            PreparedStatement ps2 = con.prepareStatement(selectSql);
            ResultSet rs = ps2.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email")
                );
            }

            rs.close();
            ps1.close();
            ps2.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}