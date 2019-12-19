package menu.commands.showParkCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class SortPark implements Command{
	MenuReceiver m;
	
	public SortPark(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.sortPark(); }

	public void undo() { m.showPark(); }
}

