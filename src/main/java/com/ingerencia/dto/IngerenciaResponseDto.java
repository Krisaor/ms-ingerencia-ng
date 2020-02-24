package com.ingerencia.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="ingerencia_response_dto")
public class IngerenciaResponseDto {
	
	@JsonProperty("hits")
	private String hits;
	
	@Id
	@JsonProperty("nbHits")
	private Integer nbHits;
	
	@JsonProperty("page")
	private Integer page;
	
	@JsonProperty("nbPages")
	private Integer nbPages;
	
	@JsonProperty("hitsPerPage")
	private Integer hitsPerPage;
	
	@JsonProperty("exhaustiveNbHits")
	private boolean exhaustiveNbHits;
	
	@JsonProperty("query")
	private String query;
	
	@JsonProperty("params")
	private String params;
	
	@JsonProperty("processingTimeMS")
	private Integer processingTimeMs;
	
	
}
