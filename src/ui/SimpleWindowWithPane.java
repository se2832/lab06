package ui;

import applicationSupport.Clock;
import applicationSupport.MessageDisplays;
import billboardManager.BillboardManager;
/*********************************************************
* SimpleWindowWithPane.java
* Dean & Dean
*
* This program displays a label in a window.
*********************************************************/
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * This class provides the main application for the Billboard ystem.
 * 
 * @author schilling
 *
 */
public class SimpleWindowWithPane extends Application {
	/**
	 * This is the fixed width for the billboard.
	 */
	private static final int WIDTH = 425;
	/**
	 * This is the fixed height for the billboard.
	 */
	private static final int HEIGHT = 125;

	/**
	 * This is the fixed width for the billboard text.
	 */
	public static final int BILLBOARD_TEXT_WIDTH = 18;

	/**
	 * Instantiate a new instance of a billboard manager.
	 */
	private BillboardManager bbm = new BillboardManager(BILLBOARD_TEXT_WIDTH);

	@Override
	public void start(Stage stage) {

		// Create a new billboard pane.
		BillboardPane pane = new BillboardPane();
		pane.createPaneContents();
		bbm.subscribe(pane);

		// For the stage, setup the titles and the single scene that will be
		// there.
		stage.setTitle("MSOE Happenings");
		stage.setScene(new Scene(pane, WIDTH, HEIGHT));
		stage.show();
		stage.setResizable(false);
		stage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});

		// Start the clock running.
		Thread t = new Thread(new Clock(bbm));
		t.start();

		// Start the message displayer running.
		Thread t2 = new Thread(new MessageDisplays(bbm));
		t2.start();
	}
}