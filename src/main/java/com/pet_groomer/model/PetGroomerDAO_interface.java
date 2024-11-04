package com.pet_groomer.model;

import java.util.*;

public interface PetGroomerDAO_interface {
	public void insert(PetGroomerVO petGroomerVO);

	public void update(PetGroomerVO petGroomerVO);

	public void delete(Integer pgId); //pgId為PK,根據ID做刪除

	public PetGroomerVO findByPrimaryKey(Integer pgId);//pgId為PK,根據ID做查詢

	public List<PetGroomerVO> getAll(); //列出所有資料
	
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
	//  public List<EmpVO> getAll(Map<String, String[]> map);

}
