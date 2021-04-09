package com.utils;

import com.service.UserService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

public class MyFactoryBean {
    private MyFactoryBean(){} //构造方法私有化

    //提供静态功能
    public static Object getBean(String id) { //参数为 beans.xml的id标识符 "userService"


        try {
            //使用dom4j创建解析器对象
            SAXReader saxReader = new SAXReader() ;

            //读取配置文件
            //获取类路径下的beans.xml文件所在的输入流对象
            InputStream inputStream = MyFactoryBean.class.getClassLoader().getResourceAsStream("beans.xml");


            //通过解析器对象将文件内容读取---返回文档对象:代表xml整个文件
            Document doc = saxReader.read(inputStream);

            //利用jaxen---xpath语法定位支持
            //快速定位的bean标签上
            //参数:指定xpath表达式
            //不分层级关系选中bean标签---带id属性的bean标签
            //Node表示节点---->Element标签子节点:元素节点
            Element element = (Element) doc.selectSingleNode("//bean[@id='" + id + "']");

            //获取class属性
            String classValue = element.attributeValue("class");//全限定名称
            System.out.println(classValue);
            //反射:创建当前类的对象
            Class clazz =  Class.forName(classValue) ;
            //创建该类实例
            Object obj =  clazz.newInstance() ;
            System.out.println(obj);
            return obj ;
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null ;
    }

    public static void main(String[] args) {

        UserService userService = (UserService) MyFactoryBean.getBean("userService");

        System.out.println(userService); //通过全限定名称---创建该类对象
    }
}
