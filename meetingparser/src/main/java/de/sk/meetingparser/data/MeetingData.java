package de.sk.meetingparser.data;

import java.time.LocalTime;
import java.util.Date;

/**
 * Meeting data POJO
 * 
 * @author Sameer Kulkarni
 *
 */
public class MeetingData {

	private String employeeId;
	private LocalTime startTime;
	private LocalTime endTime;
	private Date creationDate;

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingData other = (MeetingData) obj;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}

}
