
/*
object oriented method of creating / encapsulation of connection,
just call method getConn() and connection will be returned, if there is no
connection, connection will be made
 */

package d_external;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCconnectionVariant {

    private Connection conn = null;
    private String url = "jdbc:mysql://localhost:3306/basicdb?useSSL=false";
    private String user = "root";
    private String password = "root";
    private static JDBCconnectionVariant instance = null;

    // creating connection in private constructor
    private JDBCconnectionVariant() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        conn = DriverManager.getConnection(url, user, password);
    }

    // checking if there is connection if there is not create new
    public static Connection getConn() throws SQLException {
        if (instance == null) {
            instance = new JDBCconnectionVariant();
        }
        return instance.conn;
    }
}
