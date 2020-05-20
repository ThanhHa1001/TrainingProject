package repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseRepository {
    private static final Logger logger = LoggerFactory.getLogger(BaseRepository.class);

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/trainingmanager", "root", "Abcd@1234");

        } catch (ClassNotFoundException e) {
            logger.error("ClassNotFoundException", e);
        } catch (SQLException e) {
            logger.error("SQLException", e);
        }

        return conn;
    }
}