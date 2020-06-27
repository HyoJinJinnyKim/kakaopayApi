package com.kp.ws.home;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kp.ws.service.PgService;
import com.kp.ws.uc.Utility;
import com.kp.ws.vo.PurryGiVO;

@RestController
public class ApiController {

	@RequestMapping(value = "/spreadMoney", method=RequestMethod.POST)
	public String spreadMoney(@RequestBody PurryGiVO paramPG) throws JSONException {
		
		System.out.println("paramPG :@@@@@"+paramPG.toString());
		
		//토큰생성 
		paramPG.setToken("ABC");
		String res = Utility.createToken(paramPG);
		
				
		
		
		//사용자 금액 분배 
		List<PurryGiVO> plist = new ArrayList<PurryGiVO>();
		plist = Utility.calSpreadMoney(paramPG);
		
		
		//service (list insert)
		PgService service = new PgService();
		service.insertPurryGi(plist);
		
		//header 에 토큰 넣기
		paramPG = Utility.setHeaderToken(paramPG);

		//return 보내기
		String ret = res.toString();
		
//		JSONObject res = new JSONObject();
//		res.put("responseCode", 200);
//		res.put("data", 10);

		
		
		
//		Gson gson = new Gson();
//		String json = gson.toJson(prryGi);
//		System.out.println("!!!!!!!!!!!!!!!!!!"+json);
		
		
//        res.put(null, 10);
//		JSONObject res ="{\"result\": \"200\"}" 
		return ret;
	}
	
	@RequestMapping(value = "/recieveMoney", method=RequestMethod.PUT)
	public String receiveMoney(JSONObject param) {
		
		return "{\"result\": \"200\"}";
	}

	@RequestMapping(value = "/getInfo", method=RequestMethod.GET)
	public String getInfo(JSONObject param) {
		return "{\"result\": \"200\"}";
	}
	

}
