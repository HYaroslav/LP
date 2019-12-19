package menu.commands.showParkCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class DeleteCar implements Command{
	MenuReceiver m;
	
	public DeleteCar(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.deleteCar(); }

	public void undo() { m.showPark(); }
}