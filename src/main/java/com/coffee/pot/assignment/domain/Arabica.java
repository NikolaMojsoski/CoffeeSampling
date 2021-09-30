package com.coffee.pot.assignment.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.ToString;

@Data
@Document(collection = "Arabica")
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Arabica {
	@Id //1
	private String _id;
	@Field //2
	private Integer coffeeIndex;
	@Field //3
	private String species;
	@Field //4
	private String owner;
	@Field //5
	private String countryOfOrigin;
	@Field //6
	private String farmName;
	@Field //7
	private String mill;
	@Field //8 
	private String icoNumber;
	@Field //9 
	private String company;
	@Field //10
	private String altitude;
	@Field //11
	private String region;
	@Field //12
	private String producer;
	@Field //13
	private Integer numberOfBags;
	@Field //14
	private String bagWeight;
	@Field //15
	private String inCountryPartner;
	@Field //16
	private String harvestYear;
	@Field //17
	private String gradingDate;
	@Field //18
	private String processingMethod;
	@Field //19
	private Double aroma;
	@Field //20
	private Double flavor;
	@Field //21
	private Double aftertaste; 
	@Field //22
	private Double acidity; 
	@Field //23
	private Double body;
	@Field //24
	private Double balance;
	@Field //25
	private Double uniformity;
	@Field //26
	private Double cleanCup;
	@Field //27
	private Double sweetness;
	@Field //28
	private Double cupperPoints;
	@Field //29 
	private Double totalCupPoints;
	@Field //30
	private Double moisture;
	@Field //31
	private Integer categoryOneDefects;
	@Field //32
	private Integer quakers;
	@Field //33
	private String color;
	@Field //34
	private Integer categoryTwoDefects;
	@Field //35
	private String expiration;
	@Field //36
	private String certificationBody;
	@Field //37
	private String certificationAddress;
	@Field //38
	private String certificationContact;
	@Field //39
	private String unitOfMeasurement;
	@Field //40
	private String altitudeLowMeters;
	@Field //41
	private String altitudeHighMeters;
	@Field //42
	private String altitudeMeanMeters;
}
