package billboardManager;

/**
 * This interface defines the interface for an observer of a billboard. It will
 * be invoked whenever a change in the data held by the class occurs.
 * 
 * @author schilling
 *
 */
public interface BillboardObserverInterface {
	/**
	 * This method will indicate that a display change within the billboard
	 * manager has occurred and there is a need for the realization fot he
	 * display to refresh itself.
	 * 
	 * @param dataSource
	 *            This is the data source that has had the change occur.
	 */
	void updateDisplay(BillboardManagerInterface dataSource);

}
