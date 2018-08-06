package meals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.gft.test.meals.service.ValidateInputService;
import com.gft.test.meals.service.impl.ValidateInputServiceImpl;

public class TestValidateService {

	ValidateInputService validateInputService = new ValidateInputServiceImpl();

	@Test
	public final void testValidateMorning() {
		String[] args = {"morning,1,3"};
		boolean isValid = validateInputService.validate(args);
		assertTrue(isValid);
	}
	@Test
	public final void testNotValidateMorning() {
		String[] args = {"morni,1,3"};
		boolean isValid = validateInputService.validate(args);
		assertFalse(isValid);
	}
	@Test
	public final void testValidateNight() {
		String[] args = {"night,1,3"};
		boolean isValid = validateInputService.validate(args);
		assertTrue(isValid);
	}
	@Test
	public final void testNotValidateNight() {
		String[] args = {"nigh,1,3"};
		boolean isValid = validateInputService.validate(args);
		assertFalse(isValid);
	}
	@Test
	public final void testValidateInputFormat() {
		String[] args = {"night 1 3"};
		boolean isValid = validateInputService.validate(args);
		assertFalse(isValid);
	}
}
