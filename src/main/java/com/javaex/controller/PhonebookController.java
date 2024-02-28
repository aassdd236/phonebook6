package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@Controller
public class PhonebookController {
	//필드
	//메모리에 올리기
	@Autowired
	private PhonebookService phonebookService;

	//등록
	//http://localhost:8080/phonebook5/phone/write?name=이예슬&hp=010&company=02
	  @RequestMapping(value ="/phone/write", method = {RequestMethod.GET,RequestMethod.POST})
	   public String write(@RequestParam(value="name") String name,
	         @RequestParam(value="hp")String hp,
	         @RequestParam(value="company")String company) {
	      System.out.println("PhonebookController.write");
	      System.out.println(name);
	      System.out.println(hp);
	      System.out.println(company);
	      
	      PersonVo personVo = new PersonVo(name,hp,company);
	      PhonebookDao phonebookDao = new PhonebookDao();
	      phonebookDao.personInsert(personVo);
	      
	      
	      return "redirect:/phone/list";

	  }

	@RequestMapping(value="/phone/write2", method= {RequestMethod.GET, RequestMethod.POST })
	public String write2(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write2()");

		System.out.println(personVo.toString());

		phonebookService.exeWrite(personVo);


		return "redirect:/phone/list";
	}

	
	//메소드
	@RequestMapping(value="/phone/list", method= {RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhonebookController.list()");

		//자동연결
		//PhonebookService phonebookService=new PhonebookService();
		List<PersonVo> personList=phonebookService.exeList();

		System.out.println(personList);

		model.addAttribute("pList", personList);


		return "list";
	}

	//삭제
	@RequestMapping(value="/phone/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no) {
		System.out.println("PhonebookController.delete()");

		System.out.println(no);

		phonebookService.exeDelete(no);

		return "redirect:/phone/list";
	}


	//수정
	@RequestMapping(value="/phone/modify", method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.modify()");
		System.out.println(personVo);

		phonebookService.exeModify(personVo);


		return "redirect:/phone/list";
	}

	//수정폼
	@RequestMapping(value="/phone/modifyform", method= {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value="no") int no, Model model) {
		System.out.println("PhonebookController.modifyForm()");
		System.out.println(no);

		PersonVo personVo=phonebookService.exeModifyForm(no);

		model.addAttribute("personVo", personVo);
		return "modifyForm";
	}

	//localhost:8080/phonebook5/phone/writeForm
	@RequestMapping(value="/phone/writeForm", method= {RequestMethod.POST, RequestMethod.GET})
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");

		return "writeForm";
	}


}
