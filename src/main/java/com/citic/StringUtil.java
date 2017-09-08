package com.citic;

import java.io.UnsupportedEncodingException;


public class StringUtil {
	public static String left0(String date,int len){
		while(date.length()<len){
			date = "0"+date;
		}
		return date;
	}
	public static String right0(String date,int len){
		while(date.length()<len){
			date = date+"0";
		}
		return date;
	}
	public static String rightK(String date,int len){
		while(date.length()<len){
			date = date+" ";
		}
		return date;
	}
	public static String left0(int date,int len){
		String str = ""+date;
		while(str.length()<len){
			str = "0"+str;
		}
		return str;
	}
	 public static String AsciiStringToString(String content) {
	        String result = "";
	        int length = content.length() / 2;
	        for (int i = 0; i < length; i++) {
	            String c = content.substring(i * 2, i * 2 + 2);
	            int a = hexStringToAlgorism(c);
	            char b = (char) a;
	            String d = String.valueOf(b);
	            result += d;
	        }
	        return result;
	    }
	 public static int hexStringToAlgorism(String hex) {
	        hex = hex.toUpperCase();
	        int max = hex.length();
	        int result = 0;
	        for (int i = max; i > 0; i--) {
	            char c = hex.charAt(i - 1);
	            int algorism = 0;
	            if (c >= '0' && c <= '9') {
	                algorism = c - '0';
	            } else {
	                algorism = c - 55;
	            }
	            result += Math.pow(16, max - i) * algorism;
	        }
	        return result;
	    }
	public static String StringToAsciiString(String content) {
        String result = "";
        int max = content.length();
        for (int i = 0; i < max; i++) {
            char c = content.charAt(i);
            String b = Integer.toHexString(c);
            result = result + b;
        }
        return result;
    }
	public static String convertByteArrayToHexStr(byte[] bytes) {
		if (bytes == null || bytes.length % 8 != 0) { 
            return null;  
		}
        StringBuffer tmp = new StringBuffer();  
        int iTmp = 0;  
        for (int i = 0; i < bytes.length; i += 4)  
        {  
            iTmp = 0;  
            for (int j = 0; j < 4; j++)  
            {  
                iTmp += bytes[j+i] << (4 - j - 1);  
            }  
            tmp.append(Integer.toHexString(iTmp));  
        }  
        return tmp.toString();  
    }  
	public static byte[] hexString2binary(String hexString)  
    {  
        if (hexString == null || hexString.length() % 2 != 0) { 
            return null;  
        }
        byte [] map = new byte[64];  
        for (int i = 0; i < hexString.length(); i++)  
        {  
           String tmp = "0000"  
                    + Integer.toBinaryString(Integer.parseInt(hexString  
                            .substring(i, i + 1), 16));  
           tmp =  tmp.substring(tmp.length() - 4); 
           
           char [] tmap = tmp.toCharArray();
           for(int j = 0;j<4;j++){
        	   map[j+(i*4)]=charToByte(tmap[j]);
           }
        }  
        return map;  
    }  
	public static byte[] hexString2binary128(String hexString)  
    {  
        if (hexString == null || hexString.length() % 2 != 0) { 
            return null;  
        }
        byte [] map = new byte[128];  
        for (int i = 0; i < hexString.length(); i++)  
        {  
           String tmp = "0000"  
                    + Integer.toBinaryString(Integer.parseInt(hexString  
                            .substring(i, i + 1), 16));  
           tmp =  tmp.substring(tmp.length() - 4); 
           
           char [] tmap = tmp.toCharArray();
           for(int j = 0;j<4;j++){
        	   map[j+(i*4)]=charToByte(tmap[j]);
           }
        }  
        return map;  
    }  
	public static byte charToByte(char c) {   
	    return (byte) "0123456789ABCDEF".indexOf(c);   
	}
	
	public static String bcd2Str(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
				.toString().substring(1) : temp.toString();
	}
	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;
		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}
		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}
		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;
		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}
			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}
			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}
	
	 public static String toStrHex(String s) {
	        byte[] baKeyword = new byte[s.length() / 2];
	        for (int i = 0; i < baKeyword.length; i++) {
	            try {
	                baKeyword[i] = (byte) (0xff & Integer.parseInt(
	                        s.substring(i * 2, i * 2 + 2), 16));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        try {
	            s = new String(baKeyword,"GBK");
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	        return s;
	    }
	
	public static void main(String[] args) {
		System.out.println(StringToAsciiString("12345"));
//		System.out.println("20170101>20170102"+("20170101".compareTo("20170102")));
//		System.out.println("20180101>20170102"+("20180101".compareTo("20170102")));
//		System.out.println("20170401>20170102"+("20170401".compareTo("20170102")));
//		System.out.println("20170108>20171102"+("20170108".compareTo("20171102")));
//		hexString2binary("6020048030c08811");
	}
}
