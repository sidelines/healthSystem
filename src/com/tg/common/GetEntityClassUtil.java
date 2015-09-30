package com.tg.common;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GetEntityClassUtil {
  //获取父类泛型中的参数 (参数是某个数据类型class)
	public static Class getEntityClass(Class c) {
		//得到泛型父类的类�?
		Type type = c.getGenericSuperclass();
		//判断 是否是泛�?
		if(type instanceof ParameterizedType) {
			//返回表示此类型实际类型参数的Type对象的数�?
			Type[] ptype = ((ParameterizedType)type).getActualTypeArguments();
			return (Class)ptype[0];
		} else {
			return Object.class;
		}
	}
}
