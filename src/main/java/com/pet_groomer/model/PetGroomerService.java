package com.pet_groomer.model;

import java.util.List;

public class PetGroomerService {

	private PetGroomerDAO_interface dao;

	public PetGroomerService() {
		dao = new PetGroomerJDBCDAO();
	}

	public PetGroomerVO addPetGroomer(String pgName, String pgArea, String schDate, String schTime, String pgStatus,
			String pgBio,String pgPw, String pgEmail) {

		PetGroomerVO petGroomerVO = new PetGroomerVO();

		petGroomerVO.setPgName(pgName);
		petGroomerVO.setPgArea(pgArea);
		petGroomerVO.setSchDate(schDate);
		petGroomerVO.setSchTime(schTime);
		petGroomerVO.setPgStatus(pgStatus);
		petGroomerVO.setPgBio(pgBio);
		petGroomerVO.setPgPw(pgPw);
		petGroomerVO.setPgEmail(pgEmail);
		dao.insert(petGroomerVO);

		return petGroomerVO;
	}

	public PetGroomerVO updatePetGroomer(String pgName, String pgArea, String schDate, String schTime, String pgStatus,
			String pgBio, String pgPw, String pgEmail, Integer totalStars, Integer ratingTimes, Integer reportTimes,
			Integer pgId) {

		PetGroomerVO petGroomerVO = new PetGroomerVO();

		petGroomerVO.setPgName(pgName);
		petGroomerVO.setPgArea(pgArea);
		petGroomerVO.setSchDate(schDate);
		petGroomerVO.setSchTime(schTime);
		petGroomerVO.setPgStatus(pgStatus);
		petGroomerVO.setPgBio(pgBio);
		petGroomerVO.setPgPw(pgPw);
		petGroomerVO.setPgEmail(pgEmail);
		petGroomerVO.setTotalStars(totalStars);
		petGroomerVO.setRatingTimes(ratingTimes);
		petGroomerVO.setReportTimes(reportTimes);
		petGroomerVO.setPgId(pgId);
		dao.update(petGroomerVO);

		return petGroomerVO;
	}

	public void deletePetGroomer(Integer pgId) {
		dao.delete(pgId);
	}

	public PetGroomerVO getOnePg(Integer pgId) {
		return dao.findByPrimaryKey(pgId);
	}

	public List<PetGroomerVO> getAll() {
		return dao.getAll();
	}
}
