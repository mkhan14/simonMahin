package simon;

import guiPractice.GUIApplication;

public class SimonGameMahin extends GUIApplication {

	public SimonGameMahin() {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	protected void initScreen() {
		// TODO Auto-generated method stub
		SimonScreenMahin ss = new SimonScreenMahin(getWidth(),
				getHeight());
		setScreen(ss);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimonGameMahin game = new SimonGameMahin();
		Thread app = new Thread(game);
		app.start();
	}

}
