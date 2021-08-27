package task1.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfig {
    public Connection getConnection()
            throws SQLException, ClassNotFoundException {
        //Registering the HSQLDB JDBC driver
        Class.forName("org.hsqldb.jdbc.JDBCDriver");

        /* Database files will be created in the "database"
         * folder in the project. If no username or password is
         * specified, the default SA user and an empty password are used */
        // TODO Using config file to replace dbName with your dbName, user and password
        String dbName = "dbName";
        Connection con = DriverManager.getConnection
                ("jdbc:hsqldb:file:database/" + dbName, "root", "");
        return con;
    }
}
