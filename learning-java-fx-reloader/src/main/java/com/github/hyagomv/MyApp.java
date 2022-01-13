package com.github.hyagomv;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader.StateChangeNotification;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.concurrent.Task;
import javafx.stage.Stage;

public class MyApp extends Application {

	@Override
	public void init() throws Exception {
		fakeProcessing();
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Application");

		ready.addListener(event -> {
			Platform.runLater(new Runnable() {
				public void run() {
					stage.setWidth(400);
					stage.setHeight(400);
					stage.show();
				}
			});
		});
	}

	private SimpleBooleanProperty ready = new SimpleBooleanProperty(false);

	private void fakeProcessing() {
		Task<Void> task = new Task<>() {

			@Override
			protected Void call() throws Exception {
				Thread.sleep(2000);
				notifyPreloader(new StateChangeNotification((StateChangeNotification.Type.BEFORE_START)));
				ready.set(true);
				return null;
			}

		};

		new Thread(task).start();
	}

}
