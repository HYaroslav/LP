package menu.commands.showParkCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class AddCar implements Command{
	MenuReceiver m;
	
	public AddCar(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.addCar(); }

	public void undo() { m.showPark(); }
}