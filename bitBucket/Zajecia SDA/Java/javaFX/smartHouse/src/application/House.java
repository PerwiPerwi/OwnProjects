package application;

public interface House {

	void showUpdates();
	void showOptions();
	void setWindowsClosed(boolean closed);
	void setHeatingLevel(HeatingLevel level);
	
	enum HeatingLevel{
		NONE, LOW, MIDDLE, HIGH;
	}	
}
