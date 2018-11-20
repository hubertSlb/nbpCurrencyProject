package pl.dashboard.nbp.validators;

import pl.dashboard.nbp.interfaces.IArgsValidator;

public class ArgsValidator implements IArgsValidator {
	
	private String[] input;
	
	public ArgsValidator(String[] input) {
		this.input = input;
	}
	
	@Override
	public String inputValid() {
		if (input == null || input.length != 1)
			throw new IllegalArgumentException("Incorrect input parameters");
		
		return input[0];
	}

}
