package menu.commands.taxiServiceCommands;

import menu.MenuReceiver;
import menu.commands.Command;

public class ShowTariffs implements Command{
	MenuReceiver m;
	
	public ShowTariffs(MenuReceiver m) { this.m = m; }
	
	public void execute() { m.showTariffs(); }
	
	public void undo() { m.taxiServices(); }
}
