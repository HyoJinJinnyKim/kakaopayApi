package com.kp.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kp.ws.vo.PurryGiVO;

@Service
public class PgService implements PgServiceIF{

	@Override
	public int insertPurryGi(List<PurryGiVO> purrygi) {
		// DAO 
		
		return 0;
	}

	@Override
	public int updatePurryGi(PurryGiVO purrygi) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<PurryGiVO> selectPurryGiInfoByToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectPurryGiInfoByUserId(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
