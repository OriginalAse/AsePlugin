package me.rishabhvenu.aseplugin.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import me.rishabhvenu.aseplugin.database.mysql.DataType;
import me.rishabhvenu.aseplugin.database.mysql.Table;

public class MySQL {
    public static Connection makeConnection(String host, int port, String database, String username, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password);
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean ifTableExists(Connection conn, String tableName) {
        try {
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet rs = dbm.getTables(null, null, tableName, null);
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Table createTable(String table) {
        return new Table(table);
    }

    public static String getTableQuery(Table table) {
        StringBuilder query = new StringBuilder("CREATE TABLE " + table + "(");
        Map<String, Map<DataType, String[]>> columns = table.getColumns();
        for (String key : columns.keySet()) {
            Map<DataType, String[]> column = columns.get(key);
            query.append(table.getName()).append(" ").append(column.keySet().toArray()[0]);
            String[] params = (String[])column.entrySet().toArray()[0];
            if (params.length > 0)
                bracketQueryBuilder(params, query);
            query.append(",");
        }
        return query.append(")").toString();
    }

    public static ResultSet selectQuery(Connection conn, String table, String select, String column, String value) {
        String query = "SELECT " + select + " FROM " + table + " WHERE " + column + "=\"" + value + "\"";
        return executeQuery(conn, query);
    }

    public static void executeInsert(Connection conn, String table, String[] columns, String[] values) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(table).append(" ");
        if (columns.length > 0)
            bracketQueryBuilder(columns, sb);
        sb.append("VALUES (");
        boolean comma = false;
        for (String val : values) {
            if (comma) {
                sb.append(" ,\"").append(val).append("\"");
            } else {
                sb.append("\"").append(val).append("\"");
            }
            comma = true;
        }
        sb.append(")");
        executeStatement(conn, sb.toString());
    }

    private static void bracketQueryBuilder(String[] columns, StringBuilder sb) {
        sb.append("(");
        boolean comma = false;
        for (String column : columns) {
            if (comma) {
                sb.append(", ").append(column);
            } else {
                sb.append(column);
            }
            comma = true;
        }
        sb.append(") ");
    }

    public static void executeStatement(Connection conn, String query) {
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(Connection conn, String query) {
        try {
            Statement statement = conn.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
