import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/uc11";
    private static final String USUARIO = "root";
    private static final String SENHA = "";

    public Connection connectDB() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
