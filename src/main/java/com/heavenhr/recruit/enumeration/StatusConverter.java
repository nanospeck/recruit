package com.heavenhr.recruit.enumeration;

import javax.persistence.AttributeConverter;

public class StatusConverter implements AttributeConverter<ApplicationStatus, String> {

	@Override
	public String convertToDatabaseColumn(ApplicationStatus attribute) {
		switch (attribute) {
		case APPLIED:
			return "A";
		case INVITED:
			return "I";
		case REJECTED:
			return "R";
		case HIRED:
			return "H";
		default:
			throw new IllegalArgumentException("Unknown" + attribute);
		}
	}

	@Override
	public ApplicationStatus convertToEntityAttribute(String dbData) {
		switch (dbData) {
		case "A":
			return ApplicationStatus.APPLIED;
		case "I":
			return ApplicationStatus.INVITED;
		case "R":
			return ApplicationStatus.REJECTED;
		case "H":
			return ApplicationStatus.HIRED;
		default:
			throw new IllegalArgumentException("Unknown" + dbData);
		}
	}
}