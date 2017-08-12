package com.citic;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


/**
DES加密介绍
     DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
。
注意：DES加密和解密过程中，密钥长度都必须是8的倍数
*/
public class Des {
	
	 static {
	        Security.addProvider(new BouncyCastleProvider());
	    }
	    public Des() {
	    }
	    //测试
	    public static void main(String args[]) {
	        //待加密内容
	     String str = "AABBCC";
	     //密码，长度要是8的倍数
	     String password = "2222222222222222";
	     
	     byte[] result = Des.encrypt(decode(str),password);
	     System.out.println("加密后："+encode(result));
	     //直接将如上内容解密
	     try {
	             byte[] decryResult = Des.decrypt(result, password);
	             System.out.println("解密后："+encode(decryResult));
	     } catch (Exception e1) {
	             e1.printStackTrace();
	     }
	 }
	    /**
	     * 加密
	     * @param datasource byte[]
	     * @param password String
	     * @return byte[]
	     */
	    public static  byte[] encrypt(byte[] datasource, String password) {            
	        try{
	        SecureRandom random = new SecureRandom();
	        DESKeySpec desKey = new DESKeySpec(password.getBytes());
	        //创建一个密匙工厂，然后用它把DESKeySpec转换成
	        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	        SecretKey securekey = keyFactory.generateSecret(desKey);
	        //Cipher对象实际完成加密操作
	        Cipher cipher = Cipher.getInstance("DES");
	        //用密匙初始化Cipher对象
	        cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
	        //现在，获取数据并加密
	        //正式执行加密操作
	        return cipher.doFinal(datasource);
	        }catch(Throwable e){
	                e.printStackTrace();
	        }
	        return null;
	}
	    /**
	     * 解密
	     * @param src byte[]
	     * @param password String
	     * @return byte[]
	     * @throws Exception
	     */
	    public static byte[] decrypt(byte[] src, String password) throws Exception {
	            // DES算法要求有一个可信任的随机数源
	            SecureRandom random = new SecureRandom();
	            // 创建一个DESKeySpec对象
	            DESKeySpec desKey = new DESKeySpec(password.getBytes());
	            // 创建一个密匙工厂
	            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	            // 将DESKeySpec对象转换成SecretKey对象
	            SecretKey securekey = keyFactory.generateSecret(desKey);
	            // Cipher对象实际完成解密操作
	            Cipher cipher = Cipher.getInstance("DES");
	            // 用密匙初始化Cipher对象
	            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
	            // 真正开始解密操作
	            return cipher.doFinal(src);
	        }
	    
	    
	    
