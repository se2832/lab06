package applicationSupport;

import java.util.Date;

import billboardManager.BillboardManagerInterface;

/**
 * This class supports a clock. In essence, it provides data to a billboard
 * showing the current time in terms of hours, minutes, and seconds.
 * 
 * @author schilling
 *
 */
public class Clock implements Runnable {
	BillboardManagerInterface bbmi;

	public Clock(BillboardManagerInterface bbmi) {
		this.bbmi = bbmi;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		while ((true)) {
			// Obtain the current date from the system clock.
			Date d = new Date(System.currentTimeMillis());

			// For each part of the date, check and see if it matches what is in
			// the billboard. If it is different, update the attribute. If they
			// match, do nothing as the attribute has not yet changed.
			if (d.getHours() != bbmi.getHours()) {
				bbmi.setHours(d.getHours());
			}
			if (d.getMinutes() != bbmi.getMinutes()) {
				bbmi.setMinutes(d.getMinutes());
			}
			if (d.getSeconds() != bbmi.getSeconds()) {
				bbmi.setSeconds(d.getSeconds());
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// If we wake up early, there is no problem. Just keep going.
			}
		}
	}
}
