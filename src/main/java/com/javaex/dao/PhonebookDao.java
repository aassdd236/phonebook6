package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

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

	// 등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");
		int count = sqlSession.insert("phonebook.insert",personVo);
		return count;
	}

	public List<PersonVo> personSelect() {
		System.out.println("PhonebookDao.personSelect()");

		List<PersonVo> personList=sqlSession.selectList("phonebook.select"); //namespace.id(phonebook.xml에서)
		System.out.println(personList);

		return personList;
	}

}
