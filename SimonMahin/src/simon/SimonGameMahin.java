package simon;

import guiPractice.GUIApplication;
import whackAMole.WhackAMoleGame;
import whackAMole.WhackAMoleScreen;

public class SimonGameMahin extends GUIApplication {

	public SimonGameMahin() {
		// TODO Auto-generated constructor stub
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
