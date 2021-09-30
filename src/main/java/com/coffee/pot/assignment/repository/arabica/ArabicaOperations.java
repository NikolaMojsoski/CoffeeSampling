package com.coffee.pot.assignment.repository.arabica;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.stereotype.Service;

import com.coffee.pot.assignment.domain.Arabica;

@Service
public class ArabicaOperations { 

	@Autowired
	public MongoTemplate mongoTemplate;
	
	public List<Arabica> getRandomResults(Integer size){
		AggregationOperation sample = Aggregation.sample(size);
	
		List<AggregationOperation> arabicaAggregation = 
				new ArrayList<AggregationOperation>();
		arabicaAggregation.add(sample);
		
		List<Arabica> sampleArabica = 
				mongoTemplate.
				aggregate(Aggregation.newAggregation(arabicaAggregation),
				"Arabica",
				Arabica.class).getMappedResults();
		
		return sampleArabica;
	}

}
