package com.convert;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:zhangyang
 * @Date: 17:01
 * @Version 1.0
 */

//自定义日期转换器
    //自定义myConvert 实现 Convert接口
public class MyConvert  implements Converter {
    @Override
    public Object convert(Class clazz, Object obj) {
        //参数1:当前字节码文件
        //参数2:目标格式
        try {
            //创建SimpleDateFormat对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
            //解析
            Date date = sdf.parse((String) obj);
            return date ;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
