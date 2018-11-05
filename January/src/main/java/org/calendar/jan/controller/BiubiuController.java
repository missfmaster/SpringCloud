package org.calendar.jan.controller;

import java.util.List;

import org.calendar.jan.model.Biubiu;
import org.calendar.jan.service.BiubiuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BiubiuController {

	private Logger log = LoggerFactory.getLogger(BiubiuController.class);
	
	@Autowired
	private BiubiuService biubiuService;
	
	@RequestMapping("/index")
	public String showIndex() {
		log.info("显示首页.");
		return "index";
	}
	
	@RequestMapping("/biubiu")
	public @ResponseBody List<Biubiu> queryList() {
		log.info("查询所有集合列表.");
		List<Biubiu> list = biubiuService.queryBiubius();
		return list;
	}
	
	@RequestMapping("/biubiu/{id}")
	public Biubiu queryItem(@PathVariable("id") Integer id) {
		biubiuService.queryBiubiu(id);
		return null;
	}
	
}
