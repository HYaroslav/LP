package menu.commands.mainMenuCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class TaxiServices implements Command{
	MenuReceiver m;
	
	public TaxiServices(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.taxiServices(); }
	
	public void undo() { m.homeMenu(); }
}
