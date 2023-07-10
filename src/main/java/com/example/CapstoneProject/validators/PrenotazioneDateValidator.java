//package com.example.CapstoneProject.validators;
//
//import java.time.LocalDate;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//
//public class PrenotazioneDateValidator implements ConstraintValidator<PrenotazioneDateConstraint, LocalDate> {
//
//	public void initialize(PrenotazioneDateValidator prenotazioneDate) {
//	}
//
//	@Override
//	public boolean isValid(LocalDate prenotazioneDate, ConstraintValidatorContext cxt) {
//		LocalDate validDate = LocalDate.now().plusDays(2);
//		return prenotazioneDate.isAfter(validDate) || prenotazioneDate.isEqual(validDate);
//	}
//}
