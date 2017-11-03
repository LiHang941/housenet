package xyz.lihang;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc {

    private String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=housenet";
    private String user = "sa";
    private String password = "a123520";

    @Test
    public void jdbcTest ()throws Exception{
        Class.forName(driverName);
        Connection connection = DriverManager.getConnection(url,user,password);
        connection.close();
    }

}
