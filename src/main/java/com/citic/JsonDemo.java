package com.citic;

public class JsonDemo {

	/**
	 * 
	  * @Title toJson
	  * @Date  2017年12月20日 上午8:51:42
	  * @author xhb
	  * @Description 
	  * @param obj :需要转换为json的对象
	  * @param dateType : 对象中属性为日期的，需要转换成的格式类型默认“yyyy-MM-dd HH:mm:ss”;使用默认值传null
	  * @return json 字符串
	  * 
	  * <p>      日期1 作者名1 修改内容1  </p>
	  * <p>      日期2 作者名2 修改内容2  </p>
	 */
	public static String toJson(Object obj,String dateType){
		return null;
	}
	/**
	 * 
	  * @Title fromJson
	  * @Date  2017年12月20日 上午8:53:05
	  * @author xhb
	  * @Description 
	  * @param json :需要转换的json串
	  * @param cls : 需要转换成的对象类型，如为list、set类型需使用预定义好的值
	  * @param dateType : json串中日期类型的格式，默认为：“yyyy-MM-dd HH:mm:ss”;使用默认值传null
	  * @return
	  * 
	  * <p>      日期1 作者名1 修改内容1  </p>
	  * <p>      日期2 作者名2 修改内容2  </p>
	 */
	public static Object fromJson(String json,Class cls,String dateType){
		return null;
	}
}
