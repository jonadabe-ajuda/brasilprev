package br.com.brasilprev.domain.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Value Object from CPF 
 *  
 * @author jonadabe
 * @param  Constructor all fields
 */
public class CPF {
	
	@NotNull
	@NotEmpty
	@Size(min = 11,max = 11,message = "CPF field number equal 11")
	private String number;

	public CPF(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}
		

}
