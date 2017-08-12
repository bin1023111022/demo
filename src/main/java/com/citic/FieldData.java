package com.citic;

public class FieldData {
	
	public static final String LENGTHTYPE_LLVAR = "LLVAR";
	public static final String LENGTHTYPE_LLLVAR = "LLLVAR";
	
	public static final String VALUETYPE_BCD = "BCD";
	public static final String VALUETYPE_BIN = "BIN";
	public static final String VALUETYPE_ASCII = "ASCII";
	
	public static final String LOCATION_LEFT = "LEFT";
	public static final String LOCATION_RIGHT = "RIGHT";
	
	//域长度类型
	private String lengthType=null;
	//域长度
	private int length=0;
	//域数据类型
	private String valueType=null;
	//长度不足，填补数据值，一般为空格或0
	private String supplementData=null;
	//长度不足，填充数据位置（左补/右补）
	private String location=null;
	
	public String getLengthType() {
		return lengthType;
	}
	public FieldData setLengthType(String lengthType) {
		this.lengthType = lengthType;
		return this;
	}
	public int getLength() {
		return length;
	}
	public FieldData setLength(int length) {
		this.length = length;
		return this;
	}
	public String getValueType() {
		return valueType;
	}
	public FieldData setValueType(String valueType) {
		this.valueType = valueType;
		return this;
	}
	public String getSupplementData() {
		return supplementData;
	}
	public FieldData setSupplementData(String supplementData) {
		this.supplementData = supplementData;
		return this;
	}
	public String getLocation() {
		return location;
	}
	public FieldData setLocation(String location) {
		this.location = location;
		return this;
	}
	
	
}
