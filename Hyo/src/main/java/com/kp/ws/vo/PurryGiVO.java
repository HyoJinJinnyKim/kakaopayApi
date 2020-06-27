package com.kp.ws.vo;

import java.math.BigDecimal;

import javax.annotation.sql.DataSourceDefinition;

//@DataSourceDefinition(className = "PurryGiVO", name = "PurryGiVO")
public class PurryGiVO {

	private String ownerID;
	private String token;
	private BigDecimal sumMoney ; //토탈 주려는 금액 
	private String recieverTotCnt; //줄사람 카운트
	private String timestamp; //뿌리기 최초 요청 시간
	private int recieverSeq; //
	private String receiverID;
	private BigDecimal receiveMoney; //recieve money
	

	
	
	public BigDecimal getReceiveMoney() {
		return receiveMoney;
	}

	public void setReceiveMoney(BigDecimal receiveMoney) {
		this.receiveMoney = receiveMoney;
	}

	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public BigDecimal getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(BigDecimal sumMoney) {
		this.sumMoney = sumMoney;
	}
	public String getRecieverTotCnt() {
		return recieverTotCnt;
	}
	public void setRecieverTotCnt(String recieverTotCnt) {
		this.recieverTotCnt = recieverTotCnt;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getRecieverSeq() {
		return recieverSeq;
	}
	public void setRecieverSeq(int recieverSeq) {
		this.recieverSeq = recieverSeq;
	}
	public String getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	@Override
	public String toString() {
		return "PurryGiVO [ownerID=" + ownerID + ", token=" + token + ", sumMoney=" + sumMoney + ", recieverTotCnt="
				+ recieverTotCnt + ", timestamp=" + timestamp + ", recieverSeq=" + recieverSeq + ", receiverID="
				+ receiverID + "]";
	}
	
	
	
	
}
