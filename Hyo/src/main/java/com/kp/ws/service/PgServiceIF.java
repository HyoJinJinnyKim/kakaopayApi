package com.kp.ws.service;

import com.kp.ws.vo.PurryGiVO;
import java.util.List;

public interface PgServiceIF {
	
	public int insertPurryGi(List<PurryGiVO> purrygi);
	
	public int updatePurryGi(PurryGiVO purrygi); 
	
	public List<PurryGiVO> selectPurryGiInfoByToken(String token); //토큰으로 정

	//param userid 가 receiverId 또는 ownerId 에는 없는지 union all 로 조회
	public int selectPurryGiInfoByUserId(String userId);  
	
}
