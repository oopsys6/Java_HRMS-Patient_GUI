package gui;

public class PatientApplication {
	static BackgroundPanel backgroundPanel = new BackgroundPanel();
	public static final String PATH = "./image/";
	
	public static void main(String[] args) {
		Login login = new Login();
		login.loginGUI(backgroundPanel);
		
	}
}
