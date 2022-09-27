package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.domains.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor> {
	List<Actor> findTop10ByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
	List<Actor> findTop10ByFirstNameStartingWith(String prefijo, Sort orden);
	List<Actor> findByActorIdGreaterThan(int min);

	@Query(value = "SELECT a FROM Actor a WHERE a.actorId > ?1")
	List<Actor> recuperaNuevosJPQL(int min);

	@Query(value = "SELECT * FROM actor WHERE actor_id > ?1", nativeQuery = true)
	List<Actor> recuperaNuevosSQL(int min);
}
