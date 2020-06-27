package com.kp.ws.service;

import com.kp.ws.vo.PurryGiVO;
import java.util.List;

public interface PgServiceIF {
	
	public int insertPurryGi(List<PurryGiVO> purrygi);
	
	public void updatePurryGi(PurryGiVO purrygi); 
	
	public List<PurryGiVO> selectPurryGiInfo(String token);

	
}
