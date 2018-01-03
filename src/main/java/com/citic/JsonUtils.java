package com.citic;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import com.zhongyun.edusafety.zdf.json.CustomMappingException;
import com.zhongyun.edusafety.zdf.json.CustomParseException;
import com.zhongyun.edusafety.zdf.json.CustomType;

@Deprecated
public class JsonUtils {
	private final static ObjectMapper objectMapper = new ObjectMapper();
	
//	private final static XmlMapper xmlMapper = new XmlMapper();
	
//	private final static Gson gson = new GsonBuilder().
//						setDateFormat("yyyy-MM-dd HH:mm:ss").create();
				
//	private static SerializeConfig mapping = new SerializeConfig();  
	
	static {
		objectMapper.registerModule(new JaxbAnnotationModule());
//		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//		mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
	}
	/**
	 * 将对象转换为字符串
	  * @Title encode
	  * @Date  2017年12月23日 下午1:54:54
	  * @author xhb
	  * @Description 
	  * @param obj
	  * @return
	  * 
	  * <p>      日期1 作者名1 修改内容1  </p>
	  * <p>      日期2 作者名2 修改内容2  </p>
	 */
	public static String encode(Object obj){
		try {
//			return xmlMapper.writeValueAsString(obj);
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
		}
		return null;
    }
	public static String encode2(Object obj){
		try {
//			JacksonJaxbJsonProvider j = new JacksonJaxbJsonProvider();
//			j.setMapper(objectMapper);
//			return xmlMapper.writeValueAsString(obj);
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
		}
		return null;
    }
	 

    /**
     * 将json string反序列化成对象
     *
     * @param json
     * @param valueType
     * @return
     * @throws CustomParseException 
     * @throws IOException 
     * @throws CustomMappingException 
     */
    public static <T> T decode(String json, Class<T> valueType){
    	try {
//    		return xmlMapper.readValue(json, valueType);
			return objectMapper.readValue(json, valueType);
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
    	return null;
    }

    /**
     * 将json array反序列化为对象
     *
     * @param json
     * @param jsonTypeReference
     * @return
     * @throws CustomParseException 
     * @throws IOException 
     * @throws CustomMappingException 
     */
    public static <T> T decode(String json, CustomType<T> customType){
    	    	
		try {
//			return (T)xmlMapper.readValue(json, customType);
			return (T) objectMapper.readValue(json, customType);
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
		} catch (IOException e) {
		}
		return null;
    }
    
    /**
     * 将json array反序列化为对象
     *
     * @param json
     * @param jsonTypeReference
     * @return
     */
//    @SuppressWarnings("unchecked")
//    public static <T> T decode(String json, CustomTypeFastJson<T> customType)throws CustomException{   	
//		return (T)JSON.parseObject(json,customType);
//    }
    
    /**
     * 将json array反序列化为对象
     *
     * @param json
     * @param jsonTypeReference
     * @return
     */
//    @SuppressWarnings("unchecked")
//    public static <T> T decode(String json, CustomTypeGson<T> customType)throws CustomException{
//    	Gson gson = new GsonBuilder().create();
//    	return (T)gson.fromJson(json, customType.getType());
//     }
}
