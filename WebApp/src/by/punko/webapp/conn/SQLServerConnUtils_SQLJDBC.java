package by.punko.webapp.conn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnUtils_SQLJDBC {

    // Подключиться к SQL Server.
    // (Использовать библиотеку SQLJDBC)
    public static Connection getSQLServerConnection_SQLJDBC() //
            throws ClassNotFoundException, SQLException {

        // Примечание: Изменить параметры соединения соответствующе.
        String sqlInstanceName = "SQLEXPRESS";

        return getSQLServerConnection_SQLJDBC(sqlInstanceName);
    }

    // Подключиться к SQLServer, используя библиотеку SQLJDBC.
    private static Connection getSQLServerConnection_SQLJDBC(//
                                                             String sqlInstanceName)//
            throws ClassNotFoundException, SQLException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        // Структура URL Connection для SQLServer
        // Например:
        // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr
        String connectionURL = "jdbc:jtds:sqlserver://ALINA-ПК/Test" + ";instance=" + sqlInstanceName;

        Connection conn = DriverManager.getConnection(connectionURL);
        return conn;
    }

}
