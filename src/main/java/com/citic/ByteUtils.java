package com.citic;

import java.util.List;

/**
 * byte数组处理工具类
 * 
 * @SystemName athena
 * @ModuleName athena_chart
 * @ClassName ByteUtils
 * @author zhu_jxue
 * @Date 2015年11月3日上午8:54:45
 * @version 当前版本号
 *          <p>
 *          日期1 作者名1 修改内容1
 *          </p>
 *          <p>
 *          日期2 作者名2 修改内容2
 *          </p>
 * @Description
 */
public class ByteUtils {
	/**
	 * 将十六进制byte数组转为字符串,打印
	 * 
	 * @Title printHexString
	 * @Date 2015年10月26日 上午9:55:41
	 * @author zhujixue
	 * @Description
	 * @param b
	 * @return void
	 * @modify 日期 作者名 修改内容
	 */
	public static void printHexString(byte[] b) {
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			System.out.print(hex);
		}
		System.out.println();
	}

	/**
	 * 将十六进制byte数组转为字符串,返回
	 * 
	 * @Title printHexString
	 * @Date 2015年10月26日 上午9:55:41
	 * @author zhujixue
	 * @Description
	 * @param b
	 * @return void
	 * @modify 日期 作者名 修改内容
	 */
	public static String toHexString(byte[] b) {
		if(b==null){
			return "";
		}
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			buf.append(hex);
		}
		return buf.toString();
	}

	/**
	 * 将byte转为16进制字符
	 * 
	 * @Title toHexString
	 * @Date 2015年11月3日 上午8:55:25
	 * @author zhu_jxue
	 * @Description
	 * @param b
	 * @return
	 * 
	 * 		<p>
	 *         日期1 作者名1 修改内容1
	 *         </p>
	 *         <p>
	 *         日期2 作者名2 修改内容2
	 *         </p>
	 */
	public static String toHexString(byte b) {
		String hex = Integer.toHexString(b & 0xFF);
		if (hex.length() == 1) {
			hex = '0' + hex;
		}
		return hex;
	}

	/**
	 * 截取Byte数组
	 * 
	 * @Title subBytes
	 * @Date 2015年10月26日 上午9:56:50
	 * @author zhujixue
	 * @Description
	 * @param src
	 * @param begin
	 *            开始
	 * @param count
	 *            截取长度
	 * @return
	 * @return byte[]
	 * @modify 日期 作者名 修改内容
	 */
	public static byte[] subBytes(byte[] src, int begin, int count) {
		byte[] bs = new byte[count];
		for (int i = begin; i < begin + count; i++) {
			bs[i - begin] = src[i];
		}
		return bs;
	}

	/**
	 * 16进制的字符串表示转成字节数组
	 * 
	 * @param hexString
	 *            16进制格式的字符串
	 * @return 转换后的字节数组
	 **/
	public static byte[] hexStr2ByteArray(String hexString) {
		if (hexString==null||hexString.isEmpty()) {
             return new byte[]{};
		}
		hexString = hexString.toLowerCase();
		final byte[] byteArray = new byte[hexString.length() / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {
			// 因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
			// 将hex 转换成byte "&" 操作为了防止负数的自动扩展
			// hex转换成byte 其实只占用了4位，然后把高位进行右移四位
			// 然后“|”操作 低四位 就能得到 两个 16进制数转换成一个byte.
			//
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}

	/**
	 * 多个byte[]数组拼接
	 * 
	 * @Title byteJoint
	 * @Date 2015年11月3日 上午8:56:30
	 * @author zhu_jxue
	 * @Description
	 * @param list
	 * @param byteSize
	 * @param inLen
	 * @return byte[]
	 * 
	 *         <p>
	 *         日期1 作者名1 修改内容1
	 *         </p>
	 *         <p>
	 *         日期2 作者名2 修改内容2
	 *         </p>
	 */
	public static byte[] byteJoint(List<byte[]> list, int byteSize, int inLen) {
		if (inLen == -1) {
			inLen = 0;
		}
		int len = list.size();
		byte[] data = new byte[(len - 1) * byteSize + inLen];
		for (int i = 0; i < len - 1; i++) {
			byte[] item = list.get(i);
			System.arraycopy(item, 0, data, i * byteSize, byteSize);
		}
		byte[] item = list.get(len - 1);
		System.arraycopy(item, 0, data, (len - 1) * byteSize, inLen);
		return data;
	}

	/**
	 * 对比16进制累加和校验码
	 * 
	 * @param data
	 *            除去校验位的数据 sign 校验位
	 * @return boolean
	 */
	public static boolean contrastChecksum(byte[] data, int sign) {
		if(sign==0) return false;
		int total = 0;
		int len = sign - 1;
		int num = 0;
		while (num < len) {
			int b = data[num] & 0xFF;
			total += b;
			num = num + 1;
		}
		int sign_10 = data[len] & 0xFF;
		return sign_10 == total % 256;
	}

	/**
	 * 生成16进制累加和校验码
	 * 
	 * @param data
	 *            除去校验位的数据 sign 校验位
	 * @return void
	 */
	public static void markChecksum(byte[] data, int sign) {
		int total = 0;
		int len = sign - 1;
		int num = 0;
		while (num < len) {
			int b = data[num] & 0xFF;
			total += b;
			num = num + 1;
		}
		int checkSum = total % 256;
		data[sign - 1] = (byte) checkSum;
	}

	/**
	 * 替换byte数组的一段
	 * 
	 * @Title resplaceBytes
	 * @Date 2015年10月28日 上午10:34:50
	 * @author zhujixue
	 * @Description
	 * @param src
	 *            原byte
	 * @param resplace
	 *            要替换的数组段
	 * @param start
	 *            开始位置
	 * @return void
	 * @modify 日期 作者名 修改内容
	 */
	public static void resplaceBytes(byte[] src, byte[] resplace, int start) {
		for (int i = 0; i < resplace.length; i++) {
			src[start + i] = resplace[i];
		}

	}

	/**
	 * 替换byte数组的一段
	 * 
	 * @Title resplaceBytes
	 * @Date 2015年11月3日 上午8:57:23
	 * @author zhu_jxue
	 * @Description
	 * @param src
	 * @param resplace
	 * @param start
	 * @param count
	 * 
	 *            <p>
	 *            日期1 作者名1 修改内容1
	 *            </p>
	 *            <p>
	 *            日期2 作者名2 修改内容2
	 *            </p>
	 */
	public static void resplaceBytes(byte[] src, byte[] resplace, int start, int count) {
		for (int i = 0; i < count; i++) {
			src[start + i] = resplace[i];
		}

	}
    public static void main(String[] args) {
		System.out.println(toHexString("000000001"));
	}
    public static String toHexString(String str){
    	if(str==null||"".equals(str)){
    		return "";
    	}
    	if(str.length()!=10){
			return str;
		}
    	String rs=Integer.toHexString(Integer.valueOf(str));
    	for(int i=rs.length();i<8;i++){
    		rs="0"+rs;
    	}
    	return rs;
    }

	public static String parseHexString(String str) {
		if(str==null||"".equals(str)){
    		return "";
    	}
		if(str.length()!=8){
			return str;
		}
		String rs =String.valueOf(Integer.parseInt(str, 16));
    	for(int i=rs.length();i<10;i++){
    		rs="0"+rs;
    	}
    	return rs;
	}
}
