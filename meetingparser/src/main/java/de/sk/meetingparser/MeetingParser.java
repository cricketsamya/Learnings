package de.sk.meetingparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import de.sk.meetingparser.data.MeetingData;

/**
 * The main class responsible for parsing the bookings text file to generate
 * required output.
 * 
 * @author Sameer Kulkarni
 *
 */
public class MeetingParser {

	// TODO : Logging should be used instead of System println statements
	private static final String ZEROTH_HOUR = " 00:00:00";
	private static final DateFormat FULL_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
	private static final DateTimeFormatter GERMAN_FORMAT = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
			.withLocale(Locale.GERMAN);
	private static final DateTimeFormatter HOUR_MIN_FORMAT = DateTimeFormatter.ofPattern("HHmm");
	private List<MeetingData> cancelledMeetings = new ArrayList<MeetingData>();

	public static void main(String args[]) throws FileNotFoundException, IOException, ParseException {
		MeetingParser mp = new MeetingParser();
		if (args[0] != null && !args[0].isEmpty()) {
			Map<Date, List<MeetingData>> calender = mp.parse(args[0]);
			mp.prettyPrint(calender);
		} else {
			System.out.println("Input file is missing! Please enter the parameter");
		}
	}

	/**
	 * Method is to find the overlapped times for the meeting, if there is a
	 * overlap the older entry is removed from the calendar
	 * 
	 * @param meetingStartTime
	 *            meeting starting time
	 * @param meetingEndTime
	 *            meeting end time
	 * @param list
	 *            list of meetings in given day
	 */
	private void removeOverlapTimes(LocalTime meetingStartTime, LocalTime meetingEndTime, List<MeetingData> list) {
		ListIterator<MeetingData> litr = list.listIterator();
		while (litr.hasNext()) {
			MeetingData meetingData = litr.next();
			if ((meetingStartTime.equals(meetingData.getStartTime())
					&& meetingEndTime.equals(meetingData.getEndTime()))) {
				// TODO : User should be informed about the cancelled meetings.
				cancelledMeetings.add(meetingData);
				litr.remove();
			} else if ((meetingStartTime.isAfter(meetingData.getStartTime())
					&& meetingStartTime.isBefore(meetingData.getEndTime()))
					|| (meetingEndTime.isAfter(meetingData.getStartTime())
							&& meetingEndTime.isBefore(meetingData.getEndTime()))) {
				cancelledMeetings.add(meetingData);
				litr.remove();
			}
		}
	}

	/**
	 * The method is to print the calendar in required format
	 * 
	 * @param calender
	 *            parse calendar
	 */
	public void prettyPrint(Map<Date, List<MeetingData>> calender) {
		Set<Date> dates = calender.keySet();
		DateFormat formatMeetingDate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		for (Date date : dates) {
			List<MeetingData> list = calender.get(date);
			System.out.println(formatMeetingDate.format(date));
			for (MeetingData meetingData : list) {
				System.out.println(GERMAN_FORMAT.format(meetingData.getStartTime()) + " "
						+ GERMAN_FORMAT.format(meetingData.getEndTime()) + " " + meetingData.getEmployeeId());
			}
		}
	}

	/**
	 * The main method which parses the text file and generates a Map of dates
	 * as Calendar.
	 * 
	 * @param filePath
	 *            input file path
	 * @return parse calendar
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public Map<Date, List<MeetingData>> parse(String filePath)
			throws FileNotFoundException, IOException, ParseException {
		Map<Date, List<MeetingData>> calender = new TreeMap<Date, List<MeetingData>>();
		LocalTime startTime = null;
		LocalTime endTime = null;
		File file = new File(filePath);
		int linecount = 1;
		MeetingData md = null;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = br.readLine()) != null) {
				if (linecount == 1) {
					// This is to read the first line in the file to get the
					// office hours
					String[] officeTimes = line.split(" ");
					startTime = LocalTime.parse(officeTimes[0], HOUR_MIN_FORMAT);
					endTime = LocalTime.parse(officeTimes[1], HOUR_MIN_FORMAT);
				} else if (linecount % 2 == 0) {
					// This is where first line from the employee entry is
					// parsed and a POJO for the meeting is created
					md = parseEmployeeEntry(line);
				} else if (linecount % 2 == 1) {
					// The same POJO is updated with the meeting details
					String[] meetingTimes = line.split(" ");
					Date meetingDate = FULL_FORMAT.parse(meetingTimes[0] + ZEROTH_HOUR);
					LocalTime meetingStartTime = LocalTime.parse(meetingTimes[1], GERMAN_FORMAT);
					int duration = Integer.parseInt(meetingTimes[2]);
					LocalTime meetingEndTime = LocalTime.parse(meetingTimes[1], GERMAN_FORMAT).plus(duration,
							ChronoUnit.HOURS);
					md.setStartTime(meetingStartTime);
					md.setEndTime(meetingEndTime);
					List<MeetingData> list = calender.get(meetingDate);
					if (isMeetingDuringOfficeHours(startTime, endTime, meetingStartTime, meetingEndTime)) {
						if (list == null) {
							list = new LinkedList<MeetingData>();
							calender.put(meetingDate, list);
						}
						removeOverlapTimes(meetingStartTime, meetingEndTime, list);
						list.add(md);
					}
				}
				linecount++;
			}
		}
		return calender;
	}

	/**
	 * Method checks if the meeting is scheduled during office hours.
	 * 
	 * @param startTime
	 *            office start time
	 * @param endTime
	 *            office end time
	 * @param meetingStartTime
	 *            meeting start time
	 * @param meetingEndTime
	 *            meeting end time
	 * @return true if meeting is scheduled during office hours, false
	 *         otherwise.
	 */
	private boolean isMeetingDuringOfficeHours(LocalTime startTime, LocalTime endTime, LocalTime meetingStartTime,
			LocalTime meetingEndTime) {
		return !meetingStartTime.isAfter(endTime) && !meetingStartTime.isBefore(startTime)
				&& !meetingEndTime.isAfter(endTime) && !meetingEndTime.isBefore(startTime);
	}

	/**
	 * Method which parses employee information in the booking
	 * 
	 * @param line
	 *            input
	 * @return meeting data object
	 * @throws ParseException
	 */
	private MeetingData parseEmployeeEntry(String line) throws ParseException {
		MeetingData md;
		String[] creationInfo = line.split(" ");
		Date date = FULL_FORMAT.parse(creationInfo[0] + " " + creationInfo[1]);
		md = new MeetingData();
		md.setCreationDate(date);
		md.setEmployeeId(creationInfo[2]);
		return md;
	}
}
