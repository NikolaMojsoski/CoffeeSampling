package com.coffee.pot.assignment.repository.robusta;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.stereotype.Service;

import com.coffee.pot.assignment.domain.Robusta;

@Service
public class RobustaOperations { 

	@Autowired
	public MongoTemplate mongoTemplate;
	
	public List<Robusta> getRandomResults(Integer size){
		AggregationOperation sample = Aggregation.sample(size);
		
		List<AggregationOperation> arabicaAggregation = 
			new ArrayList<AggregationOperation>();
		
		arabicaAggregation.add(sample);
		
		List<Robusta> sampleRobusta = 
				mongoTemplate.
				aggregate(Aggregation.
				newAggregation(arabicaAggregation),
				"Robusta",
				Robusta.class).
				getMappedResults();
		
		return sampleRobusta;
	}

}
