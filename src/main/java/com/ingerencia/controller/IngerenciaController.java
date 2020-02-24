package com.ingerencia.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingerencia.service.IngerenciaService;

@RestController
@RequestMapping("/ingerencia")
public class IngerenciaController {
	
	@Autowired
	private IngerenciaService service;
	
	@GetMapping(
			value="/get-news",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@Scheduled(cron="* * 1 * * *")
	public String getNews() throws IOException{
		
		return service.getNews();
	}
	
}
