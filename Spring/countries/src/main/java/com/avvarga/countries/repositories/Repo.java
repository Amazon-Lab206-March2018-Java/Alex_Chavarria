package com.avvarga.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.avvarga.countries.models.Country;

@Repository
public interface Repo extends CrudRepository <Country, Long>{
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE language = 'Slovene' ORDER BY l.percentage DESC")
	List<Object[]> findCountriesSlovene();
	
	@Query("SELECT c.name, COUNT (d) FROM Country c JOIN c.cities d GROUP BY c.name ORDER BY COUNT(d) DESC")
	List<Object[]> showCitiesPerCountry();
	
	@Query("SELECT d.name FROM Country c JOIN c.cities d WHERE c.name = 'Mexico' AND d.population > 500000 ORDER BY d.name" )
	List<String> mexicanCitiesOver500k();
	
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE percentage > 89 ORDER BY l.percentage DESC")
	List<Object[]> languagesPerCountryOver89();
	
	@Query("SELECT name, surfaceArea, population FROM Country c WHERE surfaceArea < 501 AND population > 100000")
	List<Object[]> countriesSmaller500PopulationOver100k();
	
	@Query("SELECT name FROM Country WHERE governmentForm = 'Constitutional Monarchy' AND surfaceArea > 200 AND lifeExpectancy > 75")
	List<String> countriesWithConstitutionalMonarchy();
	
	@Query("SELECT c.name, a.name, a.district, a.population FROM Country c JOIN c.cities a WHERE c.name = 'Argentina' AND a.district = 'Buenos Aires' AND a.population > 500000")
	List<Object[]> citiesBuenosairesOver500k();
	
	@Query("SELECT region, COUNT (name) FROM Country GROUP BY region ORDER BY COUNT (name) DESC")
	List<Object[]> citiesPerRegion();
	
}
