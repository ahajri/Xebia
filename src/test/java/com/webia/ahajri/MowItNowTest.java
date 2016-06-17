package com.webia.ahajri;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.xebia.ahajri.MowItNow;
import com.xebia.ahajri.Position;
import com.xebia.ahajri.exception.MowException;

public class MowItNowTest {

	static MowItNow mowItNow;

	@BeforeClass
	public static void setUp() {
		System.out.println("Begin tests ...");
		mowItNow = new MowItNow();
	}

	@Test
	public void testFirstMower() {
		// Given
		String xyMax = "5 5";
		String startPosition = "1 2 N";
		String commandLine = "GAGAGAGAA";

		// When
		Position endPosition = null;
		try {
			endPosition = mowItNow.mow(xyMax, startPosition, commandLine);
		} catch (MowException e) {
			Assert.fail(e.getMessage());
		}

		// Then
		Assert.assertEquals(endPosition.getX(), 1);
		Assert.assertEquals(endPosition.getY(), 3);
		Assert.assertEquals(endPosition.getCap(), "N");
	}

	@Test
	public void testSecondMower() {
		// Given
		String xyMax = "5 5";
		String startPosition = "3 3 E";
		String commandLine = "AADAADADDA";

		// When
		Position endPosition = null;
		try {
			endPosition = mowItNow.mow(xyMax, startPosition, commandLine);
		} catch (MowException e) {
			Assert.fail(e.getMessage());
		}

		// Then
		Assert.assertEquals(endPosition.getX(), 5);
		Assert.assertEquals(endPosition.getY(), 1);
		Assert.assertEquals(endPosition.getCap(), "E");
	}

	@Test(expected = NumberFormatException.class)
	public void testWhenBadMaxPositionFormatExceptionIsThrown() throws MowException {
		// Given
		String xyMax = "5    5";
		String startPosition = "3 3 E";
		String commandLine = "AADAADADDA";

		// When
		Position endPosition = mowItNow.mow(xyMax, startPosition, commandLine);

		// Then NumberFormatException thrown
	}

	@Test(expected = NullPointerException.class)
	public void testWhenNullMaxPositionNullPointerExceptionIsThrown() throws MowException {
		// Given
		String xyMax = null;
		String startPosition = "3 3 E";
		String commandLine = "AADAADADDA";

		// When
		Position endPosition = mowItNow.mow(xyMax, startPosition, commandLine);

		// Then NullPointerException Thrown

	}

	@AfterClass
	public static void tearDown() {
		System.out.println("End tests ...");
		mowItNow = null;
	}

}
