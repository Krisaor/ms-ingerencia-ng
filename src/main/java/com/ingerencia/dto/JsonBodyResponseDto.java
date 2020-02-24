package com.ingerencia.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="json_body_response_dto")
@JsonIgnoreProperties( value = { "_highlightResult" } )
public class JsonBodyResponseDto {
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("author")
	private String author;
	
	@JsonProperty("points")
	private Integer points;
	
	@JsonProperty("story_text")
	@Column(length=2000)
	private String storyText;
	
	@JsonProperty("comment_text")
	@Column(length=10000)
	private String commentText;
	
	@JsonProperty("num_comments")
	private Integer numComments;
	
	@JsonProperty("story_id")
	private Integer storyId;
	
	@JsonProperty("story_title")
	private String storyTitle;
	
	@JsonProperty("story_url")
	private String storyUrl;
	
	@JsonProperty("parent_id")
	private Integer parentId;
	
	@JsonProperty("created_at_i")
	private Integer createdAtI;
	
	@JsonProperty("_tags")
	private String[] tags;
	
	@Id
	@JsonProperty("objectID")
	private String objectId;
	
}
