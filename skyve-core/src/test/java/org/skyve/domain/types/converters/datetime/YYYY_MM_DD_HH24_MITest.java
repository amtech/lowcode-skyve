package org.skyve.domain.types.converters.datetime;

import org.junit.Assert;
import org.junit.Test;
import org.skyve.domain.messages.ConversionException;
import org.skyve.domain.types.DateTime;
import org.skyve.util.Time;

public class YYYY_MM_DD_HH24_MITest {
	private YYYY_MM_DD_HH24_MI converter = new YYYY_MM_DD_HH24_MI();

	@Test(expected = ConversionException.class)
	public void testFromDisplayValueInvalidFormat() throws Exception {
		// call the method under test
		converter.fromDisplayValue("01-03-2020 02:30");

		Assert.fail("ConversionException should be thrown");
	}

	@Test
	public void testFromDisplayValueAM() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));
		Time.setTime(testDate, 02, 30, 0);

		// call the method under test
		Assert.assertEquals(testDate, converter.fromDisplayValue("2020/03/01 02:30"));
	}

	@Test
	public void testFromDisplayValuePM() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));
		Time.setTime(testDate, 14, 30, 0);

		// call the method under test
		Assert.assertEquals(testDate, converter.fromDisplayValue("2020/03/01 14:30"));
	}

	@Test
	public void testToDisplayValueAM() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));
		Time.setTime(testDate, 02, 30, 0);

		// call the method under test
		Assert.assertEquals("2020/03/01 02:30", converter.toDisplayValue(testDate));
	}

	@Test
	public void testToDisplayValuePM() throws Exception {
		// setup the test data
		DateTime testDate = new DateTime(Time.withDate(01, 03, 2020));
		Time.setTime(testDate, 14, 30, 0);

		// call the method under test
		Assert.assertEquals("2020/03/01 14:30", converter.toDisplayValue(testDate));
	}
}
