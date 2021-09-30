package com.coffee.pot.assignment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coffee.pot.assignment.domain.Arabica;
import com.coffee.pot.assignment.domain.Robusta;
import com.coffee.pot.assignment.repository.arabica.ArabicaOperations;
import com.coffee.pot.assignment.repository.arabica.ArabicaRepository;
import com.coffee.pot.assignment.repository.robusta.RobustaOperations;
import com.coffee.pot.assignment.repository.robusta.RobustaRepository;

@Service
public class CoffeeService {
	@Autowired
	ArabicaRepository arabicaRepository;
	@Autowired
	RobustaRepository robustaRepository;
	
	@Autowired
	ArabicaOperations arabicaOperations;
	@Autowired
	RobustaOperations robustaOperations;
	
	private final Logger LOG = LoggerFactory.getLogger(CoffeeService.class);

	
	public List<Arabica>getAllArabica(){
		return arabicaRepository.findAll();
	}
	public List<Arabica>getArabicaById(String _id){
		return arabicaRepository.getArabicaBy_id(_id);
	}
	public Arabica addNewArabicaSample(Arabica arabica) {
		return arabicaRepository.save(arabica);
	}
	public ResponseEntity<Arabica> alterArabicaSample(Arabica arabica, String _id){
		return new ResponseEntity<>(arabicaRepository.save(arabica), HttpStatus.OK);
	}
	public void deleteArabicaSample(String _id) {
		arabicaRepository.deleteById(_id);
	}
	
	
	
	public List<Robusta>getAllRobusta(){
		return robustaRepository.findAll();
	}
	public List<Robusta>getRobustaById(String _id){
		return robustaRepository.getRobustaBy_id(_id);
	}
	public Robusta addNewRobustaSample(Robusta robusta) {
		return robustaRepository.save(robusta);
	}
	public ResponseEntity<Robusta> alterRobustaSample(Robusta robusta, String _id) {
		return new ResponseEntity<>(robustaRepository.save(robusta), HttpStatus.OK);
	}
	public void deleteRobustaSample(String _id) {
		robustaRepository.deleteById(_id);
	}
	

	public List<Arabica>getRandomArabicaSampling(Integer size){
		Integer limit = arabicaRepository.findAll().size();
		if(size <= limit) {
			return arabicaOperations.getRandomResults(size);
		} else {
			LOG.info("Size of " + size + " was too large. Returning all " + limit + " Arabica entries present in the collection.");
			return arabicaRepository.findAll();
			}
	}
	public List<Robusta>getRandomRobustaSampling(Integer size){
		Integer limit = robustaRepository.findAll().size();
		if(size <= robustaRepository.findAll().size()) {
			return robustaOperations.getRandomResults(size);
		} else {
			LOG.info("Size of " + size + " was too large. Returning all " + limit + " Robusta entries present in the collection.");
			return robustaRepository.findAll();
		}
	}
	
}
	