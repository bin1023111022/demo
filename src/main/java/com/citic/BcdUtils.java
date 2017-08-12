package com.citic;


public class BcdUtils {
	
	public static void main1(String[] args) {
		byte[] b = str2Bcd("dd");
		System.out.println(bcd2Str(b));
	}

	
	public static String bcd2Str1(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString().substring(0, 1).equalsIgnoreCase("0") ? temp
				.toString().substring(1) : temp.toString();
	}

	
	public static byte[] str2Bcd1(String asc) {
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
            System.out.format("%02X", bbt[p]);
        } 
        return bbt; 
    } 
     private static byte asc_to_bcd(byte asc) { 
     byte bcd; 
     
     if ((asc >= '0') && (asc <= '9')) 
     bcd = (byte) (asc - '0'); 
     else if ((asc >= 'A') && (asc <= 'F')) 
     bcd = (byte) (asc - 'A' + 10); 
     else if ((asc >= 'a') && (asc <= 'f')) 
     bcd = (byte) (asc - 'a' + 10); 
     else 
     bcd = (byte) (asc - 48); 
     return bcd; 
     } 
     
     private static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) { 
     byte[] bcd = new byte[asc_len / 2]; 
     int j = 0; 
     for (int i = 0; i < (asc_len + 1) / 2; i++) { 
     bcd[i] = asc_to_bcd(ascii[j++]); 
     bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4)); 
     System.out.format("%02X", bcd[i]);
     } 
     return bcd; 
     } 
     
     public static String bcd2Str(byte[] bytes) { 
     char temp[] = new char[bytes.length * 2], val; 
     
     for (int i = 0; i < bytes.length; i++) { 
     val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f); 
     temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0'); 
     
     val = (char) (bytes[i] & 0x0f); 
     temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0'); 
     } 
     return new String(temp); 
     }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //System.out.print("Hello,World!");
         String s = "123456789ABCDEF"; 
     byte[] bcd = str2Bcd(s); 
         //byte[] bcd = str2Bcd(s);
      String s1 = bcd2Str(bcd);
     //System.out.print(s1);
    }
}
