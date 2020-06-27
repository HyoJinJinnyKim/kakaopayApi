package com.kp.ws.vo;

import java.math.BigDecimal;

public class SpreadVO {

		private int seq;
		private BigDecimal spreadMoney;
		private String timestamp;
		
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq = seq;
		}
		public BigDecimal getSpreadMoney() {
			return spreadMoney;
		}
		public void setSpreadMoney(BigDecimal spreadMoney) {
			this.spreadMoney = spreadMoney;
		}
		public String getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}
		
		@Override
		public String toString() {
			return "SpreadVO [seq=" + seq + ", spreadMoney=" + spreadMoney + ", timestamp=" + timestamp + "]";
		}
		
		
		
}
