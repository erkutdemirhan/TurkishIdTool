package turkishidtool.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import turkishidtool.exception.InvalidInputException;
import turkishidtool.model.TurkishIdImplementation;
import turkishidtool.resources.Strings;

/**
 * @author Erkut Demirhan
 * @date Feb 21, 2016
 *
 */
public class ValidTurkishIdTest {

	private TurkishIdImplementation mTurkishID;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		// This method is called before calling each test method
		mTurkishID = new TurkishIdImplementation();
	}
	
	@After
	public void tearDown() {
		// This method is called after calling each test method
	}
	
	@Test
	public void TestNullIdInput() throws InvalidInputException {
		thrown.expect(InvalidInputException.class);
		thrown.expectMessage(Strings.WARNING_MSG_INVALID_ID.toString());
		mTurkishID.isValidID("");
	}
	
	@Test
	public void TestNonNumericIdInput() throws InvalidInputException {
		thrown.expect(InvalidInputException.class);
		thrown.expectMessage(Strings.WARNING_MSG_INVALID_ID.toString());
		mTurkishID.isValidID("213063201A6");
	}
	
	@Test
	public void TestNumericIdLessThanElevenDigits() throws InvalidInputException {
		thrown.expect(InvalidInputException.class);
		thrown.expectMessage(Strings.WARNING_MSG_INVALID_ID.toString());
		mTurkishID.isValidID("123456");
	}
	
	@Test
	public void TestNumericIdMoreThanElevenDigits() throws InvalidInputException {
		thrown.expect(InvalidInputException.class);
		thrown.expectMessage(Strings.WARNING_MSG_INVALID_ID.toString());
		mTurkishID.isValidID("1234567891011");
	}
	
	@Test
	public void TestElevenDigitsNonTurkishIdInput() throws InvalidInputException {
		assertThat(mTurkishID.isValidID("10000000147"), is(false));
		assertThat(mTurkishID.isValidID("00000000000"), is(false));
		assertThat(mTurkishID.isValidID("99999999999"), is(false));
	}
	
	@Test
	public void TestElevenDigitsTurkishIdInput() throws InvalidInputException {
		assertThat(mTurkishID.isValidID("10000000146"), is(true));
	}
}
