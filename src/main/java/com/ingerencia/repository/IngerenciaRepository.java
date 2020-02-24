package com.ingerencia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingerencia.dto.IngerenciaResponseDto;

@Repository
public interface IngerenciaRepository extends CrudRepository<IngerenciaResponseDto, Integer> {

}
