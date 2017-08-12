package com.citic;

import java.util.BitSet;

/**
 * Created by Administrator on 2015/4/13.
 */
public class MyBitTest {

    public void creatTest(){
               String st = "tc123456789";
        byte[] bytes =st.getBytes();
        for (int i=0;i<bytes.length;i++){
            //<<(左移)、>>(带符号右移)和>>>(无符号右移)
            System.out.println("下标为"+i+"的值："+bytes[i]);
            System.out.println("下标为"+i+"的>>4的值："+(bytes[i]>>4));
            System.out.println("下标为"+i+"的>>>4的值："+(bytes[i]>>>4));
            System.out.println("下标为"+i+"的& 0xF的值："+(bytes[i] & 0xF));
        }

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

    public byte[] encodeBitMap(BitSet bs) {

        int byteNum = bs.size() / 8;
        byte[] result = new byte[byteNum];
        int pos = 0;
        for (int i = 0; i < byteNum; i++) {
            int value = 0;
            if (bs.get(pos++)) {
                value += 128;
            }
            if (bs.get(pos++)) {
                value += 64;
            }
            if (bs.get(pos++)) {
                value += 32;
            }
            if (bs.get(pos++)) {
                value += 16;
            }
            if (bs.get(pos++)) {
                value += 8;
            }
            if (bs.get(pos++)) {
                value += 4;
            }
            if (bs.get(pos++)) {
                value += 2;
            }
            if (bs.get(pos++)) {
                value += 1;
            }

            result[i] = (byte) value;

        }
        return result;

    }
    /**
	  * 字符串转ASCII16进制编码字符串
	  * @param content
	  * @return
	  */
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
    public static void main(String[] args) {
    	System.out.println(MyBitTest.StringToAsciiString("60B28C10"));
	}
}
