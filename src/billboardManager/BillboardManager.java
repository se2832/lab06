package billboardManager;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * This class provides an implementation for the billboard manager. It manages a
 * single billboard by keeping track of the time and allowing for scrolling to
 * occur.
 * 
 * @author schilling
 *
 */
public class BillboardManager implements BillboardManagerInterface {
	/**
	 * This is the message that is to be displayed.
	 */
	private String message;
	/**
	 * This is the length of the message that is to be displayed.
	 */
	private int messageLength;
	/**
	 * This is the current offset, or the start within the string, of the given
	 * message.
	 */
	private int offset;
	/**
	 * This is the wdith of the display area for the message.
	 */
	private int width;
	/**
	 * This is the current time hours.
	 */
	private int hours;
	/**
	 * This is the current time minutes.
	 */
	private int minutes;
	/**
	 * This is the current time seconds.
	 */
	private int seconds;

	/**
	 * These are the observers that are to be notified when a change to the data
	 * within this class occurs.
	 */
	private List<BillboardObserverInterface> obs = new LinkedList<BillboardObserverInterface>();

	/**
	 * This private method will cause subscribers to be updated when the values
	 * within this class change.
	 */
	private void updateSubscribers() {
		Iterator<BillboardObserverInterface> iter = obs.iterator();

		while (iter.hasNext()) {
			iter.next().updateDisplay(this);
		}
	}

	/**
	 * This method will instantiate a new instance of this class.
	 * 
	 * @param width
	 *            This is the width of the area that is to display the message.
	 * @throws IllegalArgumentException
	 *             This exception will be thrown if a negative or zero vlue for
	 *             the width is passed in.
	 */
	public BillboardManager(int width) throws IllegalArgumentException {
		if (width <= 0) {
			throw new IllegalArgumentException("The width must be greater than 0.");
		}
		this.width = width;
		this.offset = 0;
		message = "";
		hours = 0;
		minutes = 0;
		seconds = 0;
	}

	@Override
	public void setWidth(int width) throws IllegalArgumentException {
		if (width > 0) {
			this.width = width;
		} else {
			throw new IllegalArgumentException("Width must be >= 0.");
		}
	}

	@Override
	public String getDisplayedMessage() {
		String retValue;

		if (offset > message.length()) {
			retValue = "";
		} else if ((offset + width) < message.length()) {
			retValue = message.substring(offset, offset + width );
		} else {
			retValue = message.substring(offset);
		}
		return retValue;
	}

	@Override
	public void setMessage(String message) throws IllegalArgumentException {
		if (message != null) {
			offset = 0;
			messageLength = message.length() + width;

			// Append spaces to the beginning and end.
			char[] charArray = new char[width - 1];
			Arrays.fill(charArray, ' ');
			String str = new String(charArray);

			this.message = str + message + str;
			updateSubscribers();
		} else {
			throw new IllegalArgumentException("The message passed in can not be null.");
		}
	}

	@Override
	public boolean scrollLeft(int numberOfCharacters) throws IllegalArgumentException {
		boolean retValue = true;
		if (numberOfCharacters > 0) {
			offset += numberOfCharacters;
			if ((offset == messageLength)) {
				// The entire message has displayed.
				retValue = false;
			}
			updateSubscribers();
		} else {
			throw new IllegalArgumentException("The number of characters to scroll must be greater than zero.");
		}
		return retValue;
	}

	@Override
	public void setHours(int hours) throws IllegalArgumentException {
		if ((hours >= 0) && (hours < 24)) {
			this.hours = hours;
			updateSubscribers();
		} else {
			throw new IllegalArgumentException("The value for hours is out of range.");
		}

	}

	@Override
	public void setMinutes(int minutes) throws IllegalArgumentException {
		if ((minutes >= 0) && (minutes < 60)) {
			this.minutes = minutes;
			updateSubscribers();
		} else {
			throw new IllegalArgumentException("The value for minutes is out of range.");
		}

	}

	@Override
	public void setSeconds(int seconds) throws IllegalArgumentException {
		if ((seconds >= 0) && (seconds < 60)) {
			this.seconds = seconds;
			updateSubscribers();
		} else {
			throw new IllegalArgumentException("The value for seconds is out of range.");
		}

	}


	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHours() {
		return hours;
	}

	@Override
	public int getMinutes() {
		return minutes;
	}

	@Override

	public int getSeconds() {
		return seconds;
	}

	@Override
	public void subscribe(BillboardObserverInterface obs) {
		this.obs.add(obs);
	}

}
