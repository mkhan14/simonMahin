package simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
	/*@Override
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
	}*/
	
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
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(gameOver){
			g.setColor(Color.green);
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.black);
			String go = "GAME OVER!";
			g.drawString(go, (WIDTH - fm.stringWidth(go))/2, 20);
			g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 40);

		}else{
			g.setColor(new Color(220,255,230));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.black);
			g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
			if(round !=null && sequence != null){

				g.drawString(round, (WIDTH - fm.stringWidth(round))/2, 20);
				g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 40);
			}
		}
	}

}
