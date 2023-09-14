package com.customeValidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.Past;

@Documented
@Constraint(validatedBy = PastOrEqualValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Past(message = "DOB must be in the past")
@ReportAsSingleViolation
public @interface PastDate {
	String message() default "DOB must be before 01-01-2002";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
	
}