	    public static byte[] DES3(byte[] data, byte[] key) {
	        byte[] result = null;
	        try {
	            SecretKey secretKey = getSecretKeySpec(key);
	            Cipher cipher = Cipher.getInstance("DESede/ECB/NoPadding", "BC");
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	            result = cipher.doFinal(data);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
		
		private static SecretKey getSecretKeySpec(byte[] keyB) throws NoSuchAlgorithmException, InvalidKeySpecException {
	        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("Des");
	        SecretKeySpec secretKeySpec = new SecretKeySpec(keyB, "Des");
	        return secretKeyFactory.generateSecret(secretKeySpec);
	    }
		 public static byte[] XOR(byte[] edata, byte[] temp) {
		        byte[] result = new byte[8];
		        for (int i = 0, j = result.length; i < j; i++) {
		            result[i] = (byte) (edata[i] ^ temp[i]);
		        }
		        return result;
		    }
		 public static byte[] mac3(byte[] data, byte[] key){


		        //System.out.println(HexCodec2.hexEncode(data));
		        byte []data81 = new byte[8];
		        byte []data82 = new byte[8];
		        System.arraycopy(data,0,data81,0,8);
		        //System.out.println(HexCodec2.hexEncode(data81));

		        System.arraycopy(data,8,data82,0,8);

		        //System.out.println(HexCodec2.hexEncode(data82));


		        byte[]enc1= DES3(data81, key);

		       byte[] xor8= XOR(enc1, data82);

		        byte[]enc2= DES3(xor8, key);

		        String result = encode(enc2);

		        //System.out.println(result);


		        return result.getBytes();


		    }
		 public static byte[] generateMAB(byte[] datasource) {
		        // 补满8字节的字节数组
		        byte[] temp = null;
		        // 如果不满8字节，进行填充
		        if (datasource.length % 8 != 0) {
		            temp = new byte[datasource.length + (8 - datasource.length % 8)];
		            System.arraycopy(datasource, 0, temp, 0, datasource.length);
		        } else {
		            temp = datasource;
		        }
		        // 每8字节进行异或
		        byte[] tempResult = new byte[8];
		        // 将首8个字节进行copy
		        System.arraycopy(temp, 0, tempResult, 0, tempResult.length);
		        for (int j = 8; j < temp.length; j = j + 8) {
		            for (int k = 0; k < 8; k++) {
		                //每字节进行异或
		                tempResult[k] = (byte) (tempResult[k] ^ temp[j + k]);
		            }
		        }
		        String result = encode(tempResult);
		        return result.getBytes();
		    }
		 public static byte[] DES_DECODE(byte[] data, byte[] key) {
		        Cipher cipher;
		        byte[] byteFina = null;
		        try {
		            SecretKey secretKey = getSecretKeySpec(key);

		            cipher = Cipher.getInstance("DESede/ECB/NoPadding", "BC");
		            cipher.init(Cipher.DECRYPT_MODE, secretKey);
		            byteFina = cipher.doFinal(data);
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            cipher = null;
		        }
		        return byteFina;
		    }
		 public static byte[] getClone(byte[] pHexBinary) {
				byte[] result = new byte[pHexBinary.length];
				System.arraycopy(pHexBinary, 0, result, 0, pHexBinary.length);
				return result;
			}

			/** 
			 * Converts the string <code>pValue</code> into an
			 * array of hex bytes.
			 */
			public static byte[] decode(String pValue) {
				if ((pValue.length() % 2) != 0) {
					throw new IllegalArgumentException("A HexBinary string must have even length.");
				}
				byte[] result = new byte[pValue.length() / 2];
				int j = 0;
				for (int i = 0;  i < pValue.length();  ) {
					byte b;
					char c = pValue.charAt(i++);
					char d = pValue.charAt(i++);
					if (c >= '0'  &&  c <= '9') {
						b = (byte) ((c - '0') << 4);
					} else if (c >= 'A'  &&  c <= 'F') {
						b = (byte) ((c - 'A' + 10) << 4);
					} else if (c >= 'a'  &&  c <= 'f') {
						b = (byte) ((c - 'a' + 10) << 4);
					} else {
						throw new IllegalArgumentException("Invalid hex digit: " + c);
					}
					if (d >= '0'  &&  d <= '9') {
						b += (byte) (d - '0');
					} else if (d >= 'A'  &&  d <= 'F') {
						b += (byte) (d - 'A' + 10);
					} else if (d >= 'a'  &&  d <= 'f') {
						b += (byte) (d - 'a' + 10);
					} else {
						throw new IllegalArgumentException("Invalid hex digit: " + d);
					}
					result[j++] = b;
				}
				return result;
			}

			/** 
			 * Converts the byte array <code>pHexBinary</code> into
			 * a string.
			 */
			public static String encode(byte[] pHexBinary) {
				StringBuffer result = new StringBuffer();
				for (int i = 0;  i < pHexBinary.length;  i++) {
					byte b = pHexBinary[i];
					byte c = (byte) ((b & 0xf0) >> 4);
					if (c <= 9) {
						result.append((char) ('0' + c));
					} else {
						result.append((char) ('A' + c - 10));
					}
					c = (byte) (b & 0x0f);
					if (c <= 9) {
						result.append((char) ('0' + c));
					} else {
						result.append((char) ('A' + c - 10));
					}
				}
				return result.toString();
			}
		public static void main2(String[] args) {
			
			String data = "02002020048220c080";//加密数据
			String key ="DE2C465DBA8268928FFEA47D1A96D36D";
			
			byte[] mac = mac3(generateMAB(decode(data)), decode(key));
			System.out.println("mac--------"+new String(mac));
			
			byte macKeySrc[] = DES_DECODE(decode(new String(mac)),decode(key));
			System.out.println("macKeySrc--------"+encode(macKeySrc));
			
//	         byte macKeySrc[] = DES_DECODE(decode("DE2C465DBA8268928FFEA47D1A96D36D"), decode("22222222222222222222222222222222"));
//	         String macKey = encode(macKeySrc);
//	         byte macBlock[] = generateMAB(decode("02002020048220c088113100000003550220005153594830303031356224241000000023d300310136290310002030313030303636383837303436333035393437303030313135360600000000000000001301000002000600"));
//		        byte[] mac = mac3(macBlock, decode(macKey));
//		        System.out.println("mac--------"+new String(mac).substring(0,8).toUpperCase());
//			
		}
	    
}
