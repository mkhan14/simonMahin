package simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickableScreen;

public class SimonScreenMahin extends ClickableScreen implements Runnable {

	private ArrayList<MoveInterfaceMahin> sequence;
	private ProgressInterfaceMahin progress;
	private TextLabel label;
	private ButtonInterfaceMahin[] buttons;
	private int btn[] = new int[6];
	 
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	
	public SimonScreenMahin(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		label.setText("");
		nextRound();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		sequence = new ArrayList<MoveInterfaceMahin>();
		//add 2 moves to start
		lastSelectedButton = -1;
		sequence.add(randomMove());
		sequence.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}
	
	
	
	private MoveInterfaceMahin randomMove() {
		int selection = (int) (Math.random()*buttons.length);
		while(selection == lastSelectedButton){
			selection = (int)(Math.random()*buttons.length);
		}
		lastSelectedButton = selection;
		//return new Move(buttons[selection]);
		return getMove(buttons[selection]);
	}

	private MoveInterfaceMahin getMove(ButtonInterfaceMahin b) {
		// TODO Auto-generated method stub
		return new Move(b);
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceMahin getProgress() {
		// TODO Auto-generated method stub
		return new Progress();
	}
	
	public void nextRound() {
		acceptingInput = false;
		roundNumber++;
		progress.setRound(roundNumber);
		sequence.add(randomMove());
		progress.setSequenceSize(sequence.size());
		changeText("Simon's turn.");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		label.setText("");
		acceptingInput = true;
		sequenceIndex = 0;
}

	private void playSequence() {
		ButtonInterfaceMahin b = null;
		for(MoveInterfaceMahin m: sequence){
			if(b!=null)b.dim();
			b = m.getButton();
			b.highlight();
			try {
				Thread.sleep((long)(2000*(2.0/(roundNumber+2))));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
		
	}

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	
	}

	private void addButtons() {
		int numberOfButtons = 6;
		Color[] colors = {Color.red, Color.blue, new Color(240,160,70), new Color(20,255,140), Color.yellow, new Color(180,90,210)};
		buttons = new ButtonInterfaceMahin[numberOfButtons];
		for(int i = 0; i < numberOfButtons; i++){
			buttons[i] = getAButton();
			buttons[i].setColor(colors[i]);
			buttons[i].setX(160 + (int)(100*Math.cos(i*2*Math.PI/(numberOfButtons))));
			buttons[i].setY(200 - (int)(100*Math.sin(i*2*Math.PI/(numberOfButtons))));
			final ButtonInterfaceMahin b = buttons[i];
			b.dim();
			buttons[i].setAction(new Action(){
				public void act(){
					if(acceptingInput){
					    Thread blink = new Thread(new Runnable(){

					        public void run(){
					        	b.highlight();
					        	try{
					        		Thread.sleep(800);
					        		//b.dim();
					        	}catch(InterruptedException e){
					        		e.printStackTrace();
					        	}
					        	b.dim();
					        }


					    });
					    blink.start();
					    if(b == sequence.get(sequenceIndex).getButton()){
					    	sequenceIndex++;
					    }else{
					    	progress.gameOver();
					    	acceptingInput = false;
					    	return;
					    }
					    if(sequenceIndex == sequence.size()){
					    	Thread nextRound = new Thread(SimonScreenMahin.this);
					    	nextRound.start();
					    }
					}
				}
			});
			viewObjects.add(b);
		}
		
	}

	private ButtonInterfaceMahin getAButton() {
		return new ButtonMahin();
		
	}

}
