package com.schatz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schatz.models.Equipment;

@Repository
public interface EqiupmentRepository extends CrudRepository<Equipment, Long>{
	
	@Query("SELECT record FROM Equipment record WHERE record.mechid = :id")
	public List<Equipment> findAllByMechId(@Param("id")int id);
	
	@Query("SELECT record FROM Equipment record WHERE record.id = :id")
	public Equipment findById(@Param("id")long id);

}
