package com.project.TheLostItemFinder.lostItem.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("officeService")
public class OfficeService {
	
	@Resource(name="officeDAO")
	OfficeDAOImpl dao=new OfficeDAOImpl();
	
	@Resource(name="articleDAO")
	ArticleDAOImpl adao=new ArticleDAOImpl();
	
	
	public OfficeDTO getOneOffice(int seq){
		return dao.getOneOffice(seq);
	}

	public boolean updateOffice(String name, String tel, String location) {
		OfficeDTO dto= new OfficeDTO();
		dto.setNAME(name);
		dto.setLOCATION(location);
		dto.setTEL(tel);
		if(dao.updateOffice(dto)) {
			return true;
		}
		return false;
	}

	public int totalPage(int limit, String officeName) {
		return adao.adminTotalPage(limit, officeName);
	}
}
