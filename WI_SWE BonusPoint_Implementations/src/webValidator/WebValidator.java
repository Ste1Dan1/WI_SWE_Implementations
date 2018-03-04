package webValidator;


import javafx.application.Application;
import javafx.stage.Stage;
import webValidator.WebValidatorController;
import webValidator.WebValidatorModel;
import webValidator.WebValidatorView;

public class WebValidator extends Application {

	
		private WebValidatorModel model;
		private WebValidatorView view;
		private WebValidatorController controller;

		public static void main(String[] args) {
			launch();
		}
		
		/**
		 * Note the dependencies between model, view and controller. Additionally,
		 * the view needs the primaryStage created by JavaFX.
		 */
		@Override
		public void start(Stage primaryStage) {
			model = new WebValidatorModel();
			view = new WebValidatorView(primaryStage, model);
			controller = new WebValidatorController(view, model);
			
			// Display the GUI after all initialization is complete
			view.start();
		}


		@Override
		public void stop() {
			if (view != null) view.stop();
		}
	}