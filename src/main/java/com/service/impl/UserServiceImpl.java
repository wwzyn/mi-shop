package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.service.UserService;
import com.utils.MailUtils;

public class UserServiceImpl implements UserService {
    //创建dao层对象
    UserDao ud = new UserDaoImpl();
    //查询用户名是否存在
    @Override
    public boolean findUserByUserName(String username) {
        return ud.findUserByName(username);
    }
    //添加用户
    @Override
    public int addUser(User user) {
        //调用dao插入数据
        int i = ud.addUser(user);
        //插入完毕之后
        //邮件工具类---给用户注册的邮箱上发送一份邮件
        MailUtils.sendMail(user.getEmail(),"你好,这是一份激活邮件," +
                " 请您<a href='http://localhost:8080/qf_mi_war/user?method=active&code="+user.getCode()+"'>点击激活</a>","用户激活!") ;
        return i;
    }
    //通过code查询用户，查询到之后将state改为1
    @Override
    public User SelectUserByCode(String code) {
        User user = ud.SelectUserByCode(code);
        //将state改为1
        user.setState(1);
        //更新用户数据
        ud.updateUser(user);
        return user;
    }

    @Override
    public User findUserByUserNameAndPassword(String username, String password) {
        User user = ud.findUserByNameAndPassword(username);
        if (password.equals(user.getPassword())){
            return user;
        }
        return null;
    }
}
