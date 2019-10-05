package utils;

import java.sql.*;

public class Dbmanage {

    public Connection initDB(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/newtime?useSSL=false&serverTimezone=GMT%2B8";
            connection = DriverManager.getConnection(URL,"root","1212");
        }catch (Exception e){
            e.printStackTrace();
        }
        return  connection;
    }

    public void closeDB(Statement sta, Connection conn) {
        try {
            sta.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //关闭有结果集
    public void closeDB(ResultSet rs, Statement sta, Connection conn) {
        try {
            rs.close();
            sta.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
