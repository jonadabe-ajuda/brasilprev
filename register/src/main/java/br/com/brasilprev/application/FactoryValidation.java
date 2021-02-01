package br.com.brasilprev.application;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

public class FactoryValidation {
	
	private Validator validator;
	
	public FactoryValidation buildValidation() {
		 this.validator = Validation.byDefaultProvider()
				    .configure()
				    .messageInterpolator(new ParameterMessageInterpolator())
				    .buildValidatorFactory()
				    .getValidator();
		 return this;
	}
	
	public Validator create () {
		return this.validator;
	}

}