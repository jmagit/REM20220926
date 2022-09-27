package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		dao.deleteById(204);
		dao.findAll().forEach(System.out::println);
	}

}
