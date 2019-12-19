package menu.commands.showParkCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class ParkPrice implements Command{
	MenuReceiver m;
	
	public ParkPrice(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.parkPrice(); }

	public void undo() { m.showPark(); }
}
