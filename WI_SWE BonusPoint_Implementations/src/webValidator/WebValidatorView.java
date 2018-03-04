package webValidator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class WebValidatorView {

	private WebValidatorModel model;
	private Stage stage;

	public TextField webAdress = new TextField();
	public TextField port = new TextField();
	public Label webAdressLabel = new Label("Web Adress: ");
	public Label portLabel = new Label("Port: ");
	public Button connect = new Button("Connect");

	protected WebValidatorView(Stage stage, WebValidatorModel model) {
		this.stage = stage;
		this.model = model;
		stage.setTitle("Web Adress Validator");
		connect.setDisable(true);
		
		GridPane root = new GridPane();
		root.add(webAdressLabel, 0, 0);
		root.add(webAdress, 1, 0);
		root.add(portLabel, 0, 1);
		root.add(port, 1, 1);
		root.add(connect, 0, 3);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		;

	}

	public void start() {
		stage.show();

	}

	public void stop() {
		stage.hide();

	}

}
