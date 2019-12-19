package data;

import java.util.ArrayList;
import java.util.Scanner;

import cars.Car;

public class TaxiService {
	private Scanner in;
	private Autopark autopark;
	private ArrayList<String> history;
	private int numberOfTrips;
	private double mileage;
	private double profit;
	private double priceForCall;
	private double pricePerKM;
	private double percentage;
	
	public TaxiService(Autopark park) {
		in = new Scanner(System.in);
		autopark = park;
		history = new ArrayList<String>();
		numberOfTrips = 0;
		mileage = 0;
		profit = 0;
		pricePerKM = 7;
		priceForCall = 40;
		percentage = 0.2;
	}
	
	public void showStatistic() {
		System.out.println("Кількість поїздок - " + numberOfTrips);
		System.out.println("Загальна відстань - " + mileage + " км");
		System.out.println("Загальний прибуток - " + profit + " грн");
	}
	
	public void showTariffs() {
		System.out.println();
		System.out.println("Вартість виклику - " + priceForCall + " грн");
		System.out.println("Вартість за 1 км - " + pricePerKM + " грн");
		System.out.println("Прибуток від поїздки - " + percentage * 100 + "%");
	}
	
	public void changeTariffs() {
		double input;
		System.out.println("Введіть -1 щоб залишити попереднє значення");
		
		System.out.print("Вартість виклику (грн) ---> ");
		input = in.nextDouble();
		if(input >= 0)
			priceForCall = input;
		
		System.out.print("Вартість за 1 км (грн) ---> ");
		input = in.nextDouble();
		if(input >= 0)
			pricePerKM = input;		
		
		System.out.print("Прибуток від поїздки (%) ---> ");
		input = in.nextDouble();
		if(input >= 0)
			percentage = input/100;
	}
	
	public void addTrip() {
		autopark.showPark();
		if(autopark.getCars().isEmpty()) {
			System.out.println("Створіть автопарк!");
			return;
		}
		System.out.println("\n\tДобавити поїздку");
		System.out.print("Відстань ---> ");
		double s = in.nextDouble();
		System.out.print("Номер машини ---> ");
		int id = in.nextInt();
		addTripToHistory(s, id);
		System.out.println("Поїздка добавлена!");
		
		profit += (priceForCall + pricePerKM * s) * percentage;
		mileage += s;
		numberOfTrips += 1;
	}
	
	private void addTripToHistory(double s, int id) {
		Car car = autopark.getCars().get(id - 1);
		String str = String.format("%d.%s %s\n\tВідстань - %.2f км\n\tПрофіт - %.2f грн\n", history.size() + 1, car.getMake(), car.getModel(), s, (priceForCall + pricePerKM * s) * percentage);
		history.add(str);
	}
	
	public void tripHistory() {
		if(history.isEmpty()) {
			System.out.println("Історія пуста");
			return;
		}
		for(String s: history) {
			System.out.println(s);
		}
			
	}
}
