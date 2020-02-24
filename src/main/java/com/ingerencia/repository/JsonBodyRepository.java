package com.ingerencia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingerencia.dto.JsonBodyResponseDto;

@Repository
public interface JsonBodyRepository extends CrudRepository<JsonBodyResponseDto, String> {

}
