package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	@Autowired
	private PhonebookDao phonebookDao;
	
	//등록
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite()");

		//비지니스로직X
		int count = phonebookDao.personInsert(personVo);
		
		return count;
	}

	public int exeWrite2(String name, String hp, String company) {
		System.out.println("PhonebookService.exeWrite2()");

		 System.out.println(name);
	     System.out.println(hp);
	     System.out.println(company);
		
	     //personVo로 묶기
	     Map<String, String> personMap=new HashMap<String, String>();
	     personMap.put("name", name);
	     personMap.put("hp", hp);
	     personMap.put("company", company);
	     
	     int count=phonebookDao.personInsert2(personMap);
	     
	     
		return count;
	}
	//
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");

		List<PersonVo> personList=phonebookDao.personSelect();

		return personList;
	}

	public int exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete()");
		
		int count=phonebookDao.personDelete(no);
		
		return count;
	}

	public PersonVo exeModifyForm(int no) {
		System.out.println("PhonebookService.exeModifyForm()");
		
		PersonVo personVo=phonebookDao.personSelectOne(no);
		
		return personVo;
	}

	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");
		
		//PhonebookDao phonebookDao=new PhonebookDao();
		int count = phonebookDao.personUpdate(personVo);
		
		return count;
	}

	public Map<String, Object> exeModifyForm2(int no) {
		System.out.println("PhonebookService.exeModifyForm2()");
		System.out.println(no);
		Map<String, Object> pMap=phonebookDao.personSelectOne2(no);

		return pMap;
	}






}
