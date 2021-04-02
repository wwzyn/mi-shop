package com.dao.impl;

import com.dao.UserDao;
import com.entity.User;
import com.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl implements UserDao {
    //定义QueryRunner对象,sql语句
    QueryRunner qr = null;
    String sql = null;
    //查询用户名是否存在
    @Override
    public boolean findUserByName(String username) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "select * from user where username = ?";
            User user = qr.query(sql, new BeanHandler<User>(User.class), username);
            System.out.println(user);
            if (user!=null){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    //添加用户
    @Override
    public int addUser(User user) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "insert into user values (?,?,?,?,?,?,?,?,?,?)";
            int count = qr.update(sql,
                    user.getUid(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getName(),
                    user.getEmail(),
                    user.getTelephone(),
                    user.getBirthday(),
                    user.getSex(),
                    user.getState(),
                    user.getCode()
            );
            System.out.println("count:"+count);
            return count;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    //通过code查询用户
    @Override
    public User SelectUserByCode(String code) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "select * from user where code = ?";
            User user = qr.query(sql, new BeanHandler<User>(User.class), code);
            System.out.println("codeuser"+user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //更新用户信息(state)
    @Override
    public void updateUser(User user) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "update user set username = ?,password = ?,name = ?,email=?,telephone= ?,birthday=?,sex =?,state =? where uid = ?";
            int count = qr.update(sql, user.getUsername(), user.getPassword(), user.getName(),
                    user.getEmail(),
                    user.getTelephone(),
                    user.getBirthday(),
                    user.getSex(),
                    user.getState(),
                    user.getUid());
            System.out.println("影响了"+count);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //验证用户登录
    @Override
    public User findUserByNameAndPassword(String username) {
        try{
            qr = new QueryRunner(JdbcUtils.getDataSource());
            sql = "select * from user where username = ?";
            User user = qr.query(sql, new BeanHandler<User>(User.class), username);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
