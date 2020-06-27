package com.kp.ws.uc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.kp.ws.vo.PurryGiVO;

public class Utility {
	
	public static PurryGiVO setHeaderToken(PurryGiVO param) {
		System.out.println("*********** "+param.toString());
		return param;
	}
	
	public static String createToken(PurryGiVO paramPG) {
		String resToken = "ABC";
		return resToken;
	}
	
	public static List<PurryGiVO> calSpreadMoney(PurryGiVO param){
		List<PurryGiVO> resList = new ArrayList<PurryGiVO>();
		int cnt = Integer.parseInt(param.getRecieverTotCnt());
		//계산
		BigDecimal sum = param.getSumMoney();
		BigDecimal divMon = sum.divide(new BigDecimal(cnt),0, BigDecimal.ROUND_DOWN);
//		BigDecimal lastMon = BigDecimal.ZERO;
		for(int i=0; i<cnt; i++) {
			//마지막 값 = 전체금액- (나눈값*(전체인원-1)) 
			if(i == cnt-1) {
				divMon = sum.subtract(divMon.multiply(new BigDecimal(i)));
			}
			
			param.setRecieverSeq(i+1);
			param.setReceiveMoney(divMon);
			
			System.out.println("divMon :*****" +divMon+"/i:"+i); 
			resList.add(param);
		}
		
		return resList;
	}
}
