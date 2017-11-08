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

public class MeetingParser {

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
		}
	}

	private void removeOverlapTimes(LocalTime meetingStartTime, LocalTime meetingEndTime, List<MeetingData> list) {
		ListIterator<MeetingData> litr = list.listIterator();
		while (litr.hasNext()) {
			MeetingData meetingData = litr.next();
			if ((meetingStartTime.equals(meetingData.getStartTime())
					&& meetingEndTime.equals(meetingData.getEndTime()))) {
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
					String[] officeTimes = line.split(" ");
					startTime = LocalTime.parse(officeTimes[0], HOUR_MIN_FORMAT);
					endTime = LocalTime.parse(officeTimes[1], HOUR_MIN_FORMAT);
				} else if (linecount % 2 == 0) {
					md = parseEmployeeEntry(line);
				} else if (linecount % 2 == 1) {
					String[] meetingTimes = line.split(" ");
					Date meetingDate = FULL_FORMAT.parse(meetingTimes[0] + ZEROTH_HOUR);
					LocalTime meetingStartTime = LocalTime.parse(meetingTimes[1], GERMAN_FORMAT);
					int duration = Integer.parseInt(meetingTimes[2]);
					LocalTime meetingEndTime = LocalTime.parse(meetingTimes[1], GERMAN_FORMAT).plus(duration,
							ChronoUnit.HOURS);
					md.setStartTime(meetingStartTime);
					md.setEndTime(meetingEndTime);
					List<MeetingData> list = calender.get(meetingDate);

					if (!meetingStartTime.isAfter(endTime) && !meetingStartTime.isBefore(startTime)
							&& !meetingEndTime.isAfter(endTime) && !meetingEndTime.isBefore(startTime)) {
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
