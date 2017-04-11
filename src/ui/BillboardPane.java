package ui;

import billboardManager.BillboardManagerInterface;
import billboardManager.BillboardObserverInterface;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * This class uses JavaFX to realize a billboard pane. It will have an MSOE
 * logo, a billboard scrolled message, and a clock shown on it.
 * 
 * @author schilling
 *
 */
public class BillboardPane extends BorderPane implements BillboardObserverInterface {

	/**
	 * This attribute will store the label for the scrolling message.
	 */
	private Label scrollingMessageLabel;
	/**
	 * This label will hold the clock.
	 */
	private Label clockLabel;

	public BillboardPane() {
		super();
	}

	/**
	 * This method will create the pane with the appropriate items available on
	 * the screen.
	 */
	public void createPaneContents() {
		// Start by configuring the top scrolling message area.
		scrollingMessageLabel = new Label("");
		scrollingMessageLabel.setStyle("-fx-font-weight: bold; -fx-font-family: monospace; -fx-font-size: 40");

		// Now setup the clock.
		clockLabel = new Label("12:00:00");
		clockLabel.setStyle("-fx-font-family: monospace; -fx-font-size: 68");

		// Now setup the MSOE logo.
		Image image = new Image("/icon/msoe.jpg");
		ImageView iv = new ImageView();
		iv.setImage(image);
		iv.setFitWidth(100);
		iv.setPreserveRatio(true);

		// With all of these things setup, add them to the pane.
		this.setRight(clockLabel);
		this.setTop(scrollingMessageLabel);
		this.setLeft(iv);
	}

	@Override
	public void updateDisplay(BillboardManagerInterface dataSource) {
		// Start by updating the clock.
		String time = String.format("%02d:%02d:%02d", dataSource.getHours(), dataSource.getMinutes(),
				dataSource.getSeconds());
		// At a time in the future, cause the UI thread to update the display.
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				clockLabel.setText(time);
			}
		});
		// Now get the displayed message, and at a time in the future, cause it
		// to update.
		String message = dataSource.getDisplayedMessage();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				scrollingMessageLabel.setText(message);
			}
		});
	}
}
