package turkishidtool.model;

import java.util.Random;

import turkishidtool.exception.InvalidInputException;
import turkishidtool.resources.Strings;

/**
 * @author Erkut Demirhan
 * @date Feb 21, 2016
 *
 */
public class TurkishIdImplementation implements TurkishIdToolInterface {

	@Override
	public boolean isValidID(String id) throws InvalidInputException {
		if(id == null || !isElevenDigitNumeric(id)) {
			throw new InvalidInputException(Strings.WARNING_MSG_INVALID_ID.toString());
		};
		int [] turkishIdArray = strToIntArray(id);		
		int [] checkDigits    = findCheckDigits(turkishIdArray);
		return turkishIdArray[0]  != 0 &&
			   turkishIdArray[9]  == checkDigits[0] &&
			   turkishIdArray[10] == checkDigits[1];
	}

	@Override
	public String generateID() {
		int[] turkishIdArray = new int[11];
		Random random        = new Random();
		turkishIdArray[0]    = random.nextInt(9) + 1;
		for(int i=1; i<9; i++) {
			turkishIdArray[i] = random.nextInt(10);
		}
		int[] checkDigits  = findCheckDigits(turkishIdArray);
		turkishIdArray[9]  = checkDigits[0];
		turkishIdArray[10] = checkDigits[1];
		StringBuilder sb   = new StringBuilder();
		for(int digit:turkishIdArray) {
			sb.append(digit);
		}
		return sb.toString();
	}
	
	private int[] findCheckDigits(int[] turkishIdArray) {
		int[] checkDigits = new int[2];
		int evenSum = 0;
		int oddSum  = 0;
		for(int i=0; i<9; i++) {
			if(i%2 == 0) {
				oddSum  += turkishIdArray[i];
			} else {
				evenSum += turkishIdArray[i];
			}
		}
		checkDigits[0] = (oddSum*7 - evenSum) % 10;
		checkDigits[1] = (oddSum   + evenSum + checkDigits[0]) % 10;		
		return checkDigits;
	}
	
	private boolean isElevenDigitNumeric(String str) {
		return str.matches("\\d{11}");
	}
	
	private int[] strToIntArray(String numStr) {
		int[] array = new int[numStr.length()];
		for(int i=0; i<numStr.length(); i++) {
			array[i] = numStr.charAt(i) - '0';
		}		
		return array;
	}
}
