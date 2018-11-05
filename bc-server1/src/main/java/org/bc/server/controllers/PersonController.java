package org.bc.server.controllers;

import java.util.Date;

import org.bc.common.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/persons")
public class PersonController {

	@RequestMapping(value = "/{personId}", method = RequestMethod.GET)
	public Person get(@PathVariable("personId") Integer personId) {
		Person p = new Person();
		p.setId(personId);
		p.setName("Server1");
		p.setTime(new Date());
		return p;
	}
	
}
