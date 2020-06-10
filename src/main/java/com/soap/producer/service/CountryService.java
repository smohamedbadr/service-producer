package com.soap.producer.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;

@Service
public class CountryService {
	
	private static final Map<String, Country> countries = new HashMap<>();

	@PostConstruct
	public void initialize () {
		
		Country india = new Country ();
		india.setName("India");
		india.setCapital("Delhi");
		india.setCurrency(Currency.INR);
		india.setPopulation(100000);
		
		countries.put(india.getName(), india);
		
		
		Country usa = new Country ();
		usa.setName("USA");
		usa.setCapital("Washington");
		usa.setCurrency(Currency.DLR);
		usa.setPopulation(10009);
		
		countries.put(usa.getName(), usa);
		
		
		Country uk = new Country ();
		uk.setName("UK");
		uk.setCapital("London");
		uk.setCurrency(Currency.EUR);
		uk.setPopulation(1000);
		
		countries.put(uk.getName(), uk);
		
		
	}
	
	public Country findCountry (String countryName ) {
		
		Assert.notNull(countryName, "The country's name must not be null");
		
		return countries.get(countryName);		
	}
}
