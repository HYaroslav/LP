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
		System.out.println("ʳ������ ������ - " + numberOfTrips);
		System.out.println("�������� ������� - " + mileage + " ��");
		System.out.println("��������� �������� - " + profit + " ���");
	}
	
	public void showTariffs() {
		System.out.println();
		System.out.println("������� ������� - " + priceForCall + " ���");
		System.out.println("������� �� 1 �� - " + pricePerKM + " ���");
		System.out.println("�������� �� ������ - " + percentage * 100 + "%");
	}
	
	public void changeTariffs() {
		double input;
		System.out.println("������ -1 ��� �������� �������� ��������");
		
		System.out.print("������� ������� (���) ---> ");
		input = in.nextDouble();
		if(input >= 0)
			priceForCall = input;
		
		System.out.print("������� �� 1 �� (���) ---> ");
		input = in.nextDouble();
		if(input >= 0)
			pricePerKM = input;		
		
		System.out.print("�������� �� ������ (%) ---> ");
		input = in.nextDouble();
		if(input >= 0)
			percentage = input/100;
	}
	
	public void addTrip() {
		autopark.showPark();
		if(autopark.getCars().isEmpty()) {
			System.out.println("������� ��������!");
			return;
		}
		System.out.println("\n\t�������� ������");
		System.out.print("³������ ---> ");
		double s = in.nextDouble();
		System.out.print("����� ������ ---> ");
		int id = in.nextInt();
		addTripToHistory(s, id);
		System.out.println("������ ���������!");
		
		profit += (priceForCall + pricePerKM * s) * percentage;
		mileage += s;
		numberOfTrips += 1;
	}
	
	private void addTripToHistory(double s, int id) {
		Car car = autopark.getCars().get(id - 1);
		String str = String.format("%d.%s %s\n\t³������ - %.2f ��\n\t������ - %.2f ���\n", history.size() + 1, car.getMake(), car.getModel(), s, (priceForCall + pricePerKM * s) * percentage);
		history.add(str);
	}
	
	public void tripHistory() {
		if(history.isEmpty()) {
			System.out.println("������ �����");
			return;
		}
		for(String s: history) {
			System.out.println(s);
		}
			
	}
}
