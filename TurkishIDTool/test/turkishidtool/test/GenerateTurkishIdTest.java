package turkishidtool.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import turkishidtool.exception.InvalidInputException;
import turkishidtool.model.TurkishIdImplementation;

/**
 * @author Erkut Demirhan
 * @date Feb 21, 2016
 *
 */
public class GenerateTurkishIdTest {

	private TurkishIdImplementation mTurkishIdImplementation;
	
	@Before
	public void setUp() throws Exception {
		mTurkishIdImplementation = new TurkishIdImplementation();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void TestGeneratedIdsAreValid() throws InvalidInputException {
		int loop       = 1000;
		boolean result = true;
		for(int i=0; i<loop; i++) {
			String id = mTurkishIdImplementation.generateID();
			if(!mTurkishIdImplementation.isValidID(id)) {
				result = false;
				break;
			}
		}
		assertThat(result, is(true));
	}

}
