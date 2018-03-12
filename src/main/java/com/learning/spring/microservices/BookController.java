package com.learning.spring.microservices;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping ("/book/search")
public class BookController {
	
	//Expose an end point - get method
	@RequestMapping (path="/title", method=RequestMethod.GET)
//	public String findByTitle (@PathVariable("titleId") String titleId) throws URISyntaxException {
	public String findByTitle (@RequestParam ("titleId") String titleId) throws URISyntaxException {
		RestTemplate template = new RestTemplate();
		URI uri = new URI ("http://localhost:9999/book/search/title?title=" + titleId);
		return template.getForObject(uri, String.class);
	}
}
