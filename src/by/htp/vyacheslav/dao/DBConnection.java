package by.htp.vyacheslav.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    private static String url = "jdbc:mysql://localhost:9000/quiz_java?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&characterEncoding=UTF-8";

    private static String username = "root";

    private static String password = "root";


    private DBConnection() {

    }

    public static Connection getConnection() throws DaoException {

        if (connection != null) {
            return connection;
        }

        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException ex1){
            throw new DaoException(ex1);
        } catch (SQLException ex2){
            throw new DaoException(ex2);
        }


        return connection;
    }
}
