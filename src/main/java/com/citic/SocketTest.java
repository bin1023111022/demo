package com.citic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocketTest {
	
	public static Logger logger = LoggerFactory.getLogger(SocketTest.class);
	
	static String purchase = "303336362E02303336363034333834353330202020303030313030303020202043555001303030303030303000303030303030323130F23E42818AC0821000000000100000C1313936323132313432303030303030303030303132303030303030303030303030303038303030303731333033353032313030313038353033353032313037313332393132303731333439303030303030303038303433383435333030383034333834353330313630373133383639363732303031303030303134373830313030303934393030303030313135363033369F3602005F910ADB36C7740564A62C30307211860F04DA9F790A0000000500004CB485683033303030303030363030303330303030303030303030303031323130313030303038393230393030303030343335313453323230303030303435393230393030303020202030303030303030303030303030303030303030303139303136463132326163715F72657365727665643836373233453836";
	static String purchase1 = "303336362E02303336363034333834353330202020303030313030303020202043555001303030303030303000303030303030323130F23E42818AC0821000000000100000C1313936323132313432303030303030303030303132303030303030303030303030303038303030303731333033353032313030313038353033353032313037313332393132303731333439303030303030303038303433383435333030383034333834353330313630373133383639363732303031303030303134373830313030303934393030303030313135363033369F3602005F910ADB36C7740564A62C30307211860F04DA9F790A0000000500004CB485683033303030303030363030303330303030303030";
	static String purchase2 = "30303030303132313031303030303839323039";
	static String purchase3 = "3030303030343335313453323230303030303435393230393030303020202030303030303030303030303030303030303030303139303136463132326163715F72657365727665643836373233453836";
	static String aa = "008A600006000060310032007204007024068002c08211196212142000000000012000000000000000011100117629120510000000303631303030303134373830313030303934393030303030313135360040950508800470009f1e0838383434373034369f101307010103a02010010a0100000500004707a18d0014220000010006014543454234394139";
//	static String aa = "0039600254000060310031192200000000000000000000000000000000000000000900000000020000001051535948303030310011000000019010";
//	static String aa ="012f6000060000603100010101000000000000000000000000000000000000000002007020068220c09a11196231190153300279041000000000000000000100012905100010005153594830303031376231190153300279041d24122207673140100030313030303636383837303436333035393437303030313135366315D59B2BA7AB7A260000000000000001459f2608d3c58c99e17424139f2701809f101307050103a02000010a0100000000492e40d7f29f3704e847e7c19f360200ad950508000470009a031610289c01009f02060000000000015f2a02015682027c009f1a0201569f03060000000000009f3303e0e1c89f34030203009f3501229f1e0838393636313530388408a0000003330101019f090200209f4104000001290014220000010006014137334542384535";
	static int errorCount = 0;
	static Integer count = 0;
	static int byteSize = 1024;
	public static void sendData(String[] address) throws Exception {
		SocketTest.logger.debug("-----debug-----");
		SocketTest.logger.info("-----info-----");
		SocketTest.logger.warn("-----warm----");
		SocketTest.logger.error("-----error------");
		String host = address[0];
		int port = Integer.valueOf(address[1]);
		Socket s = new Socket(host, port);
		s.setSoTimeout(60*1000);  
		s.getOutputStream().write(BcdUtils.str2Bcd(aa));
//        s.getOutputStream().write(BcdUtils.str2Bcd(purchase2));
//        s.getOutputStream().write(BcdUtils.str2Bcd(purchase3));
//		s.getOutputStream().write(unLogin.getBytes());
        byte[] ret = new byte[2];
        int n = s.getInputStream().read(ret,0,2);    
        String len =BcdUtils.bcd2Str(ret);//"009F";//
        int leni = Integer.parseInt(len,16);
        byte[] ret2 = new byte[leni];
        int t = s.getInputStream().read(ret2);
        String std = BcdUtils.bcd2Str(ret2);
        System.out.println("-------------------------");
        System.out.println(std);
        System.out.println("-------------------------");
        s.close();
        count++;
    }
	public static void main(String[] args) throws Exception { 
		System.out.println("开始发送");
		String [] address = {"58.56.23.89","6665"};//易通测试平台
		String [] address1 = {"192.168.1.110","555"};
		String [] address2 = {"10.1.9.155","5555"};
		String [] address3 = {"127.0.0.1","15002"};
		String [] address4 = {"192.168.8.178","15002"};
		String [] address5 = {"192.168.8.178","16002"};
		String [] address6 = {"127.0.0.1","16002"};
//		sendData(address2);
//		zySendData(address4);
		zjSendData(address6);//拙进
	}
	
//	30303336
//	3130
//	30303530
//	202020202020202020353336373138353639
//	2020202020202030
	//拙进
public static void zjSendData(String[] address) throws Exception{
		
		InputStream in = null;
		String host = address[0];
		int port = Integer.valueOf(address[1]);
		final Socket client = new Socket(host, port);
		client.setSoTimeout(5*60*1000);//5分钟超时
		OutputStream out = client.getOutputStream();
		String sDateLive = "30303130303531333233";
		String sData0 = "303033363130303035302020202020202020203533363731383536392020202020202030";
		byte[] sendData0 = ByteUtils.hexStr2ByteArray(sData0);
		byte[] sendDataLive = ByteUtils.hexStr2ByteArray(sDateLive);
		
		byte[] sendData1 = null;
		
		in = client.getInputStream();
		StringBuffer sData1 = null;
		
		for(int i = 0 ; i < 9000000;i++){
			sData1 = new StringBuffer();
			sData1.append("303037393231");
			if(i>9999){
				sData1.append(StringUtil.StringToAsciiString(StringUtil.left0(i, 4)));
			}else{
				sData1.append(StringUtil.StringToAsciiString(StringUtil.left0(i%10000, 4)));
				
			}
			sData1.append("202020202020202020353336373138353639202020202020202020204539423739353235202020202020202020204539423739353235");
			sData1.append(StringUtil.StringToAsciiString(DateUtile.getCurrentDate(DateUtile.FULLTIMEPATTERN)));
			sData1.append("303030");
			sendData1 = ByteUtils.hexStr2ByteArray(sData1.toString());
			 
			 out.write(sendData0);
			 out.write(sendDataLive);
			 out.write(sendData1);
			 Thread.sleep(2000);
		}
			
			while (true);
	}
	
	public static void zySendData(String[] address) throws Exception{
		
		InputStream in = null;
		String host = address[0];
		int port = Integer.valueOf(address[1]);
		final Socket client = new Socket(host, port);
		client.setSoTimeout(5*60*1000);//5分钟超时
		OutputStream out = client.getOutputStream();
		String sData0 = "5a550a00000b01430e23447d6a69";
		byte[] sendData0 = ByteUtils.hexStr2ByteArray(sData0);
		byte[] sendData1 = null;
		in = client.getInputStream();
		StringBuffer sData1 = null;
		for(int i = 0 ; i < 9000000;i++){
			sData1 = new StringBuffer();
			sData1.append("5a551d");
			if(i>9999){
				sData1.append(StringUtil.left0(i, 4));
			}else{
				sData1.append(StringUtil.left0(i%10000, 4));
				
			}
//	 		 sData1+="0023";
			sData1.append("0b0d430e234405000071000b64041411080e0a2932010001002f6a69");
			 
			 sendData1 = ByteUtils.hexStr2ByteArray(sData1.toString());
			 out.write(sendData0);
			 out.write(sendData1);
			 Thread.sleep(2000);
		}
			
			while (true) {
			List<byte[]> data = new ArrayList<byte[]>();
			byte[] buf = new byte[byteSize];
			int inLen = in.read(buf);
			if(inLen==-1){
				logger.debug(client.getInetAddress().getHostAddress()+"空包!");
				client.sendUrgentData(0xff);
				Thread.sleep(500);
				break;
			}
			while (inLen > 0) {
				if (inLen == byteSize) {
					byte[] buf2=new byte[inLen];
					System.arraycopy(buf, 0, buf2, 0, inLen);
					data.add(buf2);
					inLen = in.read(buf);
				} else {
					data.add(buf);
					break;
				}
			}
			if (data.size() == 0) {
				return;
			}
			// 拼接data
			byte[] dataPage = ByteUtils.byteJoint(data, byteSize, inLen);
			logger.debug("本次接收到的信息为:"+ByteUtils.toHexString(dataPage));
		}
	}
}
