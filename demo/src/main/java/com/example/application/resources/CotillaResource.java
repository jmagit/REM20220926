package com.example.application.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.application.proxies.CatalogoProxy;
import com.example.domains.entities.dtos.PelisDto;

@RestController
@RequestMapping(path = "/api/cotilla")
public class CotillaResource {
	@Autowired
	RestTemplate srv;
	
	@GetMapping(path = "/balancea/rt")
	public String getBalanceoRT() {
		return srv.getForObject("lb://CATALOGO-SERVICE/", String.class);
//		return srv.getForObject("http://localhost:8010/", String.class);
	}
	@GetMapping(path = "/pelis/rt")
	public List<PelisDto> getPelisRT() {
		ResponseEntity<List<PelisDto>> response = srv.exchange(
				"lb://CATALOGO-SERVICE/v1/peliculas?mode=short", 
//				"http://localhost:8010/v1/peliculas?mode=short", 
				HttpMethod.GET,
				HttpEntity.EMPTY, 
				new ParameterizedTypeReference<List<PelisDto>>() {}
		);
		return response.getBody();
	}
	@GetMapping(path = "/pelis/{id}/rt")
	public PelisDto getPelisRT(@PathVariable int id) {
		return srv.getForObject("lb://CATALOGO-SERVICE/v1/peliculas/{key}?mode=short", PelisDto.class, id);
//		return srv.getForObject("http://localhost:8010/v1/peliculas/{key}?mode=short", PelisDto.class, id);
	}
	
	@Autowired
	CatalogoProxy proxy;

	@GetMapping(path = "/balancea/proxy")
	public String getBalanceoProxy() {
		return proxy.getCatalogo();
	}
	@GetMapping(path = "/pelis/proxy")
	public List<PelisDto> getPelisProxy() {
		return proxy.getPelis();
	}
	@GetMapping(path = "/pelis/{id}/proxy")
	public PelisDto getPelisProxy(@PathVariable int id) {
		return proxy.getPeli(id);
	}
	@GetMapping(path = "/pelis/like")
	public String getPelisLike() {
		return proxy.meGusta(1);
	}
	@Value("${particular.para.demos}")
	String config;
	
	@GetMapping(path = "/config")
	public String getConfig() {
		return config;
	}

}
