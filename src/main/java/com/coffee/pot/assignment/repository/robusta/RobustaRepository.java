package com.coffee.pot.assignment.repository.robusta;


import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import org.springframework.stereotype.Repository;

import com.coffee.pot.assignment.domain.Robusta;

@EnableMongoRepositories(basePackages = "com.coffee.pot.assignment.repository.robusta")
@Repository
public interface RobustaRepository extends MongoRepository<Robusta, String> {
	public ArrayList<Robusta>getRobustaBy_id(String _id);
}