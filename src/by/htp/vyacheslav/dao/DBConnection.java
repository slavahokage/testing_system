package by.htp.vyacheslav.dao;

import by.htp.vyacheslav.controller.command.util.DBConfProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    private static String url = DBConfProperties.getProperty("db.url");

    private static String username = DBConfProperties.getProperty("db.login");

    private static String password = DBConfProperties.getProperty("db.password");


    private DBConnection() {

    }

    public static Connection getConnection() throws DaoException {

        if (connection != null) {
            return connection;
        }

        try{
            Class.forName(DBConfProperties.getProperty("db.driver"));
            connection = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException ex1){
            throw new DaoException(ex1);
        } catch (SQLException ex2){
            throw new DaoException(ex2);
        }


        return connection;
    }
}
