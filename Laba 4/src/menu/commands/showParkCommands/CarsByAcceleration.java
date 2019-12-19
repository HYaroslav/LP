package menu.commands.showParkCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class CarsByAcceleration implements Command{
	MenuReceiver m;
	
	public CarsByAcceleration(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.showCarsByAcceleration(); }

	public void undo() { m.showPark(); }
}

