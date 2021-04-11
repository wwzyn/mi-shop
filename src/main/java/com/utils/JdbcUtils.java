package com.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
    public static Connection conn;
    public static DataSource dataSource;
    //创建本地线程对象
    private static  ThreadLocal<Connection>t  = new ThreadLocal<Connection>() ;
    //获取DataSource对象
    static{
        try {
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    /*public static Connection getConnection() {
        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            System.out.println("获取连接对象出错");
            throwables.printStackTrace();
        }
        System.out.println(conn);
        return conn;
    }*/
   //获取连接对象
   public static Connection getConnection(){
       Connection conn = null ;
       try{
           //从本地线程中获取Connection
           conn = t.get();
           //如果当前conn为null,从连接池获取Connection
           if(conn==null){
               conn = dataSource.getConnection();
               //将从连接池获取到Connection对象绑定到线程中
               t.set(conn);
               return conn ;
           }
       }
       catch (SQLException e){
           e.printStackTrace();
       }
       return null ;
   }
    //释放资源
    public static void close(Statement stmt, Connection conn){
        close(null,stmt,conn);
    }
    //封装释放资源的功能
    //如果当前有查询对象ResulSet,有执行对象Statement,有连接对象Connection
    public static void  close(ResultSet rs, Statement stmt, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //开启事务
    public static void startTransaction() throws SQLException {
        conn = getConnection();
        conn.setAutoCommit(false);
    }
    //事务提交并释放资源
    public static void commitAndClose(){
        try{
            //提交
            conn.commit();
            //关闭
            conn.close();
            //解除线程绑定
            t.remove();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
