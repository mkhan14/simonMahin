package simon;

import guiPractice.components.Visible;

public interface ProgressInterfaceMahin extends Visible {
	void setRound(int roundNumber);

	void setSequenceSize(int size);
	
	void gameOver();
}
