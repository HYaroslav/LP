package menu.commands.taxiServiceCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class ChangeTariffs implements Command{
	MenuReceiver m;
	
	public ChangeTariffs(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.changeTariffs(); }
	
	public void undo() { m.taxiServices(); }
}