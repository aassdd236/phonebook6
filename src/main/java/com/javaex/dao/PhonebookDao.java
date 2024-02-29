package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	// 전체가져오기
	@Autowired
	private SqlSession sqlSession;

	//삭제
	public int personDelete(int no) {
		System.out.println("PhonebookDao.delete()");
		
		int count=sqlSession.delete("phonebook.delete", no);
		System.out.println(count);
		return count;
	}

	// 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("PhonebookDao.update()");
		
		int count=sqlSession.update("phonebook.update", personVo);
		System.out.println(count);
		return count;
	}

	
	// 1개 가져오기
	public PersonVo personSelectOne(int no) {
		System.out.println("PhonebookDao.personSelectOne()");

		PersonVo personVo=sqlSession.selectOne("phonebook.selectOne", no);
		System.out.println(personVo);
		return personVo;
	}
	
	public Map<String, Object> personSelectOne2(int no) {
		System.out.println("PhonebookDao.personSelectOne2()");
		System.out.println(no);
		
		Map<String, Object> pMap = sqlSession.selectOne("phonebook.selectOne2", no);
		System.out.println(pMap.get("name"));
		
		return pMap;
	}

	// 등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");
		int count = sqlSession.insert("phonebook.insert",personVo);
		return count;
	}
	
	public int personInsert2(Map<String, String> pMap) {
		System.out.println("PhonebookDao.personInsert2()");
		System.out.println(pMap.toString());
		
		int count=sqlSession.insert("phonebook.insert2", pMap);
		return count;
	}

	public List<PersonVo> personSelect() {
		System.out.println("PhonebookDao.personSelect()");

		List<PersonVo> personList=sqlSession.selectList("phonebook.select"); //namespace.id(phonebook.xml에서)
		System.out.println(personList);

		return personList;
	}

}
