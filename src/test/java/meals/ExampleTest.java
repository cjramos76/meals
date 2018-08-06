package meals;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gft.test.meals.controller.MealController;
import com.gft.test.meals.controller.impl.MealControllerImpl;

public class ExampleTest {

	MealController mealController = new MealControllerImpl();
	
	@Test
	public final void mierda() {
		String a="hola";
		String b="hola";
		assertEquals(a,b);
	}
	@Test
	public final void test11() {
		String response = mealController.orderFood(new String[] {"morning,1,2,3"});
		assertEquals("eggs,toast,coffee",response);
	}
	@Test
	public final void test12() {
		String response = mealController.orderFood(new String[] {"morning,2,1,3"});
		assertEquals("eggs,toast,coffee",response);
	}
	@Test
	public final void test13() {
		String response = mealController.orderFood(new String[] {"morning,1,2,3,4"});
		assertEquals("eggs,toast,coffee,error",response);
	}
	@Test
	public final void test14() {
		String response = mealController.orderFood(new String[] {"morning,1,2,3,3,3"});
		assertEquals("eggs,toast,coffee,coffee,coffee",response);
	}
	@Test
	public final void test15() {
		String response = mealController.orderFood(new String[] {"night,1,2,3,4"});
		assertEquals("steak,potato,wine,cake",response);
	}
	@Test
	public final void test16() {
		String response = mealController.orderFood(new String[] {"night,1,2,2,4"});
		assertEquals("steak,potato,potato,cake",response);
	}
}
