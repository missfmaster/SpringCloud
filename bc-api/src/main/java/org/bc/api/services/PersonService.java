package org.bc.api.services;

import org.bc.common.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("server1")
public interface PersonService {

	@RequestMapping(
			method = RequestMethod.GET,
			value = "/v1/persons/{personId}",
			consumes = "application/json")
	public Person getPersonById(@PathVariable("personId") Integer personId);
	
}