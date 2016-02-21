package turkishidtool.resources;

/**
 * @author Erkut Demirhan
 * @date Feb 21, 2016
 *
 */
public enum Strings {
	
	APPLICATION_NAME("Turkish ID Tool"),
	BTN_GENERATE_ID("Generate ID"),
	BTN_VERIFY_ID("Verify ID"),
	GENERATE_DIALOG_HEADER("Randomly Generated Turkish ID"),
	INFO("This program verifies and generates\r\nTurkish Citizenship ID using the algorithm\r\nspecified in the following link:\r\n\r\nhttps://en.wikipedia.org/wiki/Turkish_Identification_Number"),
	INPUT_ID_LABEL("Enter ID: "),
	MSG_NON_TURKISH_ID("This is an invalid Turkish ID!"),
	MSG_TURKISH_ID("This is a valid Turkish ID!"),
	TABNAME_ABOUT("About"),
	TABNAME_VERIFY_ID("Verify Turkish ID"),
	TABNAME_GENERATE_ID("Generate Turkish ID"),
	VERIFICATION_DIALOG_HEADER("Turkish ID Verification"),
	WARNING_MSG_INVALID_ID("This is an invalid input! Please enter 11 digits.");
	
	private final String mString;
	
	private Strings(final String str) {
		mString = str;
	}
	
	@Override
	public String toString() {
		return mString;
	}

}
