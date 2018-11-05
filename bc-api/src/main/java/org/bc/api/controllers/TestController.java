package org.bc.api.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bc.api.config.ApplicationConfig;
import org.bc.api.services.PersonService;
import org.bc.common.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tests")
public class TestController {

	@Autowired
	private ApplicationConfig config;
	@Autowired
	private PersonService personService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Person> list() {
		System.out.println("配置测试：" + config.getName());
		System.out.println("配置测试：" + config.getEnv());
		List<Person> list = new ArrayList<>();
		Person p = new Person();
		p.setId(1);
		p.setName("测试");
		p.setTime(new Date());
		list.add(p);
		return list;
	}
	
	@RequestMapping(value = "/{testId}", method = RequestMethod.GET)
	public Person get(@PathVariable("testId") Integer testId) {
//		Person p = new Person();
//		p.setId(testId);
//		p.setName("测试");
//		p.setTime(new Date());
//		return p;
		return personService.getPersonById(testId);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void create() {
		System.out.println("Created");
	}
	
	@RequestMapping(value = "/{testId}", method = RequestMethod.PUT)
	public void update() {
		System.out.println("Updated");
	}
	
	@RequestMapping(value = "/{testId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("testId") Integer testId) {
		System.out.println("Deleted: " + testId);
	}
	
}
