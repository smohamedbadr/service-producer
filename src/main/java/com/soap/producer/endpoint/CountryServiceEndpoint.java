package com.soap.producer.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.producer.service.CountryService;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@Endpoint
public class CountryServiceEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
	
	@Autowired
	private CountryService countryService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart="getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry (@RequestPayload GetCountryRequest request ) {
		
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryService.findCountry(request.getName()));
		return response;
	}
}