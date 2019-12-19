package menu;

import java.util.Scanner;

import cars.Car;
import cars.carFeatures;
import data.Autopark;
import data.TaxiService;

public class MenuReceiver {
	
	private Autopark autoPark;
	private TaxiService taxiService;
	private Scanner in;
	private boolean open = false;
	
	public MenuReceiver() {
		autoPark = new Autopark();
		taxiService = new TaxiService(autoPark);
		in = new Scanner(System.in);
	}
	
	public void homeMenu() {
		if(open)
			newPage();
		else
			open = true;
		System.out.println("\tTaxi Manager");
		System.out.println("1. ����������� ��������");
		System.out.println("2. �������� ����� ���������� ��������");
		System.out.println("3. ��������� ��� ��� �������� � �����");
		System.out.println("4. �������� ��������");
		System.out.println("5. ������� ����");
		System.out.println("9. ��� ��������");
		System.out.println("0. �����");
	}
	
	public void showPark() {
		newPage();
		autoPark.showPark();
		System.out.println("\n\n");
		System.out.println("1. ����������");
		System.out.println("2. �������� ������� ���������");
		System.out.println("3. �������� ���� �� ������� �������� �������");
		System.out.println("4. �������� ���������");
		System.out.println("5. �������� ���������");
		System.out.println("0. �����");
	}
	
	public void addCar() {
		newPage();
		Car car = new Car();
		System.out.println("������ ��� ��� ����");
		
		System.out.print("�������� ---> ");
		String make = in.nextLine();
		car.setMake(make);
		
		System.out.print("������ ---> ");
		String model = in.nextLine();
		car.setModel(model);
		
		System.out.print("���� ������� ---> ");
		int releaseYear = in.nextInt();
		car.setReleaseYear(releaseYear);
		
		System.out.print("��������� ������� (��) ---> ");
		int engineHorsePower = in.nextInt();
		car.setEngineHorsePower(engineHorsePower);
		
		System.out.print("ʳ������ ���� (��� ����) ---> ");
		int numberOfSits = in.nextInt();
		car.setNumberOfSits(numberOfSits);
		
		System.out.print("�������� ---> ");
		String marketCategory = in.next();
		car.setMarketCategory(marketCategory);
		
		System.out.print("����� ---> ");
		String style = in.next();
		car.setStyle(style);
		
		System.out.print("������ �������: ���� ---> ");
		int highwayMpg = in.nextInt();
		car.setHighwayMpg(highwayMpg);
		
		System.out.print("������ �������: ���� ---> ");
		int cityMpg = in.nextInt();
		car.setCityMpg(cityMpg);
		
		System.out.print("ֳ�� $ ---> ");
		int price = in.nextInt();
		car.setPrice(price);
		
		System.out.print("����� �� 100��/��� (�) ---> ");
		double accelerationToOneHundred = in.nextDouble();
		car.setAccelerationToOneHundred(accelerationToOneHundred);
		
		autoPark.addCar(car);
		System.out.println("��������� ���������!");
		waitAnim();
	}
	
	public void deleteCar() {
		newPage();
		autoPark.showPark();
		if(!autoPark.getCars().isEmpty()) {
			System.out.println("\n\n�������� ������");
			System.out.print("����� ---> ");
			int index = in.nextInt();
			autoPark.removeCarByIndex(index);
			System.out.println("��������� ��������!");
		}
		waitAnim();
	}
	
	public void sortPark() {
		newPage();
		System.out.println("����������:");
		System.out.println("1. �� ����� ������� ����");
		System.out.println("2. �� ���������");
		System.out.println("3. �� ������� ����");
		System.out.println("4. �� ������������� �������� �� ����");
		System.out.println("5. �� ������������� �������� � ���");
		System.out.println("6. �� ������� ���������");
		System.out.println("7. �� ������� ������� �� 100 ��/���");
		System.out.println("0. �����");
		
		System.out.print("\n\n\n\n\n\n\n\n\n\n������ ����� ������ ----> ");
		int choice = in.nextInt();
		carFeatures feature;
		
		switch(choice) {
		case 1: feature = carFeatures.releaseYear; break;
		case 2: feature = carFeatures.engineHorsePower; break;
		case 3: feature = carFeatures.numberOfSits; break;
		case 4: feature = carFeatures.highwayMpg; break;
		case 5: feature = carFeatures.highwayMpg; break;
		case 6: feature = carFeatures.price; break;
		case 7: feature = carFeatures.acceleration; break;
		case 0: return;
		default:sortPark();return;
		}
		
		sortAscendingDescending();
		autoPark.sort(feature);
	}
	
	public void showCarsByAcceleration() {
		newPage();
		double min, max;
		System.out.println("������ ���:");
		System.out.print("̳�������� ��� ������� ---> ");
		min = in.nextDouble();
		System.out.print("������������ ��� ������� ---> ");
		max = in.nextDouble();
		
		newPage();
		autoPark.showCarsInAccelerationRange(min, max);
		System.out.println("\n0. �����");
	}
	
	private void sortAscendingDescending() {
		newPage();
		System.out.println("����������:");
		System.out.println("1. �� ���������");
		System.out.println("2. �� ����������");
		System.out.print("\n\n\n\n\n\n\n\n\n\n������ ����� ������ ----> ");
		int choice = in.nextInt();
		
		switch(choice) {
		case 1: autoPark.setSortType(Autopark.sortingType.descending); break;
		case 2: autoPark.setSortType(Autopark.sortingType.ascending); break;
		default: sortAscendingDescending(); break;
		}
	}
	
	public void parkPrice() {
		newPage();
		autoPark.showEstimatePrice();
		System.out.println("0. �����");
	}
	
	public void createNewRandomAutoPark() {
		newPage();
		System.out.print("������ ������� ����� � ��������� ----> ");
		int size = in.nextInt();
		autoPark.generateAutopark(size);
		System.out.println("Autopark Created!");
		waitAnim();
	}
	
	public void loadAutoPark() {
		newPage();
		autoPark.loadAutoPark();
		waitAnim();
	}
	
	public void saveAutoPark() {
		newPage();
		autoPark.saveAutoPark();
		waitAnim();
	}
	
	public void taxiServices() {
		newPage();
		System.out.println("\t������� ����");
		taxiService.showStatistic();
		System.out.println("1. �������� ������");
		System.out.println("2. ������ ������");
		System.out.println("3. �������� ������");
		System.out.println("4. ������ ������");
		System.out.println("0. �����");
	}
	
	public void showTariffs() {
		newPage();
		taxiService.showTariffs();
		System.out.println("0. �����");
	}
	
	public void changeTariffs() {
		newPage();
		taxiService.changeTariffs();
		System.out.println("������ ������!");
		waitAnim();
	}
	
	public void addTrip() {
		newPage();
		taxiService.addTrip();
		waitAnim();
	}
	
	public void tripHistory() {
		newPage();
		taxiService.tripHistory();
		System.out.println("\n0. �����");
	}
	
	public void about() {
		newPage();
		System.out.println("Taxi Manager");
		System.out.println("��������� - ������� �����������");
		System.out.println("����� - 1.0");
		System.out.println("�������� ��������������� ��� ����������");
		System.out.println("���������� ����������.");
	}
	
	private void newPage() {
		for(int i = 0; i < 25; i++) {
			System.out.println("\n");
		}
	}
	
	private void waitAnim() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
