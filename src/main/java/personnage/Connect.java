package personnage;
import java.sql.*;



public class Connect {

    public static Connection Connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:mysql://localhost:3306/jeu";
            String user = "Khaled";
            String passwd = "Itachi1089";

            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}