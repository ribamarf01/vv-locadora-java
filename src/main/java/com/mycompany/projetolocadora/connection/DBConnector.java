package com.mycompany.projetolocadora.connection;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnector {
    private static final String user = "root";
    private static final String password = "";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_locadora";

    private static MysqlDataSource dataSource;

    static {
        try {
            dataSource = new MysqlDataSource();
            dataSource.setUrl(DB_URL);
            dataSource.setUser(user);
            dataSource.setPassword(password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}