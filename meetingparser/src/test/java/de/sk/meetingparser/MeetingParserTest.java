/**
 * 
 */
package de.sk.meetingparser;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import de.sk.meetingparser.data.MeetingData;

/**
 * Test class for MeetingParser class
 * 
 * @author Sameer Kulkarni
 *
 */
public class MeetingParserTest {
	private MeetingParser mp = null;

	@Before
	public void setup() {
		mp = new MeetingParser();
	}

	@Test

	public void testPrettyPrint() throws FileNotFoundException, IOException, ParseException {
		Map<Date, List<MeetingData>> calender = mp.parse("src/test/resources/input.txt");
		mp.prettyPrint(calender);
	}

	@Test
	public void testParseNormal() throws FileNotFoundException, IOException, ParseException {
		Map<Date, List<MeetingData>> calender = mp.parse("src/test/resources/input.txt");
		assertEquals(2, calender.size());
	}

	@Test
	public void testParseNormalEntries() throws FileNotFoundException, IOException, ParseException {
		Map<Date, List<MeetingData>> calender = mp.parse("src/test/resources/input.txt");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<MeetingData> list = calender.get(formatter.parse("2015-08-21"));
		assertEquals(1, list.size());
	}

	@Test(expected = DateTimeParseException.class)
	public void testParseException() throws FileNotFoundException, IOException, ParseException {
		mp.parse("src/test/resources/inputError.txt");
	}

	@Test
	public void testParseAbnormal() throws FileNotFoundException, IOException, ParseException {
		Map<Date, List<MeetingData>> calender = mp.parse("src/test/resources/inputabnormal.txt");
		assertEquals(0, calender.size());
	}

	@Test(expected = FileNotFoundException.class)
	public void testParseFileNotFound() throws FileNotFoundException, IOException, ParseException {
		mp.parse("src/test/resources/etc.txt");
	}

	@Test
	public void testParseNormalOverlapped() throws FileNotFoundException, IOException, ParseException {
		Map<Date, List<MeetingData>> calender = mp.parse("src/test/resources/inputoverlapped.txt");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<MeetingData> list = calender.get(formatter.parse("2015-08-21"));
		assertEquals(1, list.size());
		assertEquals("EMP006", list.get(0).getEmployeeId());
	}

	@Test
	public void testParseNormalDuplicateBigFile() throws FileNotFoundException, IOException, ParseException {
		Map<Date, List<MeetingData>> calender = mp.parse("src/test/resources/inputbig.txt");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		List<MeetingData> list = calender.get(formatter.parse("2015-08-21"));
		assertEquals(1, list.size());
	}

	@Test
	public void testEmptyInputFile() throws FileNotFoundException, IOException, ParseException {
		mp.parse("src/test/resources/inputempty.txt");
	}

	public void testInvalidInputFile() throws FileNotFoundException, IOException, ParseException {
		mp.parse("src/test/resources/inputinvalid.txt");
	}
}
