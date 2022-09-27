package com.example;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ActorRepository dao;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		System.out.println("Hola mundo");
//		dao.findAll().forEach(System.out::println);
//		var item = dao.findById(1111);
//		if(item.isPresent()) {
//			System.out.println(item.get());
//		} else {
//			System.out.println("No encontrado");
//		}
//		var item = new Actor(0, "Pepito", "Grillo");
//		dao.save(item);
//		dao.findAll().forEach(System.out::println);
//		var item = dao.findById(204);
//		if(item.isPresent()) {
//			var actor = item.get();
//			actor.setFirstName(actor.getFirstName().toUpperCase());
//			dao.save(actor);
//			dao.findAll().forEach(System.out::println);
//		} else {
//			System.out.println("No encontrado");
//		}
//		dao.deleteById(204);
//		dao.findTop10ByFirstNameStartingWithOrderByLastNameDesc("P").forEach(System.out::println);
//		dao.findTop10ByFirstNameStartingWith("P", Sort.by("firstName")).forEach(System.out::println);
//		dao.findByActorIdGreaterThan(200).forEach(System.out::println);
//		dao.recuperaNuevosJPQL(200).forEach(System.out::println);
//		dao.recuperaNuevosSQL(200).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThan(root.get("actorId"), 200)).forEach(System.out::println);
//		var item = dao.findById(1);
//		if(item.isPresent()) {
//			System.out.println(item.get());
//			item.get().getFilmActors().forEach(ele -> System.out.println(ele.getFilm().getTitle()));
//		} else {
//			System.out.println("No encontrado");
//		}
		var item = new Actor(0, null, "12345678Z");
		if(item.isInvalid())
			System.out.println(item.getErrorsMessage());
		else
			dao.save(item);
		
	}

}
