package com.customeValidation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PastOrEqualValidator implements ConstraintValidator<PastDate, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
            return true; // Empty values are considered valid; handle as needed
        }

        try {
            LocalDate dob = LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate limitDate = LocalDate.of(2002, 1, 1);
            return dob.isBefore(limitDate);
        } catch (Exception e) {
            return false; // Invalid date format; handle as needed
        }	}

}
