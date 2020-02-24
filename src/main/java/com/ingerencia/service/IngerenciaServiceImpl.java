package com.ingerencia.service;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ingerencia.dto.IngerenciaResponseDto;
import com.ingerencia.dto.JsonBodyResponseDto;
import com.ingerencia.repository.IngerenciaRepository;
import com.ingerencia.repository.JsonBodyRepository;
import com.ingerencia.util.JsonObjectMapper;

@Service
public class IngerenciaServiceImpl implements IngerenciaService {
	
	@Value("${nodejs.api}")
	private String nodejsApi;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IngerenciaRepository repository;
	
	@Autowired
	private JsonBodyRepository jsonRepository;
	
	
	@Override
	public String getNews() throws IOException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		ResponseEntity<String> response = restTemplate.exchange(nodejsApi, HttpMethod.GET, entity, String.class);
		
		JsonObjectMapper jsonMapper = new JsonObjectMapper();
		ArrayList<JsonBodyResponseDto> jsonBodyResponse = new ArrayList<>();
		IngerenciaResponseDto ingerenciaResponse = new IngerenciaResponseDto();
		
		if(response.getStatusCode() == HttpStatus.OK) {
			
			jsonBodyResponse = jsonMapper.jsonBodyResponseMapper(response.getBody());
			
			for(JsonBodyResponseDto item : jsonBodyResponse) {
				jsonRepository.save(item);
			}
			
			ingerenciaResponse = jsonMapper.jsonIngerenciaResponseMapper(response.getBody());
			repository.save(ingerenciaResponse);
			
			return response.getBody();
	    } else {
	        return "Error en la llamada -> " + response.getStatusCode();
	    }
	}

}
