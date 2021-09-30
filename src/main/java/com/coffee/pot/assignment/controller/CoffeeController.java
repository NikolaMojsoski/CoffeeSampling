package com.coffee.pot.assignment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.pot.assignment.domain.Arabica;
import com.coffee.pot.assignment.domain.Robusta;
import com.coffee.pot.assignment.repository.arabica.ArabicaOperations;
import com.coffee.pot.assignment.repository.robusta.RobustaOperations;
import com.coffee.pot.assignment.service.CoffeeService;

@RestController
public class CoffeeController {
	
	@Autowired
	CoffeeService coffeeService;
	
	@Autowired
	ArabicaOperations arabicaOperations;
	@Autowired
	RobustaOperations robustaOperations;
	
	private final Logger LOG = LoggerFactory.getLogger(CoffeeController.class);
	
	
	
	/**
	 * Aggregations sampling a specified number of entries.
	 * @return
	 */
	@RequestMapping(value = "getArabicaSample", method = RequestMethod.GET)
	public List<Arabica> getArabicaSample(@RequestParam Integer size){
		LOG.info("Retrieving sample of size " + size + ".");
		return coffeeService.getRandomArabicaSampling(size);
	}
	@RequestMapping(value = "getRobustaSample", method = RequestMethod.GET)
	public List<Robusta> getRobustaSample(@RequestParam Integer size){
		LOG.info("Retrieving sample of size " + size + ".");
		return coffeeService.getRandomRobustaSampling(size);
		}
	
	
	/**
	 * Retrieves all Arabica entries
	 * @return
	 */
	@RequestMapping(value = "getAllArabica", method = RequestMethod.GET)
	public List<Arabica> getAllArabica(){
		LOG.info("Retrieving all " + coffeeService.getAllArabica().size() + " Arabica entries.");
		return coffeeService.getAllArabica();
	}
	/**
	 * Retrieves all Robusta entries
	 */
	@RequestMapping(value = "getAllRobusta", method = RequestMethod.GET)
	public List<Robusta> getAllRobusta(){
		LOG.info("Retrieving all " + coffeeService.getAllRobusta().size() + " Robusta entries.");
		return coffeeService.getAllRobusta();
	}
	
	
	
	
	/**
	 * If you know a Coffee _id, retrieves that entry
	 * @param _id
	 * @return
	 */
	@RequestMapping(value = "getArabicaById/{_id}", method = RequestMethod.GET)
	public List<Arabica> getArabicaById(@PathVariable("_id") String _id) {
		LOG.info("Retrieving Arabica coffee.");
		return coffeeService.getArabicaById(_id);
	}
	@RequestMapping(value = "getRobustaById/{_id}", method = RequestMethod.GET)
	public List<Robusta> getRobustaById(@PathVariable("_id") String _id) {
		LOG.info("Retrieving Robusta coffee.");
		return coffeeService.getRobustaById(_id);
	}	
	
	
	/**
	 * Creation of a new Arabica Sampling entry
	 * @param arabica
	 * @return
	 */
	@RequestMapping(value = "/addNewArabicaSample", method = RequestMethod.POST)
	public Arabica addNewArabicaSample(@RequestBody Arabica arabica) {
		LOG.info("Adding new Arabica sampling:");
		return coffeeService.addNewArabicaSample(arabica);
	}
	/**
	 * Creation of a new Robusta Sampling entry
	 * @param robusta
	 * @return
	 */
	@RequestMapping(value = "/addNewRobustaSample", method = RequestMethod.POST)
	public Robusta addNewRobustaSample(@RequestBody Robusta robusta) {
		LOG.info("Adding new Robusta sampling");
		return coffeeService.addNewRobustaSample(robusta);
		}
	
	
	/**
	 * Editing of an extant Arabica sampling
	 * @param arabica
	 * @param _id
	 * @return
	 */
	@RequestMapping(value = "/alterArabicaSample/{_id}", method = RequestMethod.PUT)
	public ResponseEntity<Arabica> alterArabicaSample(@RequestBody Arabica arabica, @PathVariable String _id) {
		List<Arabica> tempSample = coffeeService.getArabicaById(_id);
		LOG.info("Checking to see if entry is present...");
		if(!tempSample.isEmpty()){
			LOG.info("Entry found--saving to collection.");
			coffeeService.addNewArabicaSample(arabica);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
			} else {
				LOG.info("Entry not found.");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	/**
	 * Editing of an extant Robusta sampling
	 * @param robusta
	 * @param _id
	 * @return
	 */
	@RequestMapping(value = "/alterRobustaSample/{_id}", method = RequestMethod.PUT)
	public ResponseEntity<Robusta> alterRobustaSample(@RequestBody Robusta robusta, @PathVariable String _id) {
		List<Robusta> tempSample = coffeeService.getRobustaById(_id);
		LOG.info("Checking to see if entry is present...");
		if(tempSample.isEmpty()) {
			LOG.info("Entry found--saving to collection.");
			coffeeService.addNewRobustaSample(robusta);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
			} else {
				LOG.info("Entry not found.");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	
	}
	
	
	/**
	 * Deletion of an extant Arabica sampling
	 * @param _id
	 * @return
	 */
	@RequestMapping(value = "/deleteArabicaSample/{_id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteArabicaSample(@PathVariable String _id) {
		LOG.info("Checking to see if ID is present...");
		try {
			coffeeService.deleteArabicaSample(_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				LOG.info("ID was not present.");
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	/**
	 * Deletion of an extant Robusta sampling
	 * @param _id
	 * @return
	 */
	@RequestMapping(value = "/deleteRobustaSample/{_id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteRobustaSample(@PathVariable String _id) {
		LOG.info("Checking to see if ID is present...");
		try {
			coffeeService.deleteRobustaSample(_id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				LOG.info("ID was not present.");
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	
	/**
	 * Simple ping
	 * @return
	 */
	@GetMapping("/ping")
	public String index() {
		return "pong";
	}
}
