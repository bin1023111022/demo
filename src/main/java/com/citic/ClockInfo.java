package com.citic;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * desc: 打卡信息
 */
public class ClockInfo implements Serializable{
    private Long id;
    private String cardId;
    private Date signTime;
    private int type;// 0:离校,1:进校,2:主机读到,3:从机读到,4:从机原始消息,5:主机原始消息
    private String deviceId;//设备id
    private String electricity;//电量
    private Date realTime;
    private int status;//1:正常，2：异常
    
    public Date getRealTime() {
        return realTime;
    }

    public void setRealTime(Date realTime) {
        this.realTime = realTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		return "[cardId=" + cardId + ", type=" + type + ", deviceId=" + deviceId
				+ ", electricity=" + electricity + "]";
	}

	
    
}
