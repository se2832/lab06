package billboardManager;

/**
 * This interface defines how one can interact with a billboard manager. The
 * billboard manager class provides an ability to scroll parts of a longer
 * message on a display as well as to show the current time to the user.
 * 
 * @author schilling
 *
 */
public interface BillboardManagerInterface {
	/**
	 * This method will return from a billboard manager the portion of the
	 * message that is to be displayed. The portion of the message that is to be
	 * displayed will be <width> characters in width and will start an an offset
	 * between 0 and the length of the string. The text can be scrolled left by
	 * a call to the scroll left method.
	 * 
	 * @return The return will be the string that is to be displayed.
	 */
	String getDisplayedMessage();

	/**
	 * This method will return the hours variable that has been set within this
	 * class.
	 * 
	 * @return The hours will be returned.
	 */
	int getHours();

	/**
	 * This method will return the minutes variable that has been set within
	 * this class.
	 * 
	 * @return The minutes will be returned.
	 */
	int getMinutes();

	/**
	 * This method will return the seconds variable that has been set within
	 * this class.
	 * 
	 * @return The seconds will be returned.
	 */
	int getSeconds();

	/**
	 * This method will cause a new message to be displayed on the billboard.
	 * The current message will be removed and the new message will be shown.
	 * 
	 * @param message
	 *            This is the new message that is to be displayed.
	 * @throws IllegalArgumentException
	 *             This exception will be thrown if the message is null.
	 */
	void setMessage(String message) throws IllegalArgumentException;

	/**
	 * This method will cause the text that is displayed to scroll a number of
	 * characters to the left.
	 * 
	 * @param numberOfCharacters
	 *            This is the number of characters to scroll.
	 * @return The return will be true if there are more characters to scroll
	 *         through or false if the end of the message has been reached.
	 * @throws IllegalArgumentException
	 *             This exception will be thrown if the number of characters to
	 *             scroll is negative.
	 */
	boolean scrollLeft(int numberOfCharacters) throws IllegalArgumentException;

	/**
	 * This method will set the current hours that can be used by a TOD display.
	 * 
	 * @param hours
	 *            The hours is the value of hours.
	 * @throws IllegalArgumentException
	 *             The hours must be between 0 and 23. Otherwise, an Illegal
	 *             Argument exception will be thrown.
	 */
	void setHours(int hours) throws IllegalArgumentException;

	/**
	 * This method will set the current minutes that can be used by a TOD
	 * display.
	 * 
	 * @param minutes  The minutes is the value of minutes.
	 * @throws IllegalArgumentException
	 *             The minutes must be between 0 and 59. Otherwise, an Illegal
	 *             Argument exception will be thrown.
	 */

	void setMinutes(int minutes) throws IllegalArgumentException;

	/**
	 * This method will set the current seconds that can be used by a TOD
	 * display.
	 * hours
	 *            The hours is the value of seconds.
	 * @throws IllegalArgumentException
	 *             The seconds must be between 0 and 59. Otherwise, an Illegal
	 *             Argument exception will be thrown.
	 */
	void setSeconds(int seconds) throws IllegalArgumentException;

	/**
	 * This method will set the width of the billboard that is to display the
	 * message. The width must be positive.
	 * 
	 * @param width
	 *            The width of the billboard must be positive.
	 * @throws IllegalArgumentException
	 *             This exception will be thrown if the value for the billboard
	 *             is less than 0.
	 */
	void setWidth(int width) throws IllegalArgumentException;

	/**
	 * This method will add a new observer to the class. The observer will be
	 * called whenever a change is made to an internal variable. There can be
	 * many different observers. Each will be called in the sequence that it was
	 * added as an observer.
	 * 
	 * @param obs
	 *            This is the instance of the observer that is being added.
	 */
	void subscribe(BillboardObserverInterface obs);

}
