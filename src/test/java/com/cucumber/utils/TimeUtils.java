/**
 * 
 */
package com.cucumber.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author ramu.mandanapu
 *
 */
public class TimeUtils {

	private static TimeUtils timeUtils = new TimeUtils();

	/**
	 * 
	 */
	private TimeUtils() {

	}

	/**
	 * @return
	 */
	public static TimeUtils getInstance() {
		return timeUtils;
	}

	/**
	 * @param milliSeconds
	 * @return
	 */
	public String getSeconds(long milliSeconds) {
		return String.format(
				"%02d Secs, %02d Millis",
				TimeUnit.MILLISECONDS.toSeconds(milliSeconds),
				TimeUnit.MILLISECONDS.toMillis(milliSeconds)
						- TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS
								.toSeconds(milliSeconds)));
	}

	/**
	 * @return
	 */
	public String getTimeString() {
		Date today = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy_hh_mm_ss");
		return ft.format(today);
	}
}
