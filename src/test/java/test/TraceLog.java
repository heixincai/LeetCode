package test;

import cn.hutool.core.date.DateUtil;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TraceLog {

    public Map equals(Object obj1, Object obj2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException {
        Map map = new HashMap <>();
        if(obj1.getClass()==obj2.getClass()){//只有两个对象都是同一类型的才有可比性
            Class clazz=obj1.getClass();
            //获取object的属性描述
            PropertyDescriptor[] pds= Introspector.getBeanInfo(clazz,Object.class).getPropertyDescriptors();
            for(PropertyDescriptor pd:pds){//这里就是所有的属性了
                String name=pd.getName();//属性名
                Method readMethod=pd.getReadMethod();//get方法
                //在obj1上调用get方法等同于获得obj1的属性值
                Object o1=readMethod.invoke(obj1);
                //在obj2上调用get方法等同于获得obj2的属性值
                Object o2=readMethod.invoke(obj2);
                if(pd.getPropertyType().toString().equals("class java.util.Date")){
                    o1=(DateUtil.format((Date)o1, "yyyy-MM-dd HH:mm:ss"));
                    o2=(DateUtil.format((Date)o2, "yyyy-MM-dd HH:mm:ss"));
                }
                if(o1 != null && o2 != null && !o1.equals(o2)){//比较这两个值是否相等,不等就可以放入map了
                    List list=new ArrayList();
                    list.add(o1);
                    list.add(o2);
                    map.put(name,list);
                }

            }
        }
        return map;
    }

}
