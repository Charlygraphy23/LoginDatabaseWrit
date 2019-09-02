package handeller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHandeller extends Config {

    Connection dbHandller;

    public Connection getDbHandller() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        dbHandller= DriverManager.getConnection("jdbc:mysql://"+dbHost+":"+dbport+"/"+dbName,dbUsername,dbPassword);

        return dbHandller;
    }
}
