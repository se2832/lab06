package applicationSupport;

import billboardManager.BillboardManagerInterface;

/**
 * This class provides messages to the billboard that will be displayed. It is
 * provided for example purposes only, as a full blown implementation will
 * provide this data from a text file or some other changeable interface.
 * 
 * @author schilling
 *
 */
public class MessageDisplays implements Runnable {
	/**
	 * This is the instance of the billboard manager that is to be used for
	 * display purposes.
	 */
	private BillboardManagerInterface bbmi;

	/**
	 * The following is a set of two messages that are to be scrolled on the
	 * message billboard.
	 */
	private String messages[] = {
			"On April 29, 2017, John Y. Walz, Ph.D. will be inaugurated as MSOE’s fifth president since its founding in 1903.",
			"Strong north winds will continue today. Maximum gusts of 35- 45 mph can be expected, with the higher gusts in far eastern WI. Wind gusts near Lake Michigan may approach 50 mph. A High Wind Advisory is in effect for far southeast WI until 4 pm this afternoon. Winds will remain gusty through the night and into tomorrow before finally calming on Friday evening." };

	/**
	 * This is the billboard manager interface.
	 * @param bbmi This is the interface that is to be used for billboard displays.
	 */
	public MessageDisplays(BillboardManagerInterface bbmi) {
		this.bbmi = bbmi;
	}

	/**
	 * This method will manage the display of a given message on the billboard.
	 * @param message This si the message string that is to be displayed.
	 */
	private void manageMessage(String message) {
		// Start by removing any excessive whitespace from the string which will impact its display.
		// Then set the message in the billboard manager.
		bbmi.setMessage(message.trim());

		do {
			try {
				// SLeep for 200ms.
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// If there is more text to show, scroll left one character.
		} while (bbmi.scrollLeft(1) == true);
	}

	@Override
	public void run() {
		// Just keep looping.
		while (true) {
			manageMessage(messages[0]);
			manageMessage(messages[1]);
		}
	}
}
