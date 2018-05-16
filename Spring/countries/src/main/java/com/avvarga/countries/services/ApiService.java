package com.avvarga.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.avvarga.countries.repositories.Repo;

@Service
public class ApiService {
	
	private final Repo repo;
	public ApiService (Repo repo) {
		this.repo = repo;
	}
	
	public void findCountriesSlovene() {
		List <Object[]> table = repo.findCountriesSlovene();
		for (Object[] row : table) {
			String c = (String) row[0];
			String l = (String) row[1];
			Double p = (Double) row[2];
			System.out.println(c);
			System.out.println(l);
			System.out.println(p);
		}
	}
	
	public void showCitiesPerCountry() {
		List <Object[]> table = repo.showCitiesPerCountry();
		for (Object[] row : table) {
			String c = (String) row[0];
			Long n = (long) row[1];
			System.out.println(c);
			System.out.println(n);			
		}
	}
	
	public void mexicanCitiesOver500k() {
		List<String> table = repo.mexicanCitiesOver500k();
		for (String row : table) {
			System.out.println(row);			
		}
	}
	
	public void languagesPerCountryOver89() {
		List <Object[]> table = repo.languagesPerCountryOver89();
		for (Object[] row : table) {
			String c = (String) row[0];
			String l = (String) row[1];
			Double p = (Double) row[2];
			System.out.println(l);
			System.out.println(c);
			System.out.println(p);
		}
	}

	public void countriesSmaller500PopulationOver100k() {
		List <Object[]> table = repo.countriesSmaller500PopulationOver100k();
		for (Object[] row : table) {
			System.out.println(row[0]);
			System.out.println(row[1]);
			System.out.println(row[2]);
		}
	}
	
	public void countriesWithConstitutionalMonarchy() {
		List <String> x = repo.countriesWithConstitutionalMonarchy();
		for (String s : x) {
			System.out.println(s);
		}
	}
	
	public void citiesBuenosairesOver500k() {
		List <Object[]> table = repo.citiesBuenosairesOver500k();
		for (Object[] row : table) {
			System.out.println(row[0]);
			System.out.println(row[1]);
			System.out.println(row[2]);
			System.out.println(row[3]);
		}
	}
	
	public void citiesPerRegion() {
		List <Object[]> table = repo.citiesPerRegion();
		for (Object[] row : table) {
			System.out.println(row[0]);
			System.out.println(row[1]);
		}
	}
}

