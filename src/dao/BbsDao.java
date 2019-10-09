package dao;

import entity.Bbs;
import entity.User;
import utils.Dbmanage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BbsDao {

    public List<Bbs> getPageList(int start, int end) {
        List<Bbs> list = new ArrayList<Bbs>();
        Dbmanage dbmanage = new Dbmanage();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dbmanage.initDB();
            statement = connection.createStatement();
            String sql = "SELECT id,title ,author ,ctime ,content,type,stas FROM bbs  LIMIT  " + start + "," + end + "";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Bbs bbs = new Bbs();
                bbs.setId(resultSet.getInt("id"));
                bbs.setTitle(resultSet.getString("title"));
                bbs.setAuthor(resultSet.getString("author"));
                bbs.setCtime(resultSet.getString("ctime"));
                bbs.setContent(resultSet.getString("content"));
                bbs.setType(resultSet.getInt("type"));
                bbs.setStat(resultSet.getInt("stas"));
                list.add(bbs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbmanage.closeDB(resultSet, statement, connection);
        }
        return list;
    }

    public Bbs getDetail(int id){
        Bbs bbs=null;
        Dbmanage dbmanage = new Dbmanage();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {

           connection = dbmanage.initDB();
           statement = connection.createStatement();
           String sql = "SELECT * FROM bbs WHERE id=" + id + "";
           System.out.println("mysql详情页:"+sql);
           resultSet = statement.executeQuery(sql);
           while(resultSet.next()){
               bbs = new Bbs();
               bbs.setId(resultSet.getInt("id"));
               bbs.setType(resultSet.getInt("type"));
               bbs.setStat(resultSet.getInt("stas"));
               bbs.setContent(resultSet.getString("content"));
               bbs.setCtime(resultSet.getString("ctime"));
               bbs.setAuthor(resultSet.getString("author"));
               bbs.setTitle(resultSet.getString("title"));
           }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(resultSet,statement,connection);
        }

        return bbs;
    }

    public void updateBbs(Bbs bbs){
        Dbmanage dbmanage = new Dbmanage();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = dbmanage.initDB();
            statement = connection.createStatement();
            String sql1 = "UPDATE bbs SET title = "+bbs.getTitle()+","+"author="+bbs.getAuthor()+","+"content="+bbs.getContent()+","+"ctime="+bbs.getCtime()+","+"type="+bbs.getType()+","+"stat="+bbs.getStat()+","+"WHERE id="+bbs.getId();
            statement.executeUpdate(sql1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(resultSet,statement,connection);
        }

    }


    public void getDelete(int id ){
        Dbmanage dbmanage = new Dbmanage();
        Connection connection = null;
        Statement statement = null;
        try{
            connection = dbmanage.initDB();
            statement = connection.createStatement();
            String sql = "UPDATE bbs SET stas = 0 WHERE id = "+id+"";
            statement.executeUpdate(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbmanage.closeDB(statement,connection);
        }

    }

}

