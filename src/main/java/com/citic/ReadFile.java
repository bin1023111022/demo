package com.citic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {
	public static void tReadFile (){
		long bgTime = System.currentTimeMillis();
		String tranList = "IND16080401ACOM";
		String sumList = "INO16080499SUM";
		 File file = new File("C:/Users/Admin/Downloads/8.4/"+sumList);  
	        // BufferedReader:从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。  
	        BufferedReader buf = null;  
	        try{  
	            // FileReader:用来读取字符文件的便捷类。  
	            buf = new BufferedReader(new FileReader(file));  
	            // buf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));  
	            String temp = null ; 
	            String flag = "T";
	            while ((temp = buf.readLine()) != null ){  
	            	
	            	if(temp.startsWith("PREAUTH")){
	            		String PREAUTH_COMPLETE = temp;
	            		buf.readLine();
	            		String AUTHCOMPLETE_CANCEL = buf.readLine();
	            		buf.readLine();
	            		String RETAIL_PURCHASE = buf.readLine();
	            		buf.readLine();
	            		String CONSUME_CANCEL = buf.readLine();
	            		buf.readLine();
	            		String STLM_ADVICE = buf.readLine();
	            		buf.readLine();
	            		String MERCHANDISE_RETURN  = buf.readLine();
	            		System.out.println(PREAUTH_COMPLETE+"\n"+AUTHCOMPLETE_CANCEL
	            				+"\n"+RETAIL_PURCHASE
	            				+"\n"+CONSUME_CANCEL+"\n"+STLM_ADVICE+"\n"
	            				+MERCHANDISE_RETURN);
	            		return;
	            	}
	            	
//	            		String [] data = temp.split("\\s+");
	            		
	            		
	            		
	            		
	            		
	            		
	            		
//	            		String[] dat = finishingData(data);
//	            		String f = dat[0];
//	            		if("FI".equals(f)){
//	            			if("F".equals(flag)){
//	            				flag = "T";
//	            			}else{
//	            				flag = "F";
//	            			}
//	            			
//	            		}
//	            		if("RI".equals(f)){
//	            			if("R".equals(flag)){
//	            				flag = "T";
//	            			}else{
//	            				flag = "R";
//	            			}
//	            		}
//	            		
//	            		if("F".equals(flag)){
//	            			System.out.println("F"+Arrays.toString(dat));
//	            		}
//	            		if("R".equals(flag)){
//	            			System.out.println("R"+Arrays.toString(dat));
//	            		}
//	            		if("T".equals(flag)){
//	            			System.out.println("T"+Arrays.toString(dat));
//	            		}
	            		
//	            		System.out.println(Arrays.toString(data));  
	            }  
	        }catch(Exception e){  
	            e.getStackTrace();  
	        }finally{  
	            if(buf != null){  
	                try{  
	                    buf.close();  
	                } catch (IOException e) {  
	                    e.getStackTrace();  
	                }  
	            }  
	        }  
	}
	
	public static String[] finishingData(String [] data){
		int len = data.length;
		if(len<2){
			return new String[]{"D"};
		}else{
			if(data[0].startsWith("INSTITUTION")){//机构号 日期
				String id = data[3];
				String date = data[len-1];
				String[] da = new String[]{"D",id,date};
				return da;
			}else if (data[0].startsWith("FORWARDING")){
				String d = data[1].substring(0,1);
				return new String[]{"F"+d};
			}else if(data[0].startsWith("RECEIVING")){
				String d = data[1].substring(0,1);
				return new String[]{"R"+d};
			}else if(data[0]!=null && data[0].length()>1 && len>6){
				String [] dt = new String[8];
				String nm = data[0];
				for(int i=1;i<len-6;i++){
					nm = nm+" "+data[i];
				}
				dt[0] = "D";
				dt[1] = nm;
				for(int j = 2;j<8;j++ ){
					dt[j] = data[len-8+j];
				}
				
//				System.out.println(Arrays.toString(dt));
				return dt;
			}
			
		}
		return new String[]{"D"};
	}
	
	public static void main(String[] args) {
//		long bgTime = System.currentTimeMillis();
		tReadFile();
//		System.out.println(System.currentTimeMillis()-bgTime);
	}
}
