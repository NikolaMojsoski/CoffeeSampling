package com.coffee.pot.assignment.repository.arabica;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.coffee.pot.assignment.domain.Arabica;

@EnableMongoRepositories(basePackages = "com.coffee.pot.assignment.repository.arabica")
@Repository
public interface ArabicaRepository extends MongoRepository<Arabica, String> {
	public ArrayList<Arabica>getArabicaBy_id(String _id);
}