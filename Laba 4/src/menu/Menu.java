package menu;

import java.util.Scanner;
import menu.commands.*;
import menu.commands.mainMenuCommands.*;
import menu.commands.showParkCommands.*;
import menu.commands.taxiServiceCommands.*;

public class Menu {
	Scanner in;
	MenuReceiver menuReceiver;
	MenuInvoker menuInvoker;
	
	public Menu() {
		menuReceiver = new MenuReceiver();
		menuInvoker = new MenuInvoker();
		in = new Scanner(System.in);
	}
	
	public void start() {
		while(true) {
			startMenu(menuReceiver, menuInvoker);
		}
	}
	
	private void startMenu(MenuReceiver menu, MenuInvoker receiver) {
		
		receiver.run(new HomeMenu(menu));
		
		int choice = input();
		
		switch(choice) {
			
		case 1: 
			while(showParkMenu(menu, receiver) != 0) { }
			break;
		case 2:
			receiver.run(new RandomAutoPark(menu));
			break;
		case 3:
			receiver.run(new LoadAutoPark(menu));
			receiver.undo();
			break;
		case 4:
			receiver.run(new SaveAutoPark(menu));
			receiver.undo();
			break;
		case 5: 
			while(taxiServiceMenu(menu, receiver) != 0) { }
			break;
		case 9:
			do {
				receiver.run(new About(menu));
			} while(input() != 0);
			receiver.undo();
			break;
		case 0: receiver.undo();
			
		}
	}
	
	private int showParkMenu(MenuReceiver menu, MenuInvoker receiver) {
		receiver.run(new ShowPark(menu));
		
		int choice = input();
		
		switch(choice) {
		
		case 1: 
			receiver.run(new SortPark(menu));
			receiver.undo();
			break;
		case 2:
			do {
				receiver.run(new ParkPrice(menu));
			} while(input() != 0);
			receiver.undo();
			break;
		case 3:
			do {
				receiver.run(new CarsByAcceleration(menu));
			} while(input() != 0);
			receiver.undo();
			break;
		case 4: 
			receiver.run(new AddCar(menu));
			receiver.undo();
			break;
		case 5: 
			receiver.run(new DeleteCar(menu));
			receiver.undo();
			break;
		case 0: receiver.undo(); break;
		}
		
		return choice;
	}
	
	private int taxiServiceMenu(MenuReceiver menu, MenuInvoker receiver) {
		receiver.run(new TaxiServices(menu));
		
		int choice = input();
		
		switch(choice) {
		
		case 1: 
			do {
				receiver.run(new ShowTariffs(menu));
			} while(input() != 0);
			receiver.undo();
			break;
		case 2:
			receiver.run(new ChangeTariffs(menu));
			receiver.undo();
			break;
		case 3:
			receiver.run(new AddTrip(menu));
			receiver.undo();
			break;
		case 4:
			do {
				receiver.run(new TripHistory(menu));
			} while(input() != 0);
			receiver.undo();
			break;
		case 0: receiver.undo(); break;
		}
		
		return choice;
	}
	
	private int input() {
		System.out.print("\n\n\n\n\n\n\n\n¬вед≥ть номер пункту ----> ");
		return in.nextInt();
	}
}