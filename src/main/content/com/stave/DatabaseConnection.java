package content.com.stave;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A class used to implement a connection to a DBMS. The data fields default values can be altered to change which
 * DBMS is being connected to.
 */
public class DatabaseConnection {

    public String userName;
    public String password;
    private String dbms;
    private String serverName;
    private int portNumber;
    private String dbName;

    public DatabaseConnection() {
        userName = "root";
        password = "Nightfox908";
        dbms = "mysql";
        serverName = "localhost";
        portNumber = 3306;
        dbName = "user";
    }

    /**
     * This method creates a connection to the DBMS through using the details
     * entered into the constructor. This method was made using oracles API.
     * @return Connection
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);   // add database credentials
        connectionProps.put("password", this.password);

        conn = DriverManager.getConnection( // add database connection info
                "jdbc:" + this.dbms + "://" +
                        this.serverName +
                        ":" + this.portNumber + "/" +
                        this.dbName,
                connectionProps);

        System.out.println("Successful connection to database");
        return conn;
    }
}
