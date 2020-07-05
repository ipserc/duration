/**
 * 
 */
package com.ipserc.duration;

/**
 * @author ipserc
 * @date 2020/07/05
 * @version 1.0 (2020_0705_1320)
 * <p>
 * created:2020/07/05
 * <p>
 * github:https://github.com/ipserc
 * <p>
 * license:MIT
 * <p>
 * 
 */
public class duration {
	/*
	 * CONSTANTS
	 */
	final private int T_MILLISECS = 1;
	final private int T_SECS = 2;
	final private int T_MINS = 3;
	final private int T_HOURS = 4;
	final private int T_DAYS = 5;

	/*
	 * MEMEBERS VARIABLES
	 */
	private long duration = 0l;
	private int ms = 0, s = 0, m = 0, h = 0; 
	private long d = 0l;
	private double dec = 0.0;
	private double time = 0.0;
	private String strTimeUnit;
	private int t_timeUnit;
	private String strDuration;
	
	/*
	 * CONSTRUCTOR
	 */
	/**
	 * Class constructor
	 * @param duration The duration time expressed in 'strTimeUnit'
	 * @param strTimeUnit The duration units in String format. It can be 'ms' for milliseconds, 's' for seconds, 'm' for minutes, 'h' for hours, 'd' for days.
	 */
	public duration(long duration, String strTimeUnit) {
		this.strTimeUnit = strTimeUnit;
		this.t_timeUnit = tTimeUnit(strTimeUnit);
		this.set(duration);
		//this.duration = duration;
		//time = (double)duration;
		//this.eval();
	}

	/*
	 * PRIVATE METHODS
	 */
	/**
	 * Returns the type of the time unit.
	 * @param strTimeUnit The duration units in String format.
	 * @return the type of the time unit.
	 */
	private int tTimeUnit(String strTimeUnit) {
		if (strTimeUnit.equalsIgnoreCase("ms")) return T_MILLISECS;
		if (strTimeUnit.equalsIgnoreCase("s")) return T_SECS;
		if (strTimeUnit.equalsIgnoreCase("m")) return T_MINS;
		if (strTimeUnit.equalsIgnoreCase("h")) return T_HOURS;
		if (strTimeUnit.equalsIgnoreCase("d")) return T_DAYS;
		return 0;
	}
	
	/**
	 * Updates the calculation values used to to extract the time values
	 * @param timeUnit The value to extract the units of time
	 * @return The next time value to use in the calculations
	 */
	private int getVal(int timeUnit) {
		time = (time / (double)timeUnit);
		dec = time % 1;
		time = time - dec;
		return (int)(dec * timeUnit);		
	}
	
	/**
	 * Evaluates the introduced duration, in the given time units
	 */
	private void eval() {
		switch (t_timeUnit) {
			case T_MILLISECS:	ms = this.getVal(1000);
			case T_SECS: 		s = this.getVal(60);
			case T_MINS: 		m = this.getVal(60);
			case T_HOURS: 		h = this.getVal(24);
								d = (long)time;
								break;
			case T_DAYS: d = this.duration;
		}
		strDuration = String.format("%d(d) %02d:%02d:%02d.%03d", d, h, m, s, ms);		
	}
	
	/*
	 * SETTERS & GETTERS
	 */
	/**
	 * Sets a new duration and do the calculations
	 * @param duration
	 */
	public void set(long duration) {
		this.duration = duration;
		time = (double)duration;
		this.eval();
	}
	
	/**
	 * Gets the duration
	 * @return The duration
	 */
	public long get() {
		return this.duration;
	}
	
	/**
	 * Gets the time unit as a String
	 * @return The time unit as a String
	 */
	public String strTimeUnit() {
		return strTimeUnit;
	}
	
	/**
	 * Gets the value of the milliseconds
	 * @return The value of the milliseconds
	 */
	public int millisecs() {
		return this.ms;
	}
	
	/**
	 * Gets the value of the seconds
	 * @return The value of the seconds
	 */
	public int secs() {
		return this.s;
	}
	
	/**
	 * Gets the value of the minutes
	 * @return The value of the minutes
	 */
	public int mins() {
		return this.m;
	}
	
	/**
	 * Gets the value of the hours
	 * @return The value of the hours
	 */
	public int hours() {
		return this.h;
	}

	/**
	 * Gets the value of the days
	 * @return The value of the days
	 */
	public long days() {
		return this.d;
	}

	/*
	 * STRING OUTPUT
	 */
	/**
	 * Returns a String representation of the duration expressed in days(d) hours:minutes:seconds.milliseconds
	 * @return A String representation of the duration expressed in days(d) hours:minutes:seconds.milliseconds
	 */
	public String toString() {
		return strDuration;
	}
}
