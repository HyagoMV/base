package com.github.hyagomv;

import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.stage.Stage;

// -Djavafx.preloader=com.github.hyagomv.MyPreloader
public class MyPreloader extends Preloader {
	
	private Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		
		stage.setTitle("Preloader");
		stage.setWidth(400);
		stage.setHeight(400);
		stage.show();
		
		
	}

	@Override
	public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
		switch (stateChangeNotification.getType()) {
		case BEFORE_LOAD:
			System.out.println("BEFORE_LOAD");
			break;

		case BEFORE_INIT:
			System.out.println("BEFORE_INIT");
			break;

		case BEFORE_START:
			System.out.println("BEFORE_START");

			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + stateChangeNotification.getType());
		}
	}

	@Override
	public void handleApplicationNotification(PreloaderNotification preloaderNotification) {
		if (preloaderNotification instanceof StateChangeNotification stateChangeNotification) {
			switch (stateChangeNotification.getType()) {
			case BEFORE_START:
				System.out.println("BEFORE_START");
				stage.close();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + stateChangeNotification.getType());
			}
		}
	}

}
