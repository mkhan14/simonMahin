package simon;

public class Move implements MoveInterfaceMahin {

	private ButtonInterfaceMahin b; 
	
	public Move(ButtonInterfaceMahin b) 
	{
		this.b = b;
	}
	public ButtonInterfaceMahin getButton() 
	{
		return b;
	}
}
