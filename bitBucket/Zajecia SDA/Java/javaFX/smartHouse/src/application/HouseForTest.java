package application;

public class HouseForTest implements House {
	
	@Override
	public void showUpdates() {
		// TODO Auto-generated method stub
		System.out.println("Show Update");
	}

	@Override
	public void showOptions() {
		System.out.println("Show Options");
		// TODO Auto-generated method stub

	}

	@Override
	public void setWindowsClosed(boolean closed) {
		System.out.println("Closed: "+closed);

	}

	@Override
	public void setHeatingLevel(HeatingLevel level) {
		// TODO Auto-generated method stub
		System.out.println("Heating Level: "+level.name());

	}

}
