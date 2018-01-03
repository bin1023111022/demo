package com.citic;



import java.util.List;

import com.zhongyun.edusafety.zdf.json.CustomProcessingException;
import com.zhongyun.edusafety.zdf.json.JsonUtils;

public class JsonTest {
	public static void main(String[] args) {
		TestBean tb = new TestBean();
		tb.setName("test");
		tb.setAge(1);
		String [] stt = new String[]{"1","2","3","4","5"};
		try {
//			String js = JsonUtils.encode(tb);
//			
//			
//			JSONObject obj = new JSONObject(js);
			
			String js = JsonUtils.encode(stt);
			
			List<Integer> ls = JsonUtils.decode(js, List.class);
			
			
			System.out.println(ls);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
