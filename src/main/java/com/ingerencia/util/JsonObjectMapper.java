package com.ingerencia.util;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ingerencia.dto.IngerenciaResponseDto;
import com.ingerencia.dto.JsonBodyResponseDto;

public class JsonObjectMapper {
	
	
	public ArrayList<JsonBodyResponseDto> jsonBodyResponseMapper(String restResponse) throws IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<JsonBodyResponseDto> jsonBodyDto = new ArrayList<>();
		
		JSONObject jsonobject = new JSONObject(restResponse);
		JSONArray jsonarray = jsonobject.getJSONArray("hits");
		
		for (int i=0; i <jsonarray.length(); i++) {
			
			JSONObject object = jsonarray.getJSONObject(i);
			jsonBodyDto.add(mapper.readValue(object.toString(), JsonBodyResponseDto.class));
		}
		
		
		return jsonBodyDto;
	}
	
	
	
	public IngerenciaResponseDto jsonIngerenciaResponseMapper(String restResponse) {
		
		IngerenciaResponseDto responseDto = new IngerenciaResponseDto();
		JSONObject jsonobject = new JSONObject(restResponse);
		
		responseDto.setNbHits(jsonobject.getInt("nbHits"));
		responseDto.setPage(jsonobject.getInt("page"));
		responseDto.setNbPages(jsonobject.getInt("nbPages"));
		responseDto.setHitsPerPage(jsonobject.getInt("hitsPerPage"));
		responseDto.setExhaustiveNbHits(jsonobject.getBoolean("exhaustiveNbHits"));
		responseDto.setQuery(jsonobject.getString("query"));
		responseDto.setParams(jsonobject.getString("params"));
		responseDto.setProcessingTimeMs(jsonobject.getInt("processingTimeMS"));
		
		return responseDto;
	}
	
}
