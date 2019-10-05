package dao;

import entity.User;
import utils.Dbmanage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {


    public User getLogin(String name,String password){
        Dbmanage dbmanage = new Dbmanage();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = dbmanage.initDB();
            statement = connection.createStatement();
            String sql = "SELECT uname ,upwd FROM  users WHERE uname= '" + name + "'  AND upwd= '" + password + " '";
            System.out.println("登陆mysql:"+sql);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                user = new User();
                user.setName(resultSet.getString("uname"));
                user.setPassword(resultSet.getString("upwd"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(resultSet,statement,connection);
        }
        return user;
    }


    public void addUser(String name,String password){
        Dbmanage dbmanage = new Dbmanage();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = dbmanage.initDB();
            statement = connection.createStatement();
            String sql = "  INSERT INTO users (uname ,upwd )VALUES('"+name+"','"+password+"')";
            statement.executeUpdate(sql);
            System.out.println("注册mysql:"+sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(statement,connection);
        }
    }

    public  void updatePwd(String name,String password,String newpassword){
        System.out.println("修改密码mysql:");
        Dbmanage dbmanage = new Dbmanage();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = dbmanage.initDB();
            statement = connection.createStatement();
            String sql = "UPDATE users SET upwd = '"+newpassword+"'"+"WHERE uname = '"+name+"'";
            statement.executeUpdate(sql);
            System.out.println("修改密码mysql:"+sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(statement,connection);
        }
    }

}
