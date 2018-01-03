package com.citic;

public enum LuoErrorCode {
	NULL_OBJ("01010001","对象为空"),
    ERROR_ADD_USER("01010002","添加用户失败"),
    UNKNOWN_ERROR("01010003","系统繁忙，请稍后再试....");

    private String value;
    private String desc;

    private LuoErrorCode(String value, String desc) {
        this.setValue(value);
        this.setDesc(desc);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
