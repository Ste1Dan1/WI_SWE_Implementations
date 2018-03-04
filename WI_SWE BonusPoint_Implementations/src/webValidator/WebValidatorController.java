package webValidator;

public class WebValidatorController {

	final private WebValidatorView view;
	final private WebValidatorModel model;
	
	private boolean webAdressValid, portValid; 
	
	protected WebValidatorController(WebValidatorView view, WebValidatorModel model) {
		this.view = view;
		this.model = model;

		view.webAdress.textProperty().addListener((observable, oldV, newV) -> {
			validateWebAdress(newV);
		});

		view.port.textProperty().addListener((observable, oldV, newV) -> {
			validatePort(newV);
		});
		
	}

	private void validatePort(String newV){
		this.portValid = model.isValidPort(newV);
		if (portValid) {
			view.port.setStyle("-fx-text-inner-color: green;");
		} else {
			view.port.setStyle("-fx-text-inner-color: red;");
		}
		this.setButtonVisibility();
	}

	private void validateWebAdress(String newV) {
		this.webAdressValid = model.isValidAdress(newV);
		if (webAdressValid) {
			view.webAdress.setStyle("-fx-text-inner-color: green;");
		} else {
			view.webAdress.setStyle("-fx-text-inner-color: red;");
		}
		
		this.setButtonVisibility();
	}
	
	private void setButtonVisibility(){
		boolean buttonVisible = this.webAdressValid&this.portValid;
		view.connect.setDisable(!buttonVisible);
	}
	

	
	
}
