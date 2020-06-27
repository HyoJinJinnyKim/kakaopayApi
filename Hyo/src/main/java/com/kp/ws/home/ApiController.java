package com.kp.ws.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.kp.ws.service.PgService;
import com.kp.ws.uc.Utility;
import com.kp.ws.vo.PurryGiVO;

@RestController
public class ApiController {

	@RequestMapping(value = "/spreadMoney", method=RequestMethod.POST)
	public String spreadMoney(@RequestBody PurryGiVO paramPG) throws JSONException {
		
		System.out.println("paramPG :@@@@@"+paramPG.toString());
		
		//토큰생성 
		String token = Utility.createToken(paramPG);
		paramPG.setToken(token);
		
//		paramPG.setTimestamp(Timestamp.valueOf(dateTime));
		
		
		//사용자 금액 분배 
		List<PurryGiVO> plist = new ArrayList<PurryGiVO>();
		plist = Utility.calSpreadMoney(paramPG);
		
		
		//service (list insert)
		PgService service = new PgService();
		int retCode = service.insertPurryGi(plist);
		
		//return 값 세팅
		JSONObject resJson = new JSONObject();
		resJson.put("token", token);

		if(retCode == Integer.parseInt(paramPG.getRecieverTotCnt())) {
			resJson.put("retCode", 200);
		}else {
			resJson.put("retCode", -1);
		}
		
		
		Gson gson = new Gson();
		String json = gson.toJson(resJson);

		return json;
	}
	
	@RequestMapping(value = "/recieveMoney", method=RequestMethod.PUT)
	public String receiveMoney(@RequestBody String token, String userID) throws JSONException {
		
		//result 선언
		JSONObject resJson = new JSONObject();
		resJson.put("token", token);


		
		//validation check
		/*1.token 값으로 불러온 뿌리기 정보에 사용자가 받은이에 있는지
		 * 2. userId가 owner는 아닌지
		 * 3. 대화방의 사용자인지  
		 * 4. 10분 지났는지  
		 * */
		PgService service = new PgService();
		List<PurryGiVO> pList = service.selectPurryGiInfoByToken(token);
		if(pList.size() < 1) {
			
			resJson.put("retCode", 10);
			resJson.put("retMsg", "유효한 뿌리기가 없습니다.");

			Gson gson = new Gson();
			String json = gson.toJson(resJson);
			return json;
		}
		
		
		
		
		PurryGiVO purrygi = new PurryGiVO();
//		purrygi.setTimestamp(timestamp);
		purrygi.setReceiverID(userID);
		purrygi.setToken(token);
		
		
		//userId update
		int retCode = service.updatePurryGi(purrygi);
		 
		
		Gson gson = new Gson();
		String json = gson.toJson(resJson);
		
		return json;
	}

	@RequestMapping(value = "/getInfo", method=RequestMethod.GET)
	public String getInfo(JSONObject param) {
		return "{\"result\": \"200\"}";
	}
	

}
