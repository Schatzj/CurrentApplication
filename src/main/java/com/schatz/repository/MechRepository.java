package com.schatz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schatz.models.Mech;

@Repository
public interface MechRepository extends CrudRepository<Mech, Integer>{
	
//	@Query("SELECT record FROM ApplicationMenuItem record WHERE record.role = :role "
//			+ "AND (record.name != :name OR record.name is null)")
//	List<ApplicationMenuItem> findByRoleAndNameNotOrNameIsNull(@Param("role") String role, @Param("name") String name);
	
	@Query("SELECT record FROM Mech record WHERE record.mech_id = :id")
	Mech findByid(@Param("id") int mech_id);
	
	@Query("SELECT record FROM Mech record WHERE record.mech_name = :name")
	List<Mech> findByname(@Param("name") String name);
	
	@Query("SELECT record FROM Mech record")
	List<Mech> getAllMechs();
	
	/*@Query("SELECT record FROM ApplicationMenuItem record WHERE record.role in (:roles) "
			+ "AND (record.name != :name OR record.name is null)")
	List<ApplicationMenuItem> getUserMenuItemList(@Param("roles") List<String> roles, @Param("name") String name);*/

}
