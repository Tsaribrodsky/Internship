package com.amdocs.calculator.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;


public class Validation {
	
	private static Logger logger = Logger.getLogger(Validation.class);
	
	public boolean isValid(String value) {

		if (value == null) {
			logger.warn("No parameter entered");
			return false;
		} else if (value.equals("")) {
			logger.warn("No value entered");
			return false;
		}
		return true;
	}

	public boolean isNumber(String value) {

		String regex = "^[-]?[0-9]{1,9}+[.]?[0-9]{0,2}$";
		Pattern p = Pattern.compile(regex);
		Matcher match = p.matcher(value);

		if (match.matches()) {
			return true;
		}
		logger.warn("No number entered");
		return false;
	}
}
