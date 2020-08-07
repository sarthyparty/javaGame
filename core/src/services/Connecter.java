package services;

import java.sql.*;

public class Connecter {

    public Connecter() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mariadb://192.168.1.38:3306/DB?user=gamePlayer&password=libandgdxroid123");
    }
}
