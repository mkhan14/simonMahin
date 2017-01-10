package simon;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceMahin 
{
	


	private static final int WIDTH = 120;
	private static final int HEIGHT = 50;

	private boolean gameOver;
	private String round;
	private String sequence;
	public Progress() 
	{
		super(60, 60, WIDTH, HEIGHT);
	}
	@Override
	public int getX() 
	{
		return 0;
	}

	@Override
	public int getY() 
	{
		return 0;
	}

	@Override
	public int getWidth() 
	{
		
		return 0;
	}

	@Override
	public int getHeight() 
	{
		return 0;
	}

	@Override
	public boolean isAnimated() 
	{
		return false;
	}
	
	@Override
	public void setRound(int roundNumber) 
	{
		round = "Round " + roundNumber;
		update();
	}

	@Override
	public void gameOver() 
	{
		gameOver = true;
		update();
	}

	@Override
	public void setSequenceSize(int size) 
	{
		sequence = "Sequence length " + size;
		update();
	}


	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub
		
	}

}
