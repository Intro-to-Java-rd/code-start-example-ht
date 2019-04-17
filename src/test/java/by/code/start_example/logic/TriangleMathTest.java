package by.code.start_example.logic;

import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TriangleMathTest {

	private int x;
	private int y;
	private int z;
	private boolean expected;

	private static TriangleMath triangleMath;

	public TriangleMathTest(int x, int y, int z, boolean expected) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.expected = expected;
	}

	@Parameters
	public static Collection<Object[]> powTableValues() {
		return Arrays
				.asList(new Object[][] { 
					{ 100, 100, 100, true }, 
					{ 200, 100, 100, false }, 
					{ 300, 400, 500, false },

					{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true }, 
					{ 1, 1, 1, true },
					{ 0, 0, 0, false }, 
					{ -1, -1, -1, false },
					{ Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, false },

					{ -200, -200, -200, false }, 
					{ -200, -400, -500, false },

					{ 2, 2, -2, false }, 
					{ 6, -8, -10, false }

				});
	}

	@BeforeClass
	public static void createTriangleMath() {
		triangleMath = new TriangleMath();
	}
	
	@AfterClass
	public static void releaseTriangleMath() {
		triangleMath = null;
	}

	@Test
	public void testIsEquilateral() {
		boolean real;

		real = triangleMath.isEquilateral(x, y, z);

		Assert.assertEquals(real, expected);
	}
}
