package turkishidtool.model;

import turkishidtool.exception.InvalidInputException;

/**
 * @author Erkut Demirhan
 * @date Feb 21, 2016
 *
 */
public interface TurkishIdToolInterface {

	public boolean isValidID(String id) throws InvalidInputException;
	public String generateID();
	
}
