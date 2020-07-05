package TestDuration;

import com.ipserc.duration.duration;

public class test_duration {

	private static void testDuration(long durationVal, String units) {
		duration myDuration = new duration(durationVal, units);
		System.out.println("------------------------------------------------------------------");
		System.out.println("DURATION IN " + myDuration.strTimeUnit());
		System.out.println("Duration value:" + String.format("%d", myDuration.get()));
		System.out.println("Duration ms:" + String.format("%d", myDuration.millisecs()));
		System.out.println("Duration s:" + String.format("%d", myDuration.secs()));
		System.out.println("Duration m:" + String.format("%d", myDuration.mins()));
		System.out.println("Duration h:" + String.format("%d", myDuration.hours()));
		System.out.println("Duration d:" + String.format("%d", myDuration.days()));
		System.out.println("Duration in " + units +":" + myDuration.toString());
		System.out.println("------------------------------------------------------------------");
		myDuration.set(1234567890l); 
		System.out.println("Duration value:" + String.format("%d", myDuration.get()));
		System.out.println("Duration in " + units +":" + myDuration.toString());
		System.out.println("------------------------------------------------------------------");		
	}

	public static void main(String[] args) {
		// MAX LONG	9223372036854775807
		long durationVal = 	76442327;
		testDuration(durationVal, "ms");
		testDuration(durationVal, "s");
		testDuration(durationVal, "m");
		testDuration(durationVal, "h");
		testDuration(durationVal, "d");
	}

}
