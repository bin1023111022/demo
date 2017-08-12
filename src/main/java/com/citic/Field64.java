package com.citic;

import java.util.Map;

public class Field64 {
	
	private Map<Integer,FieldData> fieldDataMap = null;
	
	public Field64(){
		
		fieldDataMap.put(999, new FieldData().setLength(11).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(0, new FieldData().setLength(4).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(1, new FieldData().setLength(8).setValueType(FieldData.VALUETYPE_BIN));
		fieldDataMap.put(2, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLVAR).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(3, new FieldData().setLength(6).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(4, new FieldData().setLength(12).setSupplementData("0").setLocation(FieldData.LOCATION_LEFT).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(11, new FieldData().setLength(11).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(12, new FieldData().setLength(6).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(13, new FieldData().setLength(4).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(14, new FieldData().setLength(4).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(15, new FieldData().setLength(4).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(22, new FieldData().setLength(3).setSupplementData("0").setLocation(FieldData.LOCATION_LEFT).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(23, new FieldData().setLength(3).setSupplementData("0").setLocation(FieldData.LOCATION_LEFT).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(25, new FieldData().setLength(2).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(26, new FieldData().setLength(2).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(32, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLVAR).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(35, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLVAR).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(36, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLLVAR).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(37, new FieldData().setLength(12).setValueType(FieldData.VALUETYPE_ASCII));
		fieldDataMap.put(38, new FieldData().setLength(6).setValueType(FieldData.VALUETYPE_ASCII));
		fieldDataMap.put(39, new FieldData().setLength(2).setValueType(FieldData.VALUETYPE_ASCII));
		fieldDataMap.put(41, new FieldData().setLength(8).setValueType(FieldData.VALUETYPE_ASCII));
		fieldDataMap.put(42, new FieldData().setLength(15).setValueType(FieldData.VALUETYPE_ASCII));
		fieldDataMap.put(44, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLVAR).setValueType(FieldData.VALUETYPE_ASCII));
		fieldDataMap.put(48, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLLVAR).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(49, new FieldData().setLength(3).setValueType(FieldData.VALUETYPE_ASCII));
		fieldDataMap.put(52, new FieldData().setLength(8).setValueType(FieldData.VALUETYPE_BIN));
		fieldDataMap.put(53, new FieldData().setLength(16).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(54, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLLVAR).setValueType(FieldData.VALUETYPE_ASCII));
		fieldDataMap.put(55, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLLVAR).setValueType(FieldData.VALUETYPE_BIN));
		fieldDataMap.put(60, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLLVAR).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(61, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLLVAR).setValueType(FieldData.VALUETYPE_BCD));
		fieldDataMap.put(62, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLLVAR).setValueType(FieldData.VALUETYPE_BIN));
		fieldDataMap.put(63, new FieldData().setLengthType(FieldData.LENGTHTYPE_LLLVAR).setValueType(FieldData.VALUETYPE_ASCII));
		fieldDataMap.put(64, new FieldData().setLength(8).setValueType(FieldData.VALUETYPE_ASCII));
		
	}
	
	public FieldData getFieldData(int f){
		if(this.fieldDataMap.containsKey(f)){
			return this.fieldDataMap.get(f);
		}
		return new FieldData();
	}

}
