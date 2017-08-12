package com.citic;

public class XOR {
	
	public static byte[] stringTo8XorByte(String str){
		byte data[] = decode(str);
		byte [] data1 = new byte[8];
		byte [] result = new byte[8];
		if(data.length>8){
			System.arraycopy(data , 0 , result , 0 , 8);
		}else{
			System.arraycopy(data , 0 , result , 0 , data.length);
		}
		
		
		for(int i = 1 ; i < (data.length / 8)+1; i++){
			if(((i+1)*8) < data.length){
				data1 = new byte[8];
				System.arraycopy(data , i*8 , data1 , 0 , 8);
			}else{
				int bt = data.length-(i*8);
				System.arraycopy(data , i*8 , data1 , 0 , bt);
				data1 = adz(bt,data1);
				
			}
			
			result = tXOR(data1,result);
		}
		
		return result;
	}
	
	public static byte[] adz(int i , byte[] data){
		for(;i<data.length;i++){
			data[i] = 0;
		}
		return data;
	}
	
	public static byte[] tXOR(byte[] edata, byte[] temp) {
        byte[] result = new byte[8];
        for (int i = 0, j = result.length; i < j; i++) {
            result[i] = (byte) (edata[i] ^ temp[i]);
        }
        return result;
    }
	
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
	
public static void main(String[] args) {
	byte []  data = XOR.stringTo8XorByte("02007020068220c09a11196231190153300279041000000000000000000100012905100010005153594830303031376231190153300279041d24122207673140100030313030303636383837303436333035393437303030313135366315D59B2BA7AB7A260000000000000001459f2608d3c58c99e17424139f2701809f101307050103a02000010a0100000000492e40d7f29f3704e847e7c19f360200ad950508000470009a031610289c01009f02060000000000015f2a02015682027c009f1a0201569f03060000000000009f3303e0e1c89f34030203009f3501229f1e0838393636313530388408a0000003330101019f090200209f410400000129001422000001000601");
	System.out.print(XOR.encode(data));
}

}
