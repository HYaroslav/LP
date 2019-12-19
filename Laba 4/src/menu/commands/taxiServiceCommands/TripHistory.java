package menu.commands.taxiServiceCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class TripHistory implements Command{
	MenuReceiver m;
	
	public TripHistory(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.tripHistory(); }
	
	public void undo() { m.taxiServices(); }
}