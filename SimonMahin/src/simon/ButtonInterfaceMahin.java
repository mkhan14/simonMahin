package simon;

import java.awt.Color;

import guiPractice.components.Action;

import guiPractice.components.Clickable;

public interface ButtonInterfaceMahin extends Clickable {
	void setColor(Color color);

	
	void highlight();

	void dim();

	void setAction(Action action);

	
	void setName(String name);


	void setX(int i);


	void setY(int i);
}
