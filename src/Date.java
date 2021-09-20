package project1;

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date>{
	private int year;
	private int month;
	private int day;
	
	public Date(String date) {
		StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
	}
	
	public Date() {
		Calendar rightNow = Calendar.getInstance();
        month = rightNow.get(Calendar.MONTH) + 1;
        day = rightNow.get(Calendar.DAY_OF_MONTH);
        year = rightNow.get(Calendar.YEAR);
	}
	
	public Date(Date date) {
		month = date.getMonth();
		day = date.getDay();
		year = date.getYear();
	}

	@Override
	public int compareTo(Date date) {			// pretty sure this doesn't work, needs to be checked
		// TODO Auto-generated method stub
		if (date.year < this.year) {
			return -1;
		} else {
			if (date.year == this.year) {
				if (date.month < this.month) {
					return -1;
				} else {
					if (date.month == this.month) {
						if (date.day < this.day) {
							return -1;
						} else {
							return 1;
						}
					} else {
						return 1;
					}
				}
			} else {
				return 1;
			}
		}
	}
	
	public Date today() {
		return new Date();
	}
	
	public boolean isValid() {
		Calendar albumDate = Calendar.getInstance();
		albumDate.set(year, month-1, day);
		Calendar currentDate = Calendar.getInstance();
		if (albumDate.after(currentDate) || year < 1980)
			return false;
		albumDate.setLenient(false);
		try {									// NOTE: THIS WORKS BUT IT THIS IS BAD CODE!!! FIX IT TO MATCH THE DOCUMENT WHEN COMPLETE
			albumDate.getTime();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return month + "/" + day + "/" + year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public boolean equals(Object obj) {
		return false;
	}
	
	public static void main(String[] args) {
		Date date = new Date("11/30/1991");
		System.out.println(date.isValid());
		System.out.println(new Date(date));
		 
	}
}
